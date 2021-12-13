/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ticketing;

import business.Business;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class PickandDropManager extends Role {

    private String username;
    private String password;
    private String managerName;
    private Role role;

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
