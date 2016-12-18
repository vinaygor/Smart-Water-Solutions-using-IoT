/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.Customer;

import business.consumer.Consumer;
import business.consumer.WaterOutlet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ayush
 */
public class Customer {
    
    private String customerName;
    private int customerId;
    private Consumer consumer;
    private RainWaterTank rainWaterTank;
    private static int counter;
    private String customerType;
    private boolean isRainWaterTankInstalled = false;
    private double storageTankUtilization;
    private double rainWaterTankUtilization;
     
    
    public Customer()
    {
        consumer = new Consumer();
       
     
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }


    public RainWaterTank getRainWaterTank() {
        return rainWaterTank;
    }

    public void setRainWaterTank(RainWaterTank rainWaterTank) {
        this.rainWaterTank = rainWaterTank;
    }
    
    public void initializeRainWaterStorage(){
        
       rainWaterTank = new RainWaterTank();
       isRainWaterTankInstalled = true;
    }

    public boolean isIsRainWaterTankInstalled() {
        return isRainWaterTankInstalled;
    }

    public void setIsRainWaterTankInstalled(boolean isRainWaterTankInstalled) {
        this.isRainWaterTankInstalled = isRainWaterTankInstalled;
    }

    public double getStorageTankUtilization() {
        return storageTankUtilization;
    }

    public void setStorageTankUtilization(double storageTankUtilization) {
        this.storageTankUtilization = storageTankUtilization;
    }

    public double getRainWaterTankUtilization() {
        return rainWaterTankUtilization;
    }

    public void setRainWaterTankUtilization(double rainWaterTankUtilization) {
        this.rainWaterTankUtilization = rainWaterTankUtilization;
    }
    
    
    
@Override
public String toString(){
    return customerName;
}
}
