package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents user macro goals
 *
 * @author lisaandritsch
 */
@Entity(name = "UserGoals")
@Table(name = "User_Macro_Goals")
public class UserGoals {
    @Column(name = "protein_goal")
    private int proteinGoal;

    @Column(name = "carb_goal")
    private int carbGoal;

    @Column(name = "fat_goal")
    private int fatGoal;

    @Column(name = "calorie_goal")
    private int calorieGoal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    private int userid;

    /**
     * Instantiates new userGoal
     */
    public UserGoals() {
    }

    /**
     * instantiates new UserGoal
     * @param proteinGoal
     * @param carbGoal
     * @param fatGoal
     * @param calorieGoal
     * @param id
     * @param user
     */
    public UserGoals(int proteinGoal, int carbGoal, int fatGoal, int calorieGoal, Users user,int id) {
        this.user = user;
        this.proteinGoal = proteinGoal;
        this.carbGoal = carbGoal;
        this.fatGoal = fatGoal;
        this.calorieGoal = calorieGoal;
        this.id = id;
    }

    /**
     * gets userid
     * @return userid
     */
    public int getUserid() {
        return user.getId();
    }

    /**
     * sets userid
     * @param userid
     */
    public void setUserid(int userid) {
        this.userid = getUserid();
    }

    /**
     * Gets proteinGoal
     * @return proteinGoal
     */
    public int getProteinGoal() {
        return proteinGoal;
    }

    /**
     * Sets proteinGoal
     * @param proteinGoal
     */
    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    /**
     * gets carb goal
     * @return carbGoal
     */
    public int getCarbGoal() {
        return carbGoal;
    }

    /**
     * sets carbGoal
     * @param carbGoal
     */
    public void setCarbGoal(int carbGoal) {
        this.carbGoal = carbGoal;
    }

    /**
     * gets fat goal
     * @return
     */
    public int getFatGoal() {
        return fatGoal;
    }

    /**
     * sets fat goal
     * @param fatGoal
     */
    public void setFatGoal(int fatGoal) {
        this.fatGoal = fatGoal;
    }

    /**
     * gets calorie goal
     * @return
     */
    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(Users user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "User Goals{" +
                "goal id=" + id +
                ", calorie goal='" + calorieGoal +
                ", protein goal=" + proteinGoal +
                ", carb goal=" + carbGoal +
                ", fat goal=" + fatGoal +
                ", userid=" + userid +
                '}';
    }


}
