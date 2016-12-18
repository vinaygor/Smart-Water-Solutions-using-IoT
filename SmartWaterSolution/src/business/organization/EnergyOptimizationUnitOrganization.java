/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.Role.CommercialEnergyOptimizationUnitOrg.CommercialEnergyOptimizationUnitOrgEmployeeRole;
import business.Role.Role;

import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class EnergyOptimizationUnitOrganization extends Organization {
    
     public EnergyOptimizationUnitOrganization(String name) {
        super(Organization.CommercialType.CommercialEnergyOptimizationUnit.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roleList = new ArrayList();
        roleList.add(new CommercialEnergyOptimizationUnitOrgEmployeeRole());
        return roleList;
    }
    
    
}
