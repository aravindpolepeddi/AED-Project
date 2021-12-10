/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.suites;

import business.premium.Premium;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aravindpolepeddi
 */
public class SuitesDirectory {

    List<Suites> suitesList;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Suites> getSuitesList() {
        return suitesList;
    }

    public SuitesDirectory() {
        suitesList = new ArrayList<>();
    }

    public void setSuitesList(List<Suites> suitesList) {
        this.suitesList = suitesList;
    }

    public Suites addSuites() {
        Suites suite = new Suites();
        suitesList.add(suite);
        return suite;
    }

    /**
     * Return Suites object whose manager name matches the input
     *
     * @param managerNames
     * @return
     */
    public Suites findSuiteByManagerName(String managerNames) {
        Suites suite = suitesList.stream().filter(x -> x.getManagerName().equals(managerNames)).findAny().orElse(null);
        return suite;
    }

    /**
     * Method to remove the object from the directory
     *
     * @param premium
     */
    public void removeSuite(Suites suite) {
        suitesList.remove(suite);
    }

}
