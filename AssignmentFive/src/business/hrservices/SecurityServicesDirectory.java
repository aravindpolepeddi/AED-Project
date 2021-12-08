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
public class SecurityServicesDirectory {

    private List<SecurityServices> securityServices;

    public SecurityServicesDirectory() {
        securityServices = new ArrayList<>();
    }

    public List<SecurityServices> getSecurityServices() {
        return securityServices;
    }

    public void setSecurityServices(List<SecurityServices> securityServices) {
        this.securityServices = securityServices;
    }

    public SecurityServices addSecurityService() {
        SecurityServices securityService = new SecurityServices();
        securityServices.add(securityService);
        return securityService;
    }

    /**
     * Return Premium object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public SecurityServices findSecurityServiceByManagerName(String managerNames) {
        SecurityServices securityService = securityServices.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return securityService;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeSecurityService(SecurityServices securityService) {
        securityServices.remove(securityService);
    }

}
