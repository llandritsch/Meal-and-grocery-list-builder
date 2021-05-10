package persistence;

import entity.AuthenticationToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * DAO for authentication Token
 * @author lisaandritsch
 */
public class AuthenticationTokenDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * gets a token if there is one in the DB
     * @param token
     * @return token
     */
    public AuthenticationToken getByToken(String token) {
        if (token == null) {
            return null;
        }
        Session session = sessionFactory.openSession();
        AuthenticationToken authToken = session.get(AuthenticationToken.class, token);
        session.close();
        return authToken;
    }

    /**
     * Creates a token
     * @param userId
     * @return token
     */
    public AuthenticationToken create(int userId) {
        // Create a date that represents 30 minutes from now
        LocalDateTime dateTime = LocalDateTime.now().plus(Duration.of(30, ChronoUnit.MINUTES));
        Date expirationDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        AuthenticationToken token = new AuthenticationToken(
                UUID.randomUUID().toString(),
                userId,
                expirationDate
        );

        // Save the token to the database
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(token);
        transaction.commit();
        session.close();

        return token;
    }

    /**
     * Deletes a token
     * @param authToken
     */
    public void delete(AuthenticationToken authToken) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(authToken);
        transaction.commit();
        session.close();
    }
}

