/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.consumer;

/**
 *
 * @author ayush
 */
public class PumpConfiguration {
    
    private double pumpEfficiency;
    private String oldPumpConfigurationAddress;
    private String newPumpConfigurationAddress;
    private double oldEnergy;
    private double optimizedEnergy;
    private boolean isOptimized =false;
    
    private String[][] pumpConfigurationDetails = new String[12][12];
    private String[][] pumpEfficiencyDetails = new String[3][3];
    
    public PumpConfiguration()
    {
        initializePumpConfigurationDetails();
        initializePumpEfficiencyDetails();
    }

    public boolean isIsOptimized() {
        return isOptimized;
    }

    public void setIsOptimized(boolean isOptimized) {
        this.isOptimized = isOptimized;
    }
    
    
    public double getOldEnergy() {
        return oldEnergy;
    }

    public void setOldEnergy(double oldEnergy) {
        this.oldEnergy = oldEnergy;
    }

    public double getOptimizedEnergy() {
        return optimizedEnergy;
    }

    public void setOptimizedEnergy(double optimizedEnergy) {
        this.optimizedEnergy = optimizedEnergy;
    }

    
    public double getPumpEfficiency() {
        return pumpEfficiency;
    }

    public void setPumpEfficiency(String pumpConfigurationAddress) {
        if(pumpConfigurationAddress.equals("Fenway"))
            this.pumpEfficiency = 85.0;
        else if(pumpConfigurationAddress.equals("Longwood"))
            this.pumpEfficiency = 95.0;
        else
            this.pumpEfficiency = 75.0;
    }

    public String getNewPumpConfigurationAddress() {
        return newPumpConfigurationAddress;
    }

    public void setNewPumpConfigurationAddress(String newPumpConfigurationAddress) {
        this.newPumpConfigurationAddress = newPumpConfigurationAddress;
    }

    
    public String getOldPumpConfigurationAddress() {
        return oldPumpConfigurationAddress;
    }

    public void setOldPumpConfigurationAddress(String oldPumpConfigurationAddress) {
        this.oldPumpConfigurationAddress = oldPumpConfigurationAddress;
    }
      
    public void initializePumpEfficiencyDetails()
    {
        pumpEfficiencyDetails[0][0] ="Fenway";
        pumpEfficiencyDetails[0][1] ="85.0";
        
        pumpEfficiencyDetails[1][0] ="Longwood";
        pumpEfficiencyDetails[1][1] ="95.0";
        
        pumpEfficiencyDetails[2][0] ="Roxbury";
        pumpEfficiencyDetails[2][1] ="75.0";
        
    }
    
    public void initializePumpConfigurationDetails()
    {
        pumpConfigurationDetails[0][0]="Prudential";
        pumpConfigurationDetails[0][1]="Fenway";
        pumpConfigurationDetails[0][2]="0.5";
        
        pumpConfigurationDetails[1][0]="Prudential";
        pumpConfigurationDetails[1][1]="Longwood";
        pumpConfigurationDetails[1][2]="1.5";
        
        pumpConfigurationDetails[2][0]="Prudential";
        pumpConfigurationDetails[2][1]="Roxbury";
        pumpConfigurationDetails[2][2]="1.0";
        
        pumpConfigurationDetails[3][0]="DownTown";
        pumpConfigurationDetails[3][1]="Fenway";
        pumpConfigurationDetails[3][2]="2.0";
        
        pumpConfigurationDetails[4][0]="DownTown";
        pumpConfigurationDetails[4][1]="Longwood";
        pumpConfigurationDetails[4][2]="1.5";
        
        pumpConfigurationDetails[5][0]="DownTown";
        pumpConfigurationDetails[5][1]="Roxbury";
        pumpConfigurationDetails[5][2]="2.0";
        
        pumpConfigurationDetails[6][0]="Boylston";
        pumpConfigurationDetails[6][1]="Fenway";
        pumpConfigurationDetails[6][2]="1.0";
        
        pumpConfigurationDetails[7][0]="Boylston";
        pumpConfigurationDetails[7][1]="Longwood";
        pumpConfigurationDetails[7][2]="2.0";
        
        pumpConfigurationDetails[8][0]="Boylston";
        pumpConfigurationDetails[8][1]="Roxbury";
        pumpConfigurationDetails[8][2]="2.5";
        
        pumpConfigurationDetails[9][0]="Tremont";
        pumpConfigurationDetails[9][1]="Fenway";
        pumpConfigurationDetails[9][2]="2.0";
        
        pumpConfigurationDetails[10][0]="Tremont";
        pumpConfigurationDetails[10][1]="Longwood";
        pumpConfigurationDetails[10][2]="1.5";
        
        pumpConfigurationDetails[11][0]="Tremont";
        pumpConfigurationDetails[11][1]="Roxbury";
        pumpConfigurationDetails[11][2]="2.0";
              
    }
    
    public String energyOptimizedPumpConfiguration(String customerAddress)
    {
        int index=0;
        String energyIntensity[][] = new String[3][3];
       
        //retrieving the customer address location from 2D Array
        for(int i=0;i<12;i++)
        {
            if(pumpConfigurationDetails[i][0].equals(customerAddress))
            {
                index =i;
                break;
            }
        }
        
        //Storing the energy intensity with customer address, pumping address and corresponding energy intensity values 
        for(int j=0;j<3;j++)
        {
            energyIntensity[j][0] = pumpConfigurationDetails[index][0];
            energyIntensity[j][1] = pumpConfigurationDetails[index][1];
            energyIntensity[j][2] = String.valueOf((Double.parseDouble(pumpEfficiencyDetails[j][1]))/(Double.parseDouble(pumpConfigurationDetails[index][2])));            
            index++;
        }
        
        //getting the oldenergy consumption  
        for(int m= 0;m<3;m++)
        {
            if(energyIntensity[m][1].equalsIgnoreCase(oldPumpConfigurationAddress))               
            {
                oldEnergy = Double.parseDouble(energyIntensity[m][2]);
                break;
            }
        }
        
        //getting the most efficient and optimized energy resource from energy intensity 2D Array
        optimizedEnergy = Double.parseDouble(energyIntensity[0][2]);
        for(int k=0;k<3;k++)
        {
            if(optimizedEnergy < Double.parseDouble(energyIntensity[k][2]))
                optimizedEnergy = Double.parseDouble(energyIntensity[k][2]);            
        }
        
        String energyOptimized =String.valueOf(optimizedEnergy);
        int key=0;
        
        //Retrieving the pumping detail of the optimized energy source
        for(int l=0;l<3;l++)
        {
            if(energyOptimized.equals(energyIntensity[l][2]))
            {
                key = l;
                break;
            }
        }
       return energyIntensity[key][1]; 
    }
    
}
