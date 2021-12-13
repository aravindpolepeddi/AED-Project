/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.role.FoodBeverageEntAdminRole;
import business.role.HumanResourceEntAdmin;
import business.role.SystemAdminRole;
import business.role.TicketingAdmin;
import business.role.merchandiseShopOwner;
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
        UserAccount testAccount = new UserAccount("sysadmin", "sysadmin", "Aravind", new SystemAdminRole(), null);
        userAccList.add(testAccount);

        UserAccount testAccount1 = new UserAccount("food", "food", "Aravind", new FoodBeverageEntAdminRole(), null);
        userAccList.add(testAccount1);

        UserAccount testAccount2 = new UserAccount("merch", "merch", "Aravind", new merchandiseShopOwner(), null);
        userAccList.add(testAccount2);

        UserAccount testAccount3 = new UserAccount("booking", "booking", "Aravind", new TicketingAdmin(), null);
        userAccList.add(testAccount3);

        UserAccount testAccount4 = new UserAccount("hr", "hr", "Aravind", new HumanResourceEntAdmin(), null);
        userAccList.add(testAccount4);

        system.getUserAccountDirectory().setUserAccountList(userAccList);
        return system;
    }
}
