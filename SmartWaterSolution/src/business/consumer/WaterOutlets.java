/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.consumer;

import java.util.ArrayList;

/**
 *
 * @author vinay
 */
public class WaterOutlets {
    
    private ArrayList<WaterOutlet> waterOutlets;

    public ArrayList<WaterOutlet> getWaterOutlets() {
        return waterOutlets;
    }

    public WaterOutlets() {
        this.waterOutlets = new ArrayList<WaterOutlet>();
    }
    

    public WaterOutlet add(WaterOutlet waterOutlet) {
       waterOutlets.add(waterOutlet);
       return waterOutlet;
    }

    public void remove(WaterOutlet waterOutlet) {
        waterOutlets.remove(waterOutlet);
        
    }

    
    
    
}
