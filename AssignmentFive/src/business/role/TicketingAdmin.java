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
import ui.Organization.FoodBev.SuiteRolePanel;

/**
 *
 * @author aravindpolepeddi
 */
public class TicketingAdmin extends Role {

    public TicketingAdmin() {
        this.type = Role.RoleType.TicketingAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new TicketingEntJPanel(userProcessContainer, account, business);
    }
}
