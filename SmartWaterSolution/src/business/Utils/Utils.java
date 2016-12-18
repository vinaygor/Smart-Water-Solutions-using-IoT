/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Utils;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;

/**
 *
 * @author ayush
 */
public final class Utils {
    
    public static double roundDouble(double value)
    {
        value =Math.round(value*1000.0)/1000.0;
        return value;
    }
    
    public static boolean isEmployeeNameUnique(String value,Organization organization){
        
        for(Employee e:organization.getEmployeeDirectory().getEmployeeList()){
            if(e.getName().equalsIgnoreCase(value))
                return false;
        }
        return true;
    }
    
    public static boolean isUserAccountNameUnique(String username,Enterprise enterprise){
        
        for(Organization organization:enterprise.getOrganizationsList().getOrganizationList())
        for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
        {
            if(ua.getUserName().equals(username))
                return false;
        }
        return true;
    }
    
    
}
