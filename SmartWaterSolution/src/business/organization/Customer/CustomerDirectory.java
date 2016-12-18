/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.Customer;


import java.util.ArrayList;

/**
 *
 * @author vinay
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;
    
   public CustomerDirectory(){
       customerList = new ArrayList<Customer>();
   }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
   
    public Customer createCustomer(Customer customer) {
        
        customerList.add(customer);
        return customer;
    }
}
