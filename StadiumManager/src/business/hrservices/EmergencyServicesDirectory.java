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
public class EmergencyServicesDirectory {

    private List<EmergencyServices> emergencyServices;

    public EmergencyServicesDirectory() {
        emergencyServices = new ArrayList<>();
    }

    public List<EmergencyServices> getEmergencyServices() {
        return emergencyServices;
    }

    public void setEmergencyServices(List<EmergencyServices> emergencyServices) {
        this.emergencyServices = emergencyServices;
    }

    public EmergencyServices addEmergencyService() {
        EmergencyServices emergencyService = new EmergencyServices();
        emergencyServices.add(emergencyService);
        return emergencyService;
    }

    /**
     * Return Premium object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public EmergencyServices findEmergencyServiceByManagerName(String managerNames) {
        EmergencyServices emergencyService = emergencyServices.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return emergencyService;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeEmergencyService(EmergencyServices emergencyService) {
        emergencyServices.remove(emergencyService);
    }

}
