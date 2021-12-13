/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author deepv
 */
public class Order {

    private int id;
    private String customerName;
    private String restaurantName;
    private int cost;
    private ArrayList<String> foodItems;
    private Date orderDateTime;
    private String status;
    private HashMap<String, String> reviewComments;
    private String deliveryStaffName;
    private int orderRating;
    private String customerAddress;

//    public Order() {
//        if (this.deliveryStaffName == null) {
//            this.deliveryStaffName = "";
//        } else {
//            this.deliveryStaffName = deliveryStaffName;
//        }
//    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<String> foodItems) {
        this.foodItems = foodItems;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, String> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(HashMap<String, String> reviewComments) {
        this.reviewComments = reviewComments;
    }

    public String getDeliveryStaffName() {
        return deliveryStaffName;
    }

    public void setDeliveryStaffName(String deliveryStaffName) {
        this.deliveryStaffName = deliveryStaffName;
    }

    public int getOrderRating() {
        return orderRating;
    }

    public void setOrderRating(int orderRating) {
        this.orderRating = orderRating;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
