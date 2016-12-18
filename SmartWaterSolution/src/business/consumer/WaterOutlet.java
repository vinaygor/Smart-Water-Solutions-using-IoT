/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.consumer;

import business.organization.Customer.Customer;

/**
 *
 * @author vinay
 */
public class WaterOutlet {
    
    private String waterOutletName;
    private String waterOutletType;
    private double flowRate;
    private double waterPressure; 
    
    private String[][] waterOutletDetails = new String[6][6];
    
    public WaterOutlet(){
        initializeWaterDetails();
    }



    public String getWaterOutletType() {
        return waterOutletType;
    }

    public void setWaterOutletType(String waterOutletType) {
        this.waterOutletType = waterOutletType;
    }
    
    
    public void initializeWaterDetails(){
        waterOutletDetails[0][0]="Basin Tap";
        waterOutletDetails[0][2]="3.5";
        waterOutletDetails[0][3]="0.2";
        
        waterOutletDetails[1][0]="Shower";
        waterOutletDetails[1][2]="3.0";
        waterOutletDetails[1][3]="0.1";
        
        waterOutletDetails[2][0]="Bath Tap";
        waterOutletDetails[2][2]="4.0";
        waterOutletDetails[2][3]="0.2";
        
        waterOutletDetails[3][0]="Washing Machine";
        waterOutletDetails[3][2]="6.0";
        waterOutletDetails[3][3]="0.2";
        
        waterOutletDetails[4][0]="Flush";
        waterOutletDetails[4][2]="10.0";
        waterOutletDetails[4][3]="0.2";
        
        waterOutletDetails[5][0]="Others";
        waterOutletDetails[5][2]="2.0";
        waterOutletDetails[5][3]="0.2";
    }
    public String getWaterOutletName() {
        return waterOutletName;
    }

    public void setWaterOutletName(String waterOutletName) {
        this.waterOutletName = waterOutletName;
    }

    public double getFlowRate(String tempWaterOutletType) {
        for(int i=0;i<6;i++){
            if(waterOutletDetails[i][0].equalsIgnoreCase(tempWaterOutletType))
            {
                return Double.parseDouble(waterOutletDetails[i][2]);
            }
        }
       return 0;
    }

    
    public double getWaterPressure(String tempWaterOutletType) {
        
           for(int i=0;i<6;i++){
            if(waterOutletDetails[i][0].equalsIgnoreCase(tempWaterOutletType))
            {
                return Double.parseDouble(waterOutletDetails[i][3]);
            }
        }
       return 0;
    }

    
    @Override
        public String toString() {
            return waterOutletName;
        }
    
}
