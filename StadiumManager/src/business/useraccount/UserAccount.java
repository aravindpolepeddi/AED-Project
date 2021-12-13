/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.role.Role;

/**
 *
 * @author deepv
 */
public class UserAccount {

    private String username;
    private String password;
    private Role role;
    private String name;
    private String network;

    public UserAccount(String username, String password, String name,
            Role role, String network) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.network = network;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    @Override
    public String toString() {
        return username;
    }

}
