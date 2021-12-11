/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.hrservices.Staff;
import business.suites.Suites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author deepv
 */
public class FlagClass {

    private String restaurantManagerName;
    private String userName;
    private String deliveryStaffName;
    private String customerName;
    private int id;
    private int suiteCount;
    private int premiumCount;
    private String imageFilePath;
    private String staffMemberName;
    private String eventName;
    private int foodCost;
    private List<String> foodItems;
    private Map<String, List<String>> seatsMap;
    private int ticketCount;
    private String suiteName;
    private int reservationCost;
    private Suites suites;

    public FlagClass() {
        foodItems = new ArrayList<>();
        seatsMap = new HashMap<>();
    }

    public String getRestaurantManagerName() {
        return restaurantManagerName;
    }

    public void setRestaurantManagerName(String restaurantManagerName) {
        this.restaurantManagerName = restaurantManagerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryStaffName() {
        return deliveryStaffName;
    }

    public void setDeliveryStaffName(String deliveryStaffName) {
        this.deliveryStaffName = deliveryStaffName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuiteCount() {
        return suiteCount;
    }

    public void setSuiteCount(int suiteCount) {
        this.suiteCount = suiteCount;
    }

    public int getPremiumCount() {
        return premiumCount;
    }

    public void setPremiumCount(int premiumCount) {
        this.premiumCount = premiumCount;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public String getStaffMemberName() {
        return staffMemberName;
    }

    public void setStaffMemberName(String staffMemberName) {
        this.staffMemberName = staffMemberName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(int foodCost) {
        this.foodCost = foodCost;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<String> foodItems) {
        this.foodItems = foodItems;
    }

    public Map<String, List<String>> getSeatsMap() {
        return seatsMap;
    }

    public void setSeatsMap(Map<String, List<String>> seatsMap) {
        this.seatsMap = seatsMap;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public int getReservationCost() {
        return reservationCost;
    }

    public void setReservationCost(int reservationCost) {
        this.reservationCost = reservationCost;
    }

    public Suites getSuites() {
        return suites;
    }

    public void setSuites(Suites suites) {
        this.suites = suites;
    }

}
