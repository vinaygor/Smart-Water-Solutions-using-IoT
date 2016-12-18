/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;


import business.Role.Role;
import java.util.ArrayList;
import business.Role.ResidentialMaintenanceUnitOrg.ResidentialMaintenanceUnitOrgEmployeeRole;

/**
 *
 * @author ayush
 */
public class ResidentialMaintainenceUnitOrganization extends Organization{
    
    public ResidentialMaintainenceUnitOrganization(String name) {
        super(Organization.ResidentialType.ResidentialMaintainenceUnit.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList();
        roleList.add(new ResidentialMaintenanceUnitOrgEmployeeRole());
        return roleList;
    }
    
}
