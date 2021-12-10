/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.Customer.CustomerDirectory;
import business.Order.OrderDirectory;
import business.Restaurant.RestaurantDirectory;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Concessions.ConcessionsAreaJPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class ConcessionsManagerRole extends Role {
    
        public ConcessionsManagerRole() {
        this.type = RoleType.ConcessionsManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new ConcessionsAreaJPanel(userProcessContainer, account, business);
    }
    
}
