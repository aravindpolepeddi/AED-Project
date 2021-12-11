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
public class PickandDropDirectory {
 
    private ArrayList<PickandDropManager> PdList;
    private ArrayList<CarBooking> carBookingList;

    public ArrayList<CarBooking> getCarBookingList() {
        return carBookingList;
    }

    public void setCarBookingList(ArrayList<CarBooking> carBookingList) {
        this.carBookingList = carBookingList;
    }

    public ArrayList<PickandDropManager> getPdList() {
        return PdList;
    }

    public void setPdList(ArrayList<PickandDropManager> PdList) {
        this.PdList = PdList;
    }
    
    public PickandDropManager findPickandDrop(String Name){
    for(PickandDropManager pd:PdList){
    if(pd.getManagerName().equals(Name)){
    return pd;
    }
    }
    return null;
    }
    
    public CarBooking findCarBooking(String Name){
    for(CarBooking cb:carBookingList){
    if(cb.getCustomerName().equals(Name)){
    return cb;
    }
    }
    return null;
    }
    
}
