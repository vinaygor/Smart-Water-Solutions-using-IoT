/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SystemAdminWorkArea;

import UserInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import business.EcoSystems;
import business.Utils.Utils;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Customer.Customer;
import java.awt.CardLayout;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ayush
 */
public class PredictiveAnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PredictiveAnalysisJPanel
     */
     private JPanel userProcessContainer;
     private EcoSystems system;
     private  double commercialStorageTankUsage=0;
     private  double averageCommercialStorageTankUsage=0;
     private   double commercialRainWaterUsage=0;
     private   double averageCommercialRainWaterUsage=0;
     private   double residentialStorageTankUsage=0;
     private   double averageResidentialStorageTankUsage=0;
     private   double residentialRainWaterUsage=0;
     private   double averageResidentialRainWaterUsage=0;
     private double residentialRainWaterGraph,commercialRainWaterGraph,overallRainWaterGraph;
     private double residentialStorageTankGraph,commercialStorageTankGraph,overallStorageTankGraph;
     //private   double averageTotalStorageTankUsage=0;
    // private   double averageTotalRainWaterUsage=0;
     private  int residentialCount=0,commercialCount=0;
     private  double averageResidentialUsage=0,averageResidentialWaterLoss=20,averageCommercialWaterLoss=40.0;
     private  double averageCommercialUsage=0;
     private Calendar calendar,residentialCalendar,commercialCalendar;
     private int month;
    
    public PredictiveAnalysisJPanel(JPanel userProcessContainer, EcoSystems system) throws ParseException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        getUsage();
          calendar = overallDatePicker.getMonthView().getCalendar();
        calendar.setTime(new Date());
        overallDatePicker.getMonthView().setLowerBound(calendar.getTime());
         residentialCalendar = residentialDatePicker.getMonthView().getCalendar();
        residentialCalendar.setTime(new Date());
        residentialDatePicker.getMonthView().setLowerBound(residentialCalendar.getTime());
         commercialCalendar = commercialDatePicker.getMonthView().getCalendar();
        commercialCalendar.setTime(new Date());
        commercialDatePicker.getMonthView().setLowerBound(commercialCalendar.getTime());
        
    }
    
   
    public void getUsage() throws ParseException
    {
        for(Network n:system.getNetworkList())
        for(Enterprise e:n.getEnterpriseList().getEnterpriseList())
        {
            
                for(Customer c:e.getCustomerDirectory().getCustomerList())
                {
                    if(c.getCustomerType().equalsIgnoreCase("Residential"))
                    {
                        residentialStorageTankUsage = residentialStorageTankUsage + c.getStorageTankUtilization();
                        residentialRainWaterUsage = residentialRainWaterUsage + c.getRainWaterTankUtilization();
                        residentialCount++;
                        
                        if(c.getCustomerName().equalsIgnoreCase("rick"))
                        {
                           // System.out.println("Customer Name "+c.getCustomerName());
                            c.getConsumer().setTotalUsagePerDay();
                            c.getConsumer().setAverageUtilization();
                            //System.out.println(c.getConsumer().getAverageUtilization());
                        }
                    }
                    if(c.getCustomerType().equalsIgnoreCase("Commercial"))
                    {
                        commercialStorageTankUsage = commercialStorageTankUsage + c.getStorageTankUtilization();
                        commercialRainWaterUsage = commercialRainWaterUsage + c.getRainWaterTankUtilization();
                        commercialCount++;
                        
                        if(c.getCustomerName().equalsIgnoreCase("kal"))
                        {
                            //System.out.println("Customer Name "+c.getCustomerName());
                            c.getConsumer().setTotalUsagePerDay();
                            c.getConsumer().setAverageUtilization();
                            c.getConsumer().getAverageUtilization();
                            //System.out.println(c.getConsumer().getAverageUtilization());
                        }
                    }
                }
            
            
        }
        averageResidentialStorageTankUsage = residentialStorageTankUsage/residentialCount;
        averageResidentialRainWaterUsage = residentialRainWaterUsage/residentialCount;
        averageCommercialStorageTankUsage = commercialStorageTankUsage/commercialCount;
        averageCommercialRainWaterUsage = commercialRainWaterUsage/commercialCount;
        //averageTotalStorageTankUsage =  averageCommercialStorageTankUsage + averageResidentialStorageTankUsage;
       // averageTotalRainWaterUsage = averageResidentialRainWaterUsage + averageCommercialRainWaterUsage;
        averageResidentialUsage = averageResidentialStorageTankUsage + averageResidentialRainWaterUsage;
        averageCommercialUsage = averageCommercialStorageTankUsage + averageCommercialRainWaterUsage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        overallTabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        residentialCustomersCountTxtField = new javax.swing.JTextField();
        residentialPredictiveBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        residentialTotalRequirementLabel = new javax.swing.JLabel();
        residentialRainWaterContributionLabel = new javax.swing.JLabel();
        residentialStorageContributionLabel = new javax.swing.JLabel();
        residentialGraphBtn = new javax.swing.JButton();
        residentialDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        commercialPredictiveBtn = new javax.swing.JButton();
        commercialCustomerCountTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        commerciallTotalRequirementLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        commercialRainWaterContributionLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        commercialStorageContributionLabel = new javax.swing.JLabel();
        commercialGraphBtn = new javax.swing.JButton();
        commercialDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        overallCommercialCostomerCountTxtField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        overallResidentialCustomersCountTxtField = new javax.swing.JTextField();
        overallPredictiveBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        overalllTotalRequirementLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        overallRainWaterContributionLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        overallStorageContributionLabel = new javax.swing.JLabel();
        overallGraphBtn = new javax.swing.JButton();
        overallDatePicker = new org.jdesktop.swingx.JXDatePicker();
        backJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 20)); // NOI18N
        jLabel1.setText("PREDICTIVE Water Usage Analysis");

        jLabel2.setText("Enter the Number of Residential Potential Customers :");

        residentialPredictiveBtn.setText("Residential Predictive Analysis");
        residentialPredictiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialPredictiveBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Prediction For:");

        jLabel3.setText("Total Requirement");

        jLabel10.setText("Contribution by Rain Water Harvesting Tank");

        jLabel11.setText("Contribution by Storage  Tank");

        residentialTotalRequirementLabel.setText("            ");

        residentialRainWaterContributionLabel.setText("            ");

        residentialStorageContributionLabel.setText("            ");

        residentialGraphBtn.setText("Graph");
        residentialGraphBtn.setEnabled(false);
        residentialGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialGraphBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(residentialPredictiveBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(residentialCustomersCountTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(residentialDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(residentialRainWaterContributionLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(residentialStorageContributionLabel)
                                .addGap(58, 58, 58)
                                .addComponent(residentialGraphBtn))
                            .addComponent(residentialTotalRequirementLabel))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(residentialCustomersCountTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(residentialDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(residentialPredictiveBtn)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(residentialTotalRequirementLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(residentialRainWaterContributionLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(residentialStorageContributionLabel)
                    .addComponent(residentialGraphBtn))
                .addGap(38, 38, 38))
        );

        overallTabPane.addTab("Residential", jPanel1);

        jLabel5.setText("Enter the Number of Commercial Potential Customers :");

        commercialPredictiveBtn.setText("Commercial Predictive Analysis");
        commercialPredictiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commercialPredictiveBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Prediction For:");

        jLabel12.setText("Total Requirement");

        commerciallTotalRequirementLabel.setText("              ");

        jLabel13.setText("Contribution by Rain Water Harvesting Tank");

        commercialRainWaterContributionLabel.setText("             ");

        jLabel14.setText("Contribution by Storage  Tank");

        commercialStorageContributionLabel.setText("            ");

        commercialGraphBtn.setText("Graph");
        commercialGraphBtn.setEnabled(false);
        commercialGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commercialGraphBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commercialCustomerCountTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(commercialDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(commercialPredictiveBtn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commercialRainWaterContributionLabel)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(commercialStorageContributionLabel)
                                .addGap(58, 58, 58)
                                .addComponent(commercialGraphBtn))
                            .addComponent(commerciallTotalRequirementLabel))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(commercialCustomerCountTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commercialDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(commercialPredictiveBtn)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(commerciallTotalRequirementLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(commercialRainWaterContributionLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(commercialStorageContributionLabel)
                    .addComponent(commercialGraphBtn))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        overallTabPane.addTab("Commercial", jPanel2);

        jLabel7.setText("Enter the Number of Commercial Potential Customers :");

        jLabel8.setText("Prediction For:");

        jLabel9.setText("Enter the Number of Residential Potential Customers :");

        overallPredictiveBtn.setText("Overall Predictive Analysis");
        overallPredictiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overallPredictiveBtnActionPerformed(evt);
            }
        });

        jLabel15.setText("Total Requirement");

        overalllTotalRequirementLabel.setText("            ");

        jLabel16.setText("Contribution by Rain Water Harvesting Tank");

        overallRainWaterContributionLabel.setText("            ");

        jLabel17.setText("Contribution by Storage  Tank");

        overallStorageContributionLabel.setText("            ");

        overallGraphBtn.setText("Graph");
        overallGraphBtn.setEnabled(false);
        overallGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overallGraphBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(overallCommercialCostomerCountTxtField)
                            .addComponent(overallResidentialCustomersCountTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(overallDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(overallPredictiveBtn)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(overallStorageContributionLabel)
                                .addGap(58, 58, 58)
                                .addComponent(overallGraphBtn))
                            .addComponent(overallRainWaterContributionLabel)
                            .addComponent(overalllTotalRequirementLabel))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(overallResidentialCustomersCountTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overallDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(overallCommercialCostomerCountTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(overallPredictiveBtn)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(overalllTotalRequirementLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(overallRainWaterContributionLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(overallStorageContributionLabel)
                    .addComponent(overallGraphBtn))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        overallTabPane.addTab("Overall", jPanel3);

        backJButton.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(overallTabPane))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backJButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(overallTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public double  getRainFallParameter(int month)
    {
        double rainFallParameter=0;
        if(month>0&&month<=4)
            rainFallParameter = 25;
        else if(month>4&&month<=8)
            rainFallParameter = 50;
        else
            rainFallParameter =100;
            
        return rainFallParameter;
    }
    private void residentialPredictiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialPredictiveBtnActionPerformed
        // TODO add your handling code here:
       try{
        if(residentialCustomersCountTxtField.getText().equals("")||residentialDatePicker.getDate().equals(""))
            JOptionPane.showMessageDialog(null, "Entries cannot be null for Prediction", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
        residentialCalendar.setTime(residentialDatePicker.getDate());
        month = residentialCalendar.get(Calendar.MONTH);
        double rainFallParameter = getRainFallParameter(month);
        int customerCount = Integer.parseInt(residentialCustomersCountTxtField.getText());
        double totalRequirement = averageResidentialUsage*customerCount +averageResidentialWaterLoss*customerCount;
        residentialTotalRequirementLabel.setText(Double.toString(Utils.roundDouble(totalRequirement)));
        double rainWaterContribution = averageResidentialRainWaterUsage*customerCount +rainFallParameter;
        residentialRainWaterContributionLabel.setText(Double.toString(Utils.roundDouble(rainWaterContribution)));
        residentialStorageContributionLabel.setText(Double.toString(Utils.roundDouble(totalRequirement-rainWaterContribution)));
        residentialRainWaterGraph = rainWaterContribution;
        residentialStorageTankGraph = totalRequirement - rainWaterContribution;
         residentialGraphBtn.setEnabled(true);
        }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Please enter a date for Prediction", "Information", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_residentialPredictiveBtnActionPerformed

    private void commercialPredictiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commercialPredictiveBtnActionPerformed
        // TODO add your handling code here:
         try{
        if(commercialCustomerCountTxtField.getText().equals("")||commercialDatePicker.getDate().equals(""))
            JOptionPane.showMessageDialog(null, "Entries cannot be null for Prediction", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
        commercialCalendar.setTime(commercialDatePicker.getDate());
        month = commercialCalendar.get(Calendar.MONTH);
        double rainFallParameter = getRainFallParameter(month);
        
        int customerCount = Integer.parseInt(commercialCustomerCountTxtField.getText());
        double totalRequirement = averageCommercialUsage*customerCount +averageCommercialWaterLoss*customerCount;
        commerciallTotalRequirementLabel.setText(Double.toString(Utils.roundDouble(totalRequirement)));
        double rainWaterContribution = averageCommercialRainWaterUsage*customerCount +rainFallParameter;
        commercialRainWaterContributionLabel.setText(Double.toString(Utils.roundDouble(rainWaterContribution)));
        commercialStorageContributionLabel.setText(Double.toString(Utils.roundDouble(totalRequirement-rainWaterContribution)));
        commercialRainWaterGraph = rainWaterContribution;
        commercialStorageTankGraph = totalRequirement - rainWaterContribution;
        commercialGraphBtn.setEnabled(true);
         }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Please enter a date for Prediction", "Information", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_commercialPredictiveBtnActionPerformed

    private void overallPredictiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overallPredictiveBtnActionPerformed
        // TODO add your handling code here:
       try{
        if(overallCommercialCostomerCountTxtField.getText().equals("")||
                overallResidentialCustomersCountTxtField.getText().equals("")||overallDatePicker.getDate().equals(""))
            JOptionPane.showMessageDialog(null, "Entries cannot be null for Prediction", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
        calendar.setTime(overallDatePicker.getDate());
        month = calendar.get(Calendar.MONTH);
        double rainFallParameter = getRainFallParameter(month);
        
        int residentialustomerCount = Integer.parseInt(overallResidentialCustomersCountTxtField.getText());
        double totalResidentialRequirement = averageResidentialUsage*residentialustomerCount +averageResidentialWaterLoss*residentialustomerCount;
        
        
        int commercialCustomerCount = Integer.parseInt(overallCommercialCostomerCountTxtField.getText());
        double totalCommercialRequirement = averageCommercialUsage*commercialCustomerCount +averageCommercialWaterLoss*commercialCustomerCount;
        double totalRequirement = totalResidentialRequirement + totalCommercialRequirement;
        overalllTotalRequirementLabel.setText(Double.toString(Utils.roundDouble(totalRequirement)));
        
        double residentialRainWaterContribution = averageResidentialRainWaterUsage*residentialustomerCount +rainFallParameter;
        double commercialRainWaterContribution = averageCommercialRainWaterUsage*commercialCustomerCount +rainFallParameter;
        double totalRainWaterContribution = residentialRainWaterContribution + commercialRainWaterContribution;
        overallRainWaterContributionLabel.setText(Double.toString(Utils.roundDouble(totalRainWaterContribution)));
        overallStorageContributionLabel.setText(Double.toString(Utils.roundDouble(totalRequirement-totalRainWaterContribution)));
        overallRainWaterGraph = totalRainWaterContribution;
        overallStorageTankGraph = totalRequirement - totalRainWaterContribution;
        overallGraphBtn.setEnabled(true);
         }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Please enter a date for Prediction", "Information", JOptionPane.INFORMATION_MESSAGE);
       }
        
    }//GEN-LAST:event_overallPredictiveBtnActionPerformed

    private void residentialGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialGraphBtnActionPerformed
        // TODO add your handling code here:
         DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Storage Tank Utilization "+Utils.roundDouble(residentialStorageTankGraph), Utils.roundDouble(residentialStorageTankGraph));
        dataset.setValue("Rain Water Tank Utilization "+Utils.roundDouble(residentialRainWaterGraph), Utils.roundDouble(residentialRainWaterGraph));
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset);
      
        
        ChartFrame frame = new ChartFrame("Utilization Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(500, 400);
        
    }//GEN-LAST:event_residentialGraphBtnActionPerformed

    private void commercialGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commercialGraphBtnActionPerformed
        // TODO add your handling code here:
         DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Storage Tank Utilization "+Utils.roundDouble(commercialStorageTankGraph), Utils.roundDouble(commercialStorageTankGraph));
        dataset.setValue("Rain Water Tank Utilization "+Utils.roundDouble(commercialRainWaterGraph), Utils.roundDouble(commercialRainWaterGraph));
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset);
      
        
        ChartFrame frame = new ChartFrame("Utilization Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(500, 400);
    }//GEN-LAST:event_commercialGraphBtnActionPerformed

    private void overallGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overallGraphBtnActionPerformed
        // TODO add your handling code here:
         DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Storage Tank Utilization "+Utils.roundDouble(overallStorageTankGraph), Utils.roundDouble(overallStorageTankGraph));
        dataset.setValue("Rain Water Tank Utilization "+Utils.roundDouble(overallRainWaterGraph), Utils.roundDouble(overallRainWaterGraph));
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset);
       
        
        ChartFrame frame = new ChartFrame("Utilization Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(500, 400);
    }//GEN-LAST:event_overallGraphBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField commercialCustomerCountTxtField;
    private org.jdesktop.swingx.JXDatePicker commercialDatePicker;
    private javax.swing.JButton commercialGraphBtn;
    private javax.swing.JButton commercialPredictiveBtn;
    private javax.swing.JLabel commercialRainWaterContributionLabel;
    private javax.swing.JLabel commercialStorageContributionLabel;
    private javax.swing.JLabel commerciallTotalRequirementLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField overallCommercialCostomerCountTxtField;
    private org.jdesktop.swingx.JXDatePicker overallDatePicker;
    private javax.swing.JButton overallGraphBtn;
    private javax.swing.JButton overallPredictiveBtn;
    private javax.swing.JLabel overallRainWaterContributionLabel;
    private javax.swing.JTextField overallResidentialCustomersCountTxtField;
    private javax.swing.JLabel overallStorageContributionLabel;
    private javax.swing.JTabbedPane overallTabPane;
    private javax.swing.JLabel overalllTotalRequirementLabel;
    private javax.swing.JTextField residentialCustomersCountTxtField;
    private org.jdesktop.swingx.JXDatePicker residentialDatePicker;
    private javax.swing.JButton residentialGraphBtn;
    private javax.swing.JButton residentialPredictiveBtn;
    private javax.swing.JLabel residentialRainWaterContributionLabel;
    private javax.swing.JLabel residentialStorageContributionLabel;
    private javax.swing.JLabel residentialTotalRequirementLabel;
    // End of variables declaration//GEN-END:variables
}
