/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.Role.CommercialRainwaterHarvestingUnitOrg.CommercialRainwaterHarvestingUnitOrgEmployeeRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class CommercialRainWaterHarvestingUnitOrganization extends Organization {
    
    public CommercialRainWaterHarvestingUnitOrganization(String name) {
        super(Organization.CommercialType.CommercialRainWaterHarvwestingUnit.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roleList = new ArrayList();
        roleList.add(new CommercialRainwaterHarvestingUnitOrgEmployeeRole());
        return roleList;
    }
    
    
    
}
