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
    private String userName;

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
     * @param userName  the user name
     * @param password the password
     * @param id        the id
     */
    public Users(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

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
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
