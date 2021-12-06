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
import ui.Suites.SuitesAreaJPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class SuitesManagerRole extends Role {
    
        public SuitesManagerRole() {
        this.type = Role.RoleType.PremiumManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new SuitesAreaJPanel(userProcessContainer, account, business);
    }
    
}
