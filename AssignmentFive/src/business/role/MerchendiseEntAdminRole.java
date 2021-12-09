/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Enterprises.FoodBevEntJPanel;
import ui.Enterprises.MerchendiseEntJPanel;


/**
 *
 * @author deepv
 */
public class MerchendiseEntAdminRole extends Role {

    public MerchendiseEntAdminRole() {
        this.type = Role.RoleType.MerchendiseEntAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new MerchendiseEntJPanel(userProcessContainer, account, business);
    }
}
