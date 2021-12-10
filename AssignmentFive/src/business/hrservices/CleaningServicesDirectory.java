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
public class CleaningServicesDirectory {

    private List<CleaningServices> cleaningServices;

    public CleaningServicesDirectory() {
        cleaningServices = new ArrayList<>();
    }

    public List<CleaningServices> getCleaningServices() {
        return cleaningServices;
    }

    public void setCleaningServices(List<CleaningServices> cleaningServices) {
        this.cleaningServices = cleaningServices;
    }

    public CleaningServices addCleaningService() {
        CleaningServices cleaningService = new CleaningServices();
        cleaningServices.add(cleaningService);
        return cleaningService;
    }

    /**
     * Return Premium object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public CleaningServices findCleaningServiceByManagerName(String managerNames) {
        CleaningServices cleaningService = cleaningServices.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return cleaningService;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeCleaningService(CleaningServices cleaningService) {
        cleaningServices.remove(cleaningService);
    }

}
