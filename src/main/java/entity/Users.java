package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Represents Users
 *
 * @author lisaandritsch
 */
@Entity(name = "Users")
@Table(name = "Users")
public class Users {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Instantiates a new User.
     */
    public Users() {
    }

    /**
     * Instantiates a new User.
     *
     * @param username  the user name
     * @param password the password
     * @param id        the id
     */
    public Users(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return username;
    }

    /**
     * Sets user name.
     *
     * @param username the user name
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * gets password
     * @return password
     */
    public String getPassword() { return password; }

    /**
     * sets password
     * @param password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
