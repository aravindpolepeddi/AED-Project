/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Restaurant;

import java.util.HashMap;

/**
 *
 * @author deepv
 */
public class Menu {

    private HashMap<String, Integer> apetizers;
    private HashMap<String, Integer> mains;
    private HashMap<String, Integer> dessert;
    private HashMap<String, Integer> beverages;

    public HashMap<String, Integer> getApetizers() {
        return apetizers;
    }

    public void setApetizers(HashMap<String, Integer> apetizers) {
        this.apetizers = apetizers;
    }

    public HashMap<String, Integer> getMains() {
        return mains;
    }

    public void setMains(HashMap<String, Integer> mains) {
        this.mains = mains;
    }

    public HashMap<String, Integer> getDessert() {
        return dessert;
    }

    public void setDessert(HashMap<String, Integer> dessert) {
        this.dessert = dessert;
    }

    public HashMap<String, Integer> getBeverages() {
        return beverages;
    }

    public void setBeverages(HashMap<String, Integer> beverages) {
        this.beverages = beverages;
    }

}
