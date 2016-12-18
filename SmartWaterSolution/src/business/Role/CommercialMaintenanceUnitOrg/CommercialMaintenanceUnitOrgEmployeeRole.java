/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role.CommercialMaintenanceUnitOrg;

import business.EcoSystems;
import business.Role.Role;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import userInterface.MaintainanceRole.MaintainanceRoleWorkAreaJPanel;

/**
 *
 * @author vinay
 */
public class CommercialMaintenanceUnitOrgEmployeeRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystems business) {
       return new MaintainanceRoleWorkAreaJPanel(userProcessContainer, account, organization, business);
    }

    
}
