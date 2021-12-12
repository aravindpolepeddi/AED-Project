/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.hrservices;

import business.premium.Premium;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deepv
 */
public class TechnicalServicesDirectory {

    private List<TechnicalServices> groundServices;

    public TechnicalServicesDirectory() {
        groundServices = new ArrayList<>();
    }

    public List<TechnicalServices> getGroundServices() {
        return groundServices;
    }

    public void setGroundServices(List<TechnicalServices> groundServices) {
        this.groundServices = groundServices;
    }

    public TechnicalServices addGroundService() {
        TechnicalServices groundService = new TechnicalServices();
        groundServices.add(groundService);
        return groundService;
    }

    /**
     * Return Premium object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public TechnicalServices findTechServiceByManagerName(String managerNames) {
        TechnicalServices groundService = groundServices.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return groundService;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeGroundService(TechnicalServices groundService) {
        groundServices.remove(groundService);
    }

}
