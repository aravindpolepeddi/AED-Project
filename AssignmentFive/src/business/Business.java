/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Customer.CustomerDirectory;
import business.Order.Order;
import business.Order.OrderDirectory;
import business.Restaurant.RestaurantDirectory;
import business.concessions.ConcessionsDirectory;
import business.event.EventDirectory;
import business.hrservices.CleaningServicesDirectory;
import business.hrservices.EmergencyServicesDirectory;
import business.hrservices.TechnicalServicesDirectory;
import business.hrservices.SecurityServices;
import business.hrservices.SecurityServicesDirectory;
import business.organizations.FoodBevOrganization;
import business.premium.PremiumDirectory;
import business.role.Role;
import business.role.SystemAdminRole;
import business.suites.SuitesDirectory;
import business.useraccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author deepv
 */
public class Business extends Organization {

    private static Business business;
    private RestaurantDirectory restaurantDirectory;
    private CustomerDirectory customerDirectory;
    private OrderDirectory orderDirectory;
    private ConcessionsDirectory concessionsDirectory;
    private PremiumDirectory premiumDirectory;
    private SuitesDirectory suitesDirectory;
    private CleaningServicesDirectory cleaningServices;
    private EmergencyServicesDirectory emergencyServices;
    private TechnicalServicesDirectory technicalServices;
    private SecurityServicesDirectory securityServices;
    private EventDirectory eventDirectory;

    public PremiumDirectory getPremiumDirectory() {
        return premiumDirectory;
    }

    public void setPremiumDirectory(PremiumDirectory premiumDirectory) {
        this.premiumDirectory = premiumDirectory;
    }

    public SuitesDirectory getSuitesDirectory() {
        return suitesDirectory;
    }

    public void setSuitesDirectory(SuitesDirectory suitesDirectory) {
        this.suitesDirectory = suitesDirectory;
    }

    public EventDirectory getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(EventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }

    public ConcessionsDirectory getConcessionsDirectory() {
        return concessionsDirectory;
    }

    public void setConcessionsDirectory(ConcessionsDirectory concessionsDirectory) {
        this.concessionsDirectory = concessionsDirectory;
    }

    public CleaningServicesDirectory getCleaningServices() {
        return cleaningServices;
    }

    public void setCleaningServices(CleaningServicesDirectory cleaningServices) {
        this.cleaningServices = cleaningServices;
    }

    public EmergencyServicesDirectory getEmergencyServices() {
        return emergencyServices;
    }

    public void setEmergencyServices(EmergencyServicesDirectory emergencyServices) {
        this.emergencyServices = emergencyServices;
    }

    public TechnicalServicesDirectory getTechnicalServices() {
        return technicalServices;
    }

    public void setTechnicalServices(TechnicalServicesDirectory technicalServices) {
        this.technicalServices = technicalServices;
    }

    public SecurityServicesDirectory getSecurityServices() {
        return securityServices;
    }

    public void setSecurityServices(SecurityServicesDirectory securityServices) {
        this.securityServices = securityServices;
    }
    
    

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    private Business() {
        super(null);
        eventDirectory = new EventDirectory();
        // networkList=new ArrayList<Network>();
    }

    public boolean checkIfUserIsUnique(String userName) {
        //
        return false;
    }

    public static Business getBusiness() {
        return business;
    }

    public static void setBusiness(Business business) {
        Business.business = business;
    }

    public RestaurantDirectory getRestaurantDirectory() {
        return restaurantDirectory;
    }

    public void setRestaurantDirectory(RestaurantDirectory restaurantDirectory) {
        this.restaurantDirectory = restaurantDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

}
