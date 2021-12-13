/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.merchandise;

import business.Enterprise;
import business.hrservices.CleaningServices;
import business.hrservices.Staff;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author aravindpolepeddi
 */
public class merchandiseShopDirectory {

    private ArrayList<merchandiseShop> merchandiseShopList;

    public merchandiseShopDirectory() {
        merchandiseShopList = new ArrayList<merchandiseShop>();
    }

    public ArrayList<merchandiseShop> getMerchandiseShopList() {
        return merchandiseShopList;
    }

    public void setMerchandiseShopList(ArrayList<merchandiseShop> merchandiseShopList) {
        this.merchandiseShopList = merchandiseShopList;
    }

    public merchandiseShop addShop() {
        merchandiseShop cleaningService = new merchandiseShop();
        merchandiseShopList.add(cleaningService);
        return cleaningService;
    }

    public merchandiseShop findMerchandiseShop(String MerchShopName) {
        for (merchandiseShop merchshop : merchandiseShopList) {
            if (merchshop.getUsername().equals(MerchShopName)) {
                return merchshop;
            }
        }
        return null;
    }

    /**
     * Return staff whose manager matches the input type
     *
     * @param managerNames
     * @return
     */
    public merchandiseShop findStaffByManager(String managerName) {
        merchandiseShop shop = merchandiseShopList.stream().filter(x -> x.getOwnerName().equals(managerName)).findAny().orElse(null);
        return shop;
    }

    public void deleteRestaurant(merchandiseShop merchshop) {
        merchandiseShopList.remove(merchshop);
    }

    public boolean checkIfUsernameIsUnique(String username) {
        if (merchandiseShopList == null) {
            merchandiseShopList = new ArrayList<merchandiseShop>();
            return true;
        }
        for (merchandiseShop merchshop : merchandiseShopList) {
            if (merchshop.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public void createMerchandiseshopAccount(merchandiseShop merchshop) {
        merchandiseShopList.add(merchshop);

    }
}
