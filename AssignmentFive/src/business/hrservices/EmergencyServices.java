/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.hrservices;

/**
 *
 * @author deepv
 */
public class EmergencyServices {

    private String managerName;
    private String userName;
    private String managerType;
    private int numOfAmbulances;
    private int numOfFireBrigades;
    private int numOfFirstAidKits;
    private int numOfAirAmbulance;
    private StaffDirectory staffDirectory;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public int getNumOfAmbulances() {
        return numOfAmbulances;
    }

    public void setNumOfAmbulances(int numOfAmbulances) {
        this.numOfAmbulances = numOfAmbulances;
    }

    public int getNumOfFireBrigades() {
        return numOfFireBrigades;
    }

    public void setNumOfFireBrigades(int numOfFireBrigades) {
        this.numOfFireBrigades = numOfFireBrigades;
    }

    public int getNumOfFirstAidKits() {
        return numOfFirstAidKits;
    }

    public void setNumOfFirstAidKits(int numOfFirstAidKits) {
        this.numOfFirstAidKits = numOfFirstAidKits;
    }

    public int getNumOfAirAmbulance() {
        return numOfAirAmbulance;
    }

    public void setNumOfAirAmbulance(int numOfAirAmbulance) {
        this.numOfAirAmbulance = numOfAirAmbulance;
    }

    public StaffDirectory getStaffDirectory() {
        return staffDirectory;
    }

    public void setStaffDirectory(StaffDirectory staffDirectory) {
        this.staffDirectory = staffDirectory;
    }

}
