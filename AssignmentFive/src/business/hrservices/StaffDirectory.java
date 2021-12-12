/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.hrservices;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deepv
 */
public class StaffDirectory {

    private List<Staff> staffList;

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public StaffDirectory() {
        staffList = new ArrayList<>();
    }

    public Staff addStaffMembers() {
        Staff staff = new Staff();
        staffList.add(staff);
        return staff;
    }

    /**
     * Return staff whose service matches the input service
     *
     * @param managerNames
     * @return
     */
    public Staff findStaffByServiceType(String serviceType) {
        Staff staff = staffList.stream().filter(x -> x.getStaffType().equals(serviceType)).findAny().orElse(null);
        return staff;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    /**
     * Return staff whose manager matches the input type
     *
     * @param managerNames
     * @return
     */
    public Staff findStaffByManager(String serviceType) {
        Staff staff = staffList.stream().filter(x -> x.getStaffType().equals(serviceType)).findAny().orElse(null);
        return staff;
    }

    /**
     * Return staff whose manager matches the input name
     *
     * @param managerNames
     * @return
     */
    public Staff findStaffByName(String name) {
        Staff staff = staffList.stream().filter(x -> x.getFullName().equals(name)).findAny().orElse(null);
        return staff;
    }

}
