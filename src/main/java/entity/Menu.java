package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Represents Menu
 *
 * @author lisaandritsch
 */
@Entity(name = "Menu")
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "userId")
    private int userId;

    @ManyToMany(cascade = { CascadeType.ALL }, targetEntity = Recipes.class, fetch = FetchType.EAGER)
    @JoinTable(name = "menus_recipes",
            joinColumns = {@JoinColumn(name = "menuId")},
            inverseJoinColumns = {@JoinColumn(name = "recipeId")})
    private Set<Recipes> recipes = new HashSet<>();

    /**
     * Instantiates new menu
     */
    public Menu() { }

    /**
     * constructor with params
     * @param id
     * @param userId
     */
    public Menu(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    /**
     * gets Id
     * @return
     */
    public int getId() { return this.id; }

    /**
     * sets Id
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     * gets UserId
     * @return
     */
    public int getUserId() { return this.userId; }

    /**
     * sets UserId
     * @param id
     */
    public void setUserId(int id) { this.userId = id; }

    /**
     * gets recipes
     * @return
     */
    public Set<Recipes> getRecipes() { return this.recipes; }
}
