package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Represents authentication token
 * @author lisaandritsch
 */
@Entity(name = "AuthenticationToken")
@Table(name = "authentication_tokens")
public class AuthenticationToken {
    @Id
    @Column(name = "token")
    private String token;

    @Column(name = "expiresAt")
    private Date expiresAt;

    @Column(name = "userId")
    private int userId;

    /**
     * No Arg constructor
     */
    public AuthenticationToken() {}

    /**
     * Constructor
     * @param token
     * @param userId
     * @param expiresAt
     */
    public AuthenticationToken(String token, int userId, Date expiresAt) {
        this.token = token;
        this.userId = userId;
        this.expiresAt = expiresAt;
    }

    /**
     * gets token
     * @return token
     */
    public String getToken() { return this.token; }

    /**
     * sets token
     * @param token
     */
    public void setToken(String token) { this.token = token; }

    /**
     * gets userId
     * @return userId
     */
    public int getUserId() { return this.userId; }

    /**
     * sets userId
     * @param id
     */
    public void setUserId(int id) { this.userId = id; }

    /**
     * gets expiration time of token
     * @return expiresAt
     */
    public Date getExpiresAt() { return this.expiresAt; }

    /**
     * sets expiration time
     * @param expires
     */
    public void setExpiresAt(Date expires) { this.expiresAt = expires; }

    /**
     * checks if token is expired
     * @return
     */
    public boolean isExpired() {
        // return true if now() is greater than expiresAt
        return false;
    }

    /**
     * To string for token
     * @return
     */
    @Override
    public String toString() {
        return "AuthenticationToken{" +
                "token=" + this.token +
                ", expiresAt ='" + this.expiresAt + ' ' +
                ", expired? = " + this.isExpired() + ' ' +
                '}';
    }

}
