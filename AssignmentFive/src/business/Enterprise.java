/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Customer.CustomerDirectory;
import business.Customer.TicketDirectory;
import business.Enterprises.EnterpriseDirectory;
import business.Order.OrderDirectory;
import business.Restaurant.RestaurantDirectory;
import business.concessions.ConcessionsDirectory;
import business.event.EventDirectory;
import business.hrservices.CleaningServicesDirectory;
import business.hrservices.EmergencyServicesDirectory;
import business.hrservices.SecurityServicesDirectory;
import business.hrservices.TechnicalServicesDirectory;
import business.merchandise.merchandiseShopDirectory;
import business.premium.PremiumDirectory;
import business.suites.SuitesDirectory;
import business.ticketing.ParkingDirectory;
import business.ticketing.PickandDropDirectory;

/**
 *
 * @author deepv
 */
public class Enterprise {

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
    private TicketDirectory ticketDirectory;
    private EnterpriseDirectory enterpriseDirectory;
    private merchandiseShopDirectory merchandiseShopDirectory;
    private ParkingDirectory parkingDirectory;
    private PickandDropDirectory pdDirectory;

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

    public ConcessionsDirectory getConcessionsDirectory() {
        return concessionsDirectory;
    }

    public void setConcessionsDirectory(ConcessionsDirectory concessionsDirectory) {
        this.concessionsDirectory = concessionsDirectory;
    }

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

    public EventDirectory getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(EventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }

    public TicketDirectory getTicketDirectory() {
        return ticketDirectory;
    }

    public void setTicketDirectory(TicketDirectory ticketDirectory) {
        this.ticketDirectory = ticketDirectory;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public merchandiseShopDirectory getMerchandiseShopDirectory() {
        return merchandiseShopDirectory;
    }

    public void setMerchandiseShopDirectory(merchandiseShopDirectory merchandiseShopDirectory) {
        this.merchandiseShopDirectory = merchandiseShopDirectory;
    }

    public ParkingDirectory getParkingDirectory() {
        return parkingDirectory;
    }

    public void setParkingDirectory(ParkingDirectory parkingDirectory) {
        this.parkingDirectory = parkingDirectory;
    }

    public PickandDropDirectory getPdDirectory() {
        return pdDirectory;
    }

    public void setPdDirectory(PickandDropDirectory pdDirectory) {
        this.pdDirectory = pdDirectory;
    }

}
