/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.Customer.CustomerDirectory;
import business.DeliveryStaff.DeliveryStaffDirectory;
import business.Order.Order;
import business.Order.OrderDirectory;
import business.Restaurant.RestaurantDirectory;
import business.role.Role.RoleType;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.CustomerRole.CustomerAreaJPanel;

/**
 *
 * @author deepv
 */
public class Customer extends Role {

    public Customer() {
        this.type = RoleType.Customer;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new CustomerAreaJPanel(userProcessContainer, account, business);
    }

}
