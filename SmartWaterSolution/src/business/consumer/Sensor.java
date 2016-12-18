/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.consumer;

/**
 *
 * @author vinay
 */
public class Sensor {
           
    private double flowRateSample[]= new double[12];
    private double pressureRateSample[]= new double[12];
    
    private double lowFlowRate;
    private double templowFlowRate; 
    private double upperFlowRate ;

    private double lowPressureRate;
    private double templowPressureRate; 
    private double upperPressureRate;

    public double[] getPressureRateSample() {
        return pressureRateSample;
    }

    public void setPressureRateSample(double[] pressureRateSample) {
        this.pressureRateSample = pressureRateSample;
    }
    
    

    public double[] getFlowRateSample() {
        return flowRateSample;
    }

    public void setFlowRateSample(double[] flowRateSample) {
        this.flowRateSample = flowRateSample;
    }
  

    public double getLowFlowRate() {
        return lowFlowRate;
    }

    public void setLowFlowRate(double lowFlowRate) {
        this.lowFlowRate = lowFlowRate;
    }

    public double getTemplowFlowRate() {
        return templowFlowRate;
    }

    public void setTemplowFlowRate(double templowFlowRate) {
        this.templowFlowRate = templowFlowRate;
    }

    public double getUpperFlowRate() {
        return upperFlowRate;
    }

    public void setUpperFlowRate(double upperFlowRate) {
        this.upperFlowRate = upperFlowRate;
    }

    public double getLowPressureRate() {
        return lowPressureRate;
    }

    public void setLowPressureRate(double lowPressureRate) {
        this.lowPressureRate = lowPressureRate;
    }

    public double getTemplowPressureRate() {
        return templowPressureRate;
    }

    public void setTemplowPressureRate(double templowPressureRate) {
        this.templowPressureRate = templowPressureRate;
    }

    public double getUpperPressureRate() {
        return upperPressureRate;
    }

    public void setUpperPressureRate(double upperPressureRate) {
        this.upperPressureRate = upperPressureRate;
    }
    
    public void setUpLimitsForSensors(double flowRate,double pressureRate){
        
         lowFlowRate = flowRate-0.5;
         templowFlowRate = lowFlowRate; 
         upperFlowRate = flowRate+0.5;

         lowPressureRate = pressureRate-0.05;
         templowPressureRate = lowPressureRate; 
         upperPressureRate = pressureRate+0.05;
    }
    
    public void setUpSamplesForSensor(){
        
          for(int i=0;i<flowRateSample.length;i++)
       {
           templowFlowRate=lowFlowRate +(i*0.1);
           flowRateSample[i] = templowFlowRate; 
           
        }
          for(int i=0;i<pressureRateSample.length;i++){
              templowPressureRate=lowPressureRate +(i*0.01);
           pressureRateSample[i] = templowPressureRate; 
          }
    }
    
    public double getFlowRateSample(int rnd){
        
        return flowRateSample[rnd];
    }
    
    public double getPressureRateSample(int rnd){
        
        return pressureRateSample[rnd];
    }
}
