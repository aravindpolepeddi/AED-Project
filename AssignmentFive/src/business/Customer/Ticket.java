/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author deepv
 */
public class Ticket {

    private int id;
    private String eventName;
    private String count;
    private String seatType;
    private ArrayList<String> foodItems;
    private HashMap<String, List<String>> seats;
    private int foodCost;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<String> foodItems) {
        this.foodItems = foodItems;
    }

    public HashMap<String, List<String>> getSeats() {
        return seats;
    }

    public void setSeats(HashMap<String, List<String>> seats) {
        this.seats = seats;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(int foodCost) {
        this.foodCost = foodCost;
    }

}
