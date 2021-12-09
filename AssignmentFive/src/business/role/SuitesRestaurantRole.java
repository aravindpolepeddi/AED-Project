/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Organization.FoodBev.PremiumRolePanel;
import ui.Organization.FoodBev.SuiteRolePanel;

/**
 *
 * @author deepv
 */
public class SuitesRestaurantRole extends Role {

    public SuitesRestaurantRole() {
        this.type = Role.RoleType.FoodBeverageEntAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new SuiteRolePanel(userProcessContainer, account, business);
    }
}
