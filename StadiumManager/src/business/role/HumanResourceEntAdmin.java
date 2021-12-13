/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Enterprises.BookingEntJPanel;
import ui.Enterprises.HumanResourcesEntJPanel;

/**
 *
 * @author deepv
 */
public class HumanResourceEntAdmin extends Role {

    public HumanResourceEntAdmin() {
        this.type = Role.RoleType.HumanResourceEntAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new HumanResourcesEntJPanel(userProcessContainer, account, business);
    }
}
