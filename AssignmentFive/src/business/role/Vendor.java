/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.Customer.CustomerDirectory;
import business.DeliveryStaff.DeliveryStaffDirectory;
import business.Order.OrderDirectory;
import business.Restaurant.RestaurantDirectory;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Vendor.VendorAreaJPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class Vendor extends Role {
           public Vendor() {
        this.type = Role.RoleType.Vendor;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new VendorAreaJPanel(userProcessContainer, account, business);
    } 
}
