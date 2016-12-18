/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.employee.EmployeeDirectory;
import business.userAccount.UserAccountDirectory;
import business.workqueue.WorkQueue;
import java.util.ArrayList;
import business.Role.Role;
import business.organization.Customer.CustomerDirectory;

/**
 *
 * @author ayush
 */
public abstract class Organization {
    
    public abstract ArrayList<Role> getSupportedRole();
    
    private int organizationId;
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private static int counter=1;
    private OrganizationType organizationType;
    
    
    public enum OrganizationType
    {
        Residential("Residential"),
        Commercial("Commercial");
        
          private String value;
        
        private OrganizationType(String value){
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
    
    
    
     public enum CommercialType
    {
        CommercialRainWaterHarvwestingUnit("CommercialRainWaterHarvwestingUnit"),
        CommercialMaintainenceUnit("CommercialMaintainenceUnit"),
        CommercialEnergyOptimizationUnit("CommercialEnergyOptimizationUnit");
        
        
          private String value;
        
        private CommercialType(String value){
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
     
     public enum ResidentialType
    {
        ResidentialRainWaterHarvestingUnit("ResidentialRainWaterHarvestingUnit"),
        ResidentialMaintainenceUnit("ResidentialMaintainenceUnit");
        
          private String value;
        
        private ResidentialType(String value){
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

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

  
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Organization.counter = counter;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }
    
    public Organization(String name)
    {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationId = counter;
        ++counter;
    }
    @Override
    public String toString(){
        return name;
    }
    
}
