/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Organization.HR.CleaningServicesJPanel;
import ui.Organization.HR.EmergencyServicesJPanel;

/**
 *
 * @author deepv
 */
public class EmergencyServicesRole extends Role {

    public EmergencyServicesRole() {
        this.type = Role.RoleType.HumanResourceEntAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new EmergencyServicesJPanel(userProcessContainer, account, business);
    }
}
