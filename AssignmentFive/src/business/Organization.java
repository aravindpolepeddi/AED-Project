/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.role.Role;
import business.useraccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author deepv
 */
public abstract class Organization {

    private String name;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter = 0;
   

    public enum Type {
        RestaurantAdmin("RestaurantAdmin"),
        Customer("Customer"),
        DeliveryMan("Delivery"),
        ConcessionsManager("ConcessionsManager"),
        PremiumManager("PremiumManager"),
        SuitesManager("SuitesManager"),
        KitchenManager("KitchenManager"),
        Vendor("Vendor"),
        SysAdmin("Sysadmin");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public Organization() {

    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
