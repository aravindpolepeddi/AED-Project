/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organizations;

import business.premium.PremiumDirectory;
import business.suites.SuitesDirectory;

/**
 *
 * @author deepv
 */
public class FoodBevOrganization {

    private SuitesDirectory suitsDirectory;
    private PremiumDirectory premiumDirectory;

    public SuitesDirectory getSuitsDirectory() {
        return suitsDirectory;
    }

    public void setSuitsDirectory(SuitesDirectory suitsDirectory) {
        this.suitsDirectory = suitsDirectory;
    }

    public PremiumDirectory getPremiumDirectory() {
        return premiumDirectory;
    }

    public void setPremiumDirectory(PremiumDirectory premiumDirectory) {
        this.premiumDirectory = premiumDirectory;
    }

}
