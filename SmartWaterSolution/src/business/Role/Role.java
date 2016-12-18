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

/**
 *
 * @author ayush
 */
public abstract class Role {
    
     public enum RoleType{
        Admin("Admin"),
        ResidentialEnterpriseAdmin("ResidentialEnterpriseAdmin"),
        CommercialEnterpriseAdmin("CommercialEnterpriseAdmin"),
        RainwaterHarvestingUnitOrgAdmin("RainwaterHarvestingUnitOrgAdmin"),
        RainwaterHarvestingUnitOrgEmployee("RainwaterHarvestingUnitOrgEmployee"),
        MaintenanceUnitOrgAdmin("MaintenanceUnitOrgAdmin"),
        MaintenanceUnitOrgEmployee("MaintenanceUnitOrgAdminEmployee"),  
        EnergyOptimizationUnitOrgAdmin("EnergyOptimizationUnitOrgAdmin"),
        EnergyOptimizationUnitOrgEmployee("EnergyOptimizationUnitOrgEmployee"),
        PredictiveAnalysisUnitOrgAdmin("PredictiveAnalysisUnitOrgAdmin"),
        PredictiveAnalysisUnitOrgEmployee("PredictiveAnalysisUnitOrgEmployee"),
        Consumer("Consumer"),
        ResidentialCustomer("ResidentialCustomer"),
        CommercialCustomer("CommericalCustomer");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

 public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystems business);

    @Override
    public String toString() {
        return this.getClass().getTypeName();
    }
   
    
}
