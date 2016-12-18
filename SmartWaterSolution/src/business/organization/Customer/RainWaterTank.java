/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.Customer;

/**
 *
 * @author ayush
 */
public class RainWaterTank {
    
    private String dimensions;
    private double capacity;
    private double levelSensor=50;

    public double getLevelSensor() {
        return levelSensor;
    }

    public void setLevelSensor(int levelSensor) {
        this.levelSensor = levelSensor;
    }
    
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    
    
}
