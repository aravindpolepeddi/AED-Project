/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.DeliveryStaff;

import business.Person;

/**
 *
 * @author deepv
 */
public class DeliveryStaff extends Person {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

}
