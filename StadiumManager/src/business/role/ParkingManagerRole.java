/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Enterprises.TicketingEntJPanel;
import ui.Organization.FoodBev.PremiumRolePanel;
import ui.ticketing.ParkingJPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingManagerRole extends Role {

    public ParkingManagerRole() {
        this.type = Role.RoleType.TicketingAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new ParkingJPanel(userProcessContainer, account, business);
    }
}
