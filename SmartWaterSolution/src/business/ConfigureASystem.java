/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Role.SystemAdminRole;
import business.employee.Employee;
import business.userAccount.UserAccount;

/**
 *
 * @author vinay
 */
public class ConfigureASystem {
    
    public static EcoSystems configure(){
        
        EcoSystems system = EcoSystems.getInstance();
  
         
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("a", "a", employee, new SystemAdminRole());
        
        return system;
}
}
