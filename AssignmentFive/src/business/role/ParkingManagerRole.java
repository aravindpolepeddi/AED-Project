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

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingManagerRole extends Role{
    
     public ParkingManagerRole() {
        this.type = Role.RoleType.ParkingManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        //change this
        //return new TicketingEntJPanel(userProcessContainer, account, business);
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
