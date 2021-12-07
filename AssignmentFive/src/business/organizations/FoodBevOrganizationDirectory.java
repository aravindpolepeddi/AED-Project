/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organizations;

import business.premium.PremiumDirectory;
import business.suites.SuitesDirectory;
import java.util.List;

/**
 *
 * @author deepv
 */
public class FoodBevOrganizationDirectory {

    private List<FoodBevOrganization> foodBevOrg;

    public List<FoodBevOrganization> getFoodBevOrg() {
        return foodBevOrg;
    }

    public void setFoodBevOrg(List<FoodBevOrganization> foodBevOrg) {
        this.foodBevOrg = foodBevOrg;
    }

}
