/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue.Maintainence;

import business.consumer.WaterOutlets;
import business.organization.Customer.Customer;
import business.userAccount.UserAccount;
import business.workqueue.WorkRequest;

/**
 *
 * @author ayush
 */
public class MaintainenceRequest extends WorkRequest {
    
    private Customer customer;
    private String customerRequest;
    private UserAccount account;
    private String password;
    private String capacity;
    private WaterOutlets tempWaterOutlet;
    private int totalStorageTanks;
    private String dimensions;

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    

    public int getTotalStorageTanks() {
        return totalStorageTanks;
    }

    public void setTotalStorageTanks(int totalStorageTanks) {
        this.totalStorageTanks = totalStorageTanks;
    }
    

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public WaterOutlets getTempWaterOutlet() {
        return tempWaterOutlet;
    }

    public void setTempWaterOutlet(WaterOutlets tempWaterOutlet) {
        this.tempWaterOutlet = tempWaterOutlet;
    }
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerRequest() {
        return customerRequest;
    }

    public void setCustomerRequest(String customerRequest) {
        this.customerRequest = customerRequest;
    }
    
    
    
}
