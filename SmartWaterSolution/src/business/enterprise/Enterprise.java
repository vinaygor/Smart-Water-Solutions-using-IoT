/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Customer.CustomerDirectory;
import business.organization.Organization;
import business.organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public abstract class Enterprise extends Organization{
    
    private OrganizationDirectory organizationsList;
    private EnterpriseType enterpriseType;
    private CustomerDirectory customerDirectory;
    
    
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationsList = new OrganizationDirectory();
            customerDirectory = new CustomerDirectory();
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }
    
    public enum EnterpriseType {

        Residential("Residential"), Commercial("Commercial");

        private String value;

        private EnterpriseType(String value) {
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

    public OrganizationDirectory getOrganizationsList() {
        return organizationsList;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    
    @Override
    public String toString() {
        return getName();
    }
    
}
