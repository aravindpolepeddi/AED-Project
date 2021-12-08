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
public class GroundServicesDirectory {

    private List<GroundServices> groundServices;

    public GroundServicesDirectory() {
        groundServices = new ArrayList<>();
    }

    public List<GroundServices> getGroundServices() {
        return groundServices;
    }

    public void setGroundServices(List<GroundServices> groundServices) {
        this.groundServices = groundServices;
    }

    public GroundServices addGroundService() {
        GroundServices groundService = new GroundServices();
        groundServices.add(groundService);
        return groundService;
    }

    /**
     * Return Premium object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public GroundServices findGroundServiceByManagerName(String managerNames) {
        GroundServices groundService = groundServices.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return groundService;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeGroundService(GroundServices groundService) {
        groundServices.remove(groundService);
    }

}
