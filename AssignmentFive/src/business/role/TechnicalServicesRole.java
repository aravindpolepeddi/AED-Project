/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Organization.HR.SecurityServicesJPanel;
import ui.Organization.HR.TechnicalServicesJPanel;

/**
 *
 * @author deepv
 */
public class TechnicalServicesRole extends Role {

    public TechnicalServicesRole() {
        this.type = Role.RoleType.HumanResourceEntAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new TechnicalServicesJPanel(userProcessContainer, account, business);
    }
}
