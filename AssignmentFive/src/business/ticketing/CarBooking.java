/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ticketing;

/**
 *
 * @author aravindpolepeddi
 */
public class CarBooking {

    private String PickupPoint;
    private int CarNumber;
    private String CustomerName;
    private Boolean twoWay;
    private int Price;
    private String Status;

    public String getPickupPoint() {
        return PickupPoint;
    }

    public void setPickupPoint(String PickupPoint) {
        this.PickupPoint = PickupPoint;
    }

    public int getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(int CarNumber) {
        this.CarNumber = CarNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public Boolean getTwoWay() {
        return twoWay;
    }

    public void setTwoWay(Boolean twoWay) {
        this.twoWay = twoWay;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return PickupPoint;
    }
}
