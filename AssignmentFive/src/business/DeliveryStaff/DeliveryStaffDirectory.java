/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.DeliveryStaff;

import java.util.ArrayList;

/**
 *
 * @author deepv
 */
public class DeliveryStaffDirectory {

    private ArrayList<DeliveryStaff> deliveryStaffMembers;

    public DeliveryStaffDirectory() {
        deliveryStaffMembers = new ArrayList<>();
    }

    public ArrayList<DeliveryStaff> getDeliveryStaffMembers() {
        return deliveryStaffMembers;
    }

    public void setDeliveryStaffMembers(ArrayList<DeliveryStaff> deliveryStaffMembers) {
        this.deliveryStaffMembers = deliveryStaffMembers;
    }

    public DeliveryStaff addDeliveryStaff() {
        DeliveryStaff staff = new DeliveryStaff();
        deliveryStaffMembers.add(staff);
        return staff;
    }

    public DeliveryStaff findStaffByUserName(String userName) {
        DeliveryStaff staff = deliveryStaffMembers.stream().filter(x -> x.getUserName().equals(userName)).findAny().orElse(null);
        return staff;
    }

    public void removeRestaurant(DeliveryStaff staff) {
        int index = deliveryStaffMembers.indexOf(staff);
        deliveryStaffMembers.remove(index);
    }
}
