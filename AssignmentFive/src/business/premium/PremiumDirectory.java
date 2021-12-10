/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.premium;

import business.Restaurant.Restaurant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aravindpolepeddi
 */
public class PremiumDirectory {

    List<Premium> premiumList;
    int count;

    public PremiumDirectory() {
        premiumList = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Premium> getPremiumList() {
        return premiumList;
    }

    public void setPremiumList(List<Premium> premiumList) {
        this.premiumList = premiumList;
    }

    public Premium addPremium() {
        Premium premium = new Premium();
        premiumList.add(premium);
        return premium;
    }

    /**
     * Return Premium object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public Premium findPremiumByManagerName(String managerNames) {
        Premium premium = premiumList.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return premium;
    }

    /**
     * Method to remove the object from the directory
     * 
     * @param premium 
     */
    public void removePremium(Premium premium) {
        premiumList.remove(premium);
    }

}
