/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.Merchandise.MerchandiseMenuJPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class merchandiseShopOwner extends Role {
 
        public merchandiseShopOwner() {
        this.type = RoleType.merchandiseShop;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        return new MerchandiseMenuJPanel(userProcessContainer, account, business);
    }

    
}
