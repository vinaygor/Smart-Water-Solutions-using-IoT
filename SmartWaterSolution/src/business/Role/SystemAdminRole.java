/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import UserInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import business.EcoSystems;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author vinay
 */
public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystems system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
