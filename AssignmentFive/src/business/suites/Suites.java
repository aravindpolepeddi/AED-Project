/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.suites;

import business.Restaurant.Menu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aravindpolepeddi
 */
public class Suites {

    String managerName;
    String userName;
    String managerType;
    private String cuisine;
    private String vegOrNonVeg;
    private Menu menu;
    private String restaurantName;
    private Map<String, List<String>> seats;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getVegOrNonVeg() {
        return vegOrNonVeg;
    }

    public void setVegOrNonVeg(String vegOrNonVeg) {
        this.vegOrNonVeg = vegOrNonVeg;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Map<String, List<String>> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, List<String>> seats) {
        this.seats = seats;
    }

}
