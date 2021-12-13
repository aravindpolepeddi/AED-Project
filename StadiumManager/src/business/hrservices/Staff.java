/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.hrservices;

import business.Person;

/**
 *
 * @author deepv
 */
public class Staff extends Person {

    private String staffType;
    private String manager;
    private String profileImagePath;
    private String staffSubType;
    private String status;
    private String hiredBy;
    private String trainingStatus;
    private String instructions;

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getStaffSubType() {
        return staffSubType;
    }

    public void setStaffSubType(String staffSubType) {
        this.staffSubType = staffSubType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHiredBy() {
        return hiredBy;
    }

    public void setHiredBy(String hiredBy) {
        this.hiredBy = hiredBy;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }

}
