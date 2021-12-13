/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Restaurant;

import java.util.HashMap;

/**
 *
 * @author deepv
 */
public class Restaurant {

    private String name;
    private String address;
    private String cuisine;
    private String managerName;
    private String vegOrNonVeg;
    private Menu menu;
    private String phoneNumber;
    private String emailId;
    private HashMap<String, String> reviewComments;
    private double averageRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public HashMap<String, String> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(HashMap<String, String> reviewComments) {
        this.reviewComments = reviewComments;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return name;
    }

}
