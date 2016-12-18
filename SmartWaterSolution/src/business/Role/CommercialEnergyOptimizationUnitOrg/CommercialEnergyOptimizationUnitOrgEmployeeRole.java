/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role.CommercialEnergyOptimizationUnitOrg;

import business.EcoSystems;
import business.Role.Role;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.EnergyOptimization.EnergyOptimizationRoleWorkAreaJPanel;

/**
 *
 * @author ayush
 */
public class CommercialEnergyOptimizationUnitOrgEmployeeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystems business) {
       return new EnergyOptimizationRoleWorkAreaJPanel(userProcessContainer, account, organization, business);
    }
    
}