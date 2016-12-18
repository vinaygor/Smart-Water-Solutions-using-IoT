/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.Role.ResidentialRainwaterHarvestingUnitOrg.ResidentialRainwaterHarvestingUnitOrgEmployeeRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class ResidentialRainWaterHarvestingUnitOrganization extends Organization {
    
    public ResidentialRainWaterHarvestingUnitOrganization(String name) {
        super(Organization.ResidentialType.ResidentialRainWaterHarvestingUnit.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roleList = new ArrayList();
        roleList.add(new ResidentialRainwaterHarvestingUnitOrgEmployeeRole());
        return roleList;
    }
    
    
    
}
