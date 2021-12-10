/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.hrservices.Staff;

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

}
