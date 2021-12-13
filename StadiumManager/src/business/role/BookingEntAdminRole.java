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
import ui.Enterprises.FoodBevEntJPanel;

/**
 *
 * @author deepv
 */
public class BookingEntAdminRole extends Role {
     public BookingEntAdminRole() {
        this.type = Role.RoleType.BookingEntAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new BookingEntJPanel(userProcessContainer, account, business);
    }
}
