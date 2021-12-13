/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ticketing;

import business.hrservices.CleaningServices;
import java.util.ArrayList;

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingDirectory {

    private ArrayList<ParkingManager> ParkingManagerList;
    private ArrayList<Parking> parkingList = new ArrayList<Parking>();

    public ParkingDirectory() {
        ParkingManagerList = new ArrayList<>();
        parkingList = new ArrayList<>();
    }

    public ArrayList<ParkingManager> getParkingManagerList() {
        return ParkingManagerList;
    }

    public void setParkingManagerList(ArrayList<ParkingManager> ParkingManagerList) {
        this.ParkingManagerList = ParkingManagerList;
    }

    public ArrayList<Parking> getParkingList() {
        return parkingList;
    }

    public void setParkingList(ArrayList<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    public ParkingManager findParking(String Name) {
        for (ParkingManager parking : ParkingManagerList) {
            if (parking.getParkingManagerName().equals(Name)) {
                return parking;
            }
        }
        return null;
    }

    public Parking findParkingVehicle(String Number) {
        for (Parking vehicle : parkingList) {
            if (vehicle.getCarNumber().equals(Number)) {
                return vehicle;
            }
        }
        return null;
    }

    public Parking addParking() {
        Parking parking = new Parking();
        parkingList.add(parking);
        return parking;
    }

    public ParkingManager addParkingManager() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingManagerList.add(parkingManager);
        return parkingManager;
    }
}
