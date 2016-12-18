/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoSystems;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.Customer.Commercial.CommercialCustomerWorkAreaJPanel;
import userInterface.Customer.Residential.ResidentialCustomerWorkAreaJPanel;

/**
 *
 * @author vinay
 */
public class CustomerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystems business) {
        if(enterprise.getEnterpriseType().toString().equals("Commercial"))
        return new CommercialCustomerWorkAreaJPanel(userProcessContainer,enterprise,organization,account);
        else
        return new ResidentialCustomerWorkAreaJPanel(userProcessContainer, organization,enterprise,account);    
    }
    
}
