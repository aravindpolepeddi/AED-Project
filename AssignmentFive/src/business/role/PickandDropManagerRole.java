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
import ui.ticketing.PickandDropJPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class PickandDropManagerRole extends Role{
 
         public PickandDropManagerRole() {
        this.type = Role.RoleType.PickandDropManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        
        return new PickandDropJPanel(userProcessContainer, account, business);
    }
    
}
