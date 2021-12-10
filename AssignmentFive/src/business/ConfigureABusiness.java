/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.role.BookingEntAdminRole;
import business.role.Customer;
import business.role.FoodBeverageEntAdminRole;
import business.role.HumanResourceEntAdmin;
import business.role.MerchendiseEntAdminRole;
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
        UserAccount testAccount = new UserAccount("sysadmin", "sysadmin", "Aravind", new SystemAdminRole());
        userAccList.add(testAccount);

        UserAccount testAccount1 = new UserAccount("food", "food", "Aravind", new FoodBeverageEntAdminRole());
        userAccList.add(testAccount1);

        UserAccount testAccount2 = new UserAccount("merch", "merch", "Aravind", new MerchendiseEntAdminRole());
        userAccList.add(testAccount2);

        UserAccount testAccount3 = new UserAccount("booking", "booking", "Aravind", new BookingEntAdminRole());
        userAccList.add(testAccount3);

        UserAccount testAccount4 = new UserAccount("hr", "hr", "Aravind", new HumanResourceEntAdmin());
        userAccList.add(testAccount4);
        
        system.getUserAccountDirectory().setUserAccountList(userAccList);
        
//        if (!system.getUserAccountDirectory().getUserAccountList().contains(testAccount)) system.getUserAccountDirectory().getUserAccountList().add(testAccount);
//        if (!system.getUserAccountDirectory().getUserAccountList().contains(testAccount1)) system.getUserAccountDirectory().getUserAccountList().add(testAccount1);
//        if (!system.getUserAccountDirectory().getUserAccountList().contains(testAccount2)) system.getUserAccountDirectory().getUserAccountList().add(testAccount2);
//        if (!system.getUserAccountDirectory().getUserAccountList().contains(testAccount3)) system.getUserAccountDirectory().getUserAccountList().add(testAccount3);
//        if (!system.getUserAccountDirectory().getUserAccountList().contains(testAccount4)) system.getUserAccountDirectory().getUserAccountList().add(testAccount4);

        return system;
    }
}
