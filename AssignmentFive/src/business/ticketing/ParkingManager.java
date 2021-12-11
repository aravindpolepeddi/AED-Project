/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ticketing;

import business.Business;
import business.role.Role;
import business.useraccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingManager extends Role{
    
    private String ParkingLevel;
    private String ParkingManagerName;
    private int ParkingCapacity;
    private String username;
    private String password;
    private Role role;
    private int id;
    
           

    public String getParkingLevel() {
        return ParkingLevel;
    }

    public void setParkingLevel(String ParkingLevel) {
        this.ParkingLevel = ParkingLevel;
    }

    public String getParkingManagerName() {
        return ParkingManagerName;
    }

    public void setParkingManagerName(String ParkingManagerName) {
        this.ParkingManagerName = ParkingManagerName;
    }

    public int getParkingCapacity() {
        return ParkingCapacity;
    }

    public void setParkingCapacity(int ParkingCapacity) {
        this.ParkingCapacity = ParkingCapacity;
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
    
            public ParkingManager() {
        this.type = Role.RoleType.ParkingManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
