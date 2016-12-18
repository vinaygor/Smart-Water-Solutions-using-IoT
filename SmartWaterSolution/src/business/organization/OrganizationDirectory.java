/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;


import java.util.ArrayList;
import business.organization.Organization.ResidentialType;
import business.organization.Organization.CommercialType;
/**
 *
 * @author ayush
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory(){
        organizationList = new ArrayList<Organization>();
    }
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createResidentialOrganization(ResidentialType type){
        Organization organization = null;
        if (type.getValue().equals(ResidentialType.ResidentialMaintainenceUnit.getValue())) {
            organization = new ResidentialMaintainenceUnitOrganization(ResidentialType.ResidentialMaintainenceUnit.getValue());
            organizationList.add(organization);
        }else
        {
            organization = new ResidentialRainWaterHarvestingUnitOrganization(ResidentialType.ResidentialRainWaterHarvestingUnit.getValue());
            organizationList.add(organization);
        }

        return organization;
    }
    
        public Organization createCommercialOrganization(CommercialType type){
        Organization organization = null;
        if (type.getValue().equals(CommercialType.CommercialMaintainenceUnit.getValue())) {
            organization = new CommercialMaintainenceUnitOrganization(CommercialType.CommercialMaintainenceUnit.getValue());
            organizationList.add(organization);
        }else if (type.getValue().equals(CommercialType.CommercialRainWaterHarvwestingUnit.getValue())) 
        {
            organization = new CommercialRainWaterHarvestingUnitOrganization(CommercialType.CommercialRainWaterHarvwestingUnit.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(CommercialType.CommercialEnergyOptimizationUnit.getValue())) 
        {
            organization = new EnergyOptimizationUnitOrganization(CommercialType.CommercialEnergyOptimizationUnit.getValue());
            organizationList.add(organization);
        }

        return organization;
    }
    
}
