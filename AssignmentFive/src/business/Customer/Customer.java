/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import business.Person;

/**
 *
 * @author deepv
 */
public class Customer extends Person {

    private String userName;
    private String address;
    private Ticket ticket;
    private int merchCost;
    private int pickDropCost;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getMerchCost() {
        return merchCost;
    }

    public void setMerchCost(int merchCost) {
        this.merchCost = merchCost;
    }

    public int getPickDropCost() {
        return pickDropCost;
    }

    public void setPickDropCost(int pickDropCost) {
        this.pickDropCost = pickDropCost;
    }

}
