/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.role.Customer;
import business.role.RestaurantRole;
import business.role.SystemAdminRole;
import business.useraccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author deepv
 */
public class ConfigureABusiness {

    public static Business configure() {

        Business system = Business.getInstance();
        ArrayList<UserAccount> userAccList = new ArrayList<>();
        UserAccount testAccount = new UserAccount("admin", "admin", "Aravind", new SystemAdminRole());
        userAccList.add(testAccount);
        system.getUserAccountDirectory().getUserAccountList().add(testAccount);

        return system;
    }
}
