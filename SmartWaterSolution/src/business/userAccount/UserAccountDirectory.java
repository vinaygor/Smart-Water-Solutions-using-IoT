/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.userAccount;

import business.Role.Role;
import business.employee.Employee;
import business.organization.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
     public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUserName().equals(username) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount createCustomerUserAccount(String username, String password, Customer customer, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setCustomer(customer);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }

    public boolean updateUserAccount(UserAccount c) {
        if (userAccountList.contains(c)) {
            int elementIndex = userAccountList.indexOf(c);
            userAccountList.set(elementIndex, c);
            return true;
        } else {
            return false;
        }
    }

    

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUserName().equals(username)) {
                System.out.println(ua.getUserName());
                return false;
            }
            System.out.println(ua.getUserName());
        }
        return true;
    }
    
}
