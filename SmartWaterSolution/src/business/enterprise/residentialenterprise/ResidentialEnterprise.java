/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise.residentialenterprise;

import business.Role.ResidentialEnterprise.ResidentialEnterpriseAdminRole;
import business.Role.Role;
import business.enterprise.Enterprise;
import java.util.ArrayList;

/**
 *
 * @author vinay
 */
public class ResidentialEnterprise extends Enterprise{
    
    public ResidentialEnterprise(String name, EnterpriseType type) {
        super(name, type);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ResidentialEnterpriseAdminRole());
        return roles;//To change body of generated methods, choose Tools | Templates.
    }
    
}
