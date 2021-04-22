package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
    CREATE TABLE authentication_tokens (
            token VARCHAR(300) NOT NULL PRIMARY KEY,
            userId INT(6) UNSIGNED NOT NULL,
            expiresAt DATETIME NOT NULL
    )
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

    public AuthenticationToken() {}

    public AuthenticationToken(String token, int userId, Date expiresAt) {
        this.token = token;
        this.userId = userId;
        this.expiresAt = expiresAt;
    }

    public String getToken() { return this.token; }
    public void setToken(String token) { this.token = token; }

    public int getUserId() { return this.userId; }
    public void setUserId(int id) { this.userId = id; }

    public Date getExpiresAt() { return this.expiresAt; }
    public void setExpiresAt(Date expires) { this.expiresAt = expires; }

    public boolean isExpired() {
        // return true if now() is greater than expiresAt
        return false;
    }

    @Override
    public String toString() {
        return "AuthenticationToken{" +
                "token=" + this.token +
                ", expiresAt ='" + this.expiresAt + ' ' +
                ", expired? = " + this.isExpired() + ' ' +
                '}';
    }

}
