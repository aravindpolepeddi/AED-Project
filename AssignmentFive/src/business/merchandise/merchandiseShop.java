/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.merchandise;

import business.hrservices.CleaningServices;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author aravindpolepeddi
 */
public class merchandiseShop {

    private String MerchandiseShopName;
    private String OwnerName;
    private String username;
    private String password;
    private ArrayList<merchandise> merchandiseMenu;

    public merchandiseShop() {
        merchandiseMenu = new ArrayList<>();
    }

    public ArrayList<merchandise> getMerchandiseMenu() {
        return merchandiseMenu;
    }

    public void setMerchandiseMenu(ArrayList<merchandise> merchandiseMenu) {
        this.merchandiseMenu = merchandiseMenu;
    }
    private Role role;
    private int id;
    private static int count = 1;

    public String getMerchandiseShopName() {
        return MerchandiseShopName;
    }

    public void setMerchandiseShopName(String MerchandiseShopName) {
        this.MerchandiseShopName = MerchandiseShopName;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        merchandiseShop.count = count;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public merchandise findItem(String name, int price) {
        for (merchandise i : merchandiseMenu) {
            if (i.getItemName() == name && i.getPrice() == price) {
                return i;
            }
        }
        return null;
    }

    public void addMerchandise(merchandise item) {
        merchandiseMenu.add(item);
    }

    public void removeItem(merchandise item) {
        merchandiseMenu.remove(item);
    }

}
