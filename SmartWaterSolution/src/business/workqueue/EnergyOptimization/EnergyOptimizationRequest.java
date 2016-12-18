/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue.EnergyOptimization;

import business.organization.Customer.Customer;
import business.workqueue.WorkRequest;

/**
 *
 * @author ayush
 */
public class EnergyOptimizationRequest extends WorkRequest {
    
    private Customer customer;
    private String customerRequest;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
