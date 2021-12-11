/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ticketing;

import java.util.ArrayList;

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingDirectory {
    private ArrayList<ParkingManager> ParkingManagerList;
    private ArrayList<Parking> parkingList= new ArrayList<Parking>();   
    public ArrayList<ParkingManager> getParkingList() {
        return ParkingManagerList;
    }

    public void setParkingList(ArrayList<ParkingManager> ParkingManagerList) {
        if(this.ParkingManagerList==null)
            ParkingManagerList = new ArrayList<ParkingManager>();
        this.ParkingManagerList = ParkingManagerList;
    }
    
    public ArrayList<Parking> getParkingVehiclesList() {
        return parkingList;
    }

    public void setParkingVehiclesList(ArrayList<Parking> ParkingList) {
        if(this.parkingList==null)
            parkingList = new ArrayList<Parking>();
        this.parkingList = ParkingList;
    }
    
    public ParkingManager findParking(String Name){
    for(ParkingManager parking:ParkingManagerList){
    if(parking.getParkingManagerName().equals(Name)){
    return parking;
    }
    }
    return null;
    }
    
    public Parking findParkingVehicle(String Number){
    for(Parking vehicle:parkingList){
    if(vehicle.getCarNumber().equals(Number)){
    return vehicle;
    }
    }
    return null;
    }
}
