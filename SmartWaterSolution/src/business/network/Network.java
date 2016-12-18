/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class Network {
    
    private String name;
    
    private EnterpriseDirectory enterpriseList;
    
    public Network(){
        enterpriseList = new EnterpriseDirectory();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseList() {
        return enterpriseList;
    }
    
    public boolean sameEnterprise(String name) {
        for (Enterprise e : enterpriseList.getEnterpriseList()) {
            if (e.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean sameEnterpriseType(Enterprise.EnterpriseType type) {
        for (Enterprise e : enterpriseList.getEnterpriseList()) {
            if (e.getEnterpriseType().equals(type)) {
                return true;
            }
        }
        return false;
    }
   
    @Override
    public String toString(){
        return name;
    }
          
}
