/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role.ResidentialEnterprise;

import business.EcoSystems;
import business.Role.Role;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.AdminRole.ResidentialEnterprise.ResidentialAdminWorkAreaJPanel;
import userInterface.RainWaterHarvesting.RainWaterHarvestingRoleWorkAreaJPanel;

/**
 *
 * @author vinay
 */
public class ResidentialEnterpriseAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystems business) {
        return new ResidentialAdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise);
    }
    
}
