/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.Customer.CustomerDirectory;
import business.Order.Order;
import business.Order.OrderDirectory;
import business.Restaurant.RestaurantDirectory;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author deepv
 */
public abstract class Role {

    public enum RoleType {
        RestaurantAdmin("RestaurantAdmin"),
        Customer("Customer"),
        DeliveryMan("Delivery"),
        ConcessionsManager("ConcessionsManager"),
        PremiumManager("PremiumManager"),
        SuitesManager("SuitesManager"),
        KitchenManager("KitchenManager"),
        Vendor("Vendor"),
        SysAdmin("Sysadmin"),
        FoodBeverageEntAdmin("FoodBevEntAdmin"),
        MerchendiseEntAdmin("MerchendiseEntAdmin"),
        BookingEntAdmin("BookingEntAdmin"),
        HumanResourceEntAdmin("HumanResourceEntAdmin"),
        FoodBevOrgAdmin("FoodBevOrgAdmin"),
        SuitesRestaurantRole("SuitesRestaurantRole"),
        CleaningServicesRole("CleaningServicesRole"),
        EmergencyServicesRole("EmergencyServicesRole"),
        SecurityServicesRole("SecurityServicesRole"),
        TechnicalServicesRole("TechnicalServicesRole");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public RoleType type;

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Business business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
