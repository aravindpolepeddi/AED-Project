/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ticketing;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aravindpolepeddi
 */
public class Parking {
    
    private String CarNumber;
    private Date EnteredTie;
    private Date ExitTime;
    private int SlotNumber;
    private int TicketNumber;
    private int Price;
     

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String CarNumber) {
        this.CarNumber = CarNumber;
    }

    public Date getEnteredTie() {
        return EnteredTie;
    }

    public void setEnteredTie(Date EnteredTie) {
        this.EnteredTie = EnteredTie;
    }

    public Date getExitTime() {
        return ExitTime;
    }

    public void setExitTime(Date ExitTime) {
        this.ExitTime = ExitTime;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int SlotNumber) {
        this.SlotNumber = SlotNumber;
    }

    public int getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(int TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
}
