/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprises;

import business.Customer.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deepv
 */
public class EnterpriseDirectory {

    private List<EnterpriseUser> enterpriseDirectory;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }

    public List<EnterpriseUser> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(List<EnterpriseUser> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public EnterpriseUser addEnterprise() {
        EnterpriseUser enterprise = new EnterpriseUser();
        enterpriseDirectory.add(enterprise);
        return enterprise;
    }

}
