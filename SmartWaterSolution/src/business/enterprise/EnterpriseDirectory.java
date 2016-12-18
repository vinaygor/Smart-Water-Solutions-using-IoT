/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.enterprise.commercialenterprise.CommercialEnterprise;
import business.enterprise.residentialenterprise.ResidentialEnterprise;
import java.util.ArrayList;

/**
 *
 * @author vinay
 */
public class EnterpriseDirectory {
 private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Residential) {
            enterprise = new ResidentialEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Commercial) {
            enterprise = new CommercialEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }

    public void DeleteEnterprise(Enterprise enterprise) {
       
        enterpriseList.remove(enterprise);
       
}
}