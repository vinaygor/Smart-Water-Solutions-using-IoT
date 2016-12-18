/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Customer.Residential;

import business.enterprise.Enterprise;
import business.userAccount.UserAccount;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import javax.swing.JPanel;
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayush
 */
public class ResidentialCustomerBillingDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResidentialCustomerBillingDetailsJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount account;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss");
    public final String RESULT
        = sdf.format(new Date())+"_My_Billing_Statement_Brief.pdf";
    
    public final String DETAILED_RESULT
        = sdf.format(new Date())+"_My_Billing_Statement_Detailed.pdf";
    private String[][] waterOutletDetails;
    private String[][] totalWaterUsage;
    private int size;

    public ResidentialCustomerBillingDetailsJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        size=account.getCustomer().getConsumer().getWaterOutlets().getWaterOutlets().size();
        int mapSize=account.getCustomer().getConsumer().getTrackWaterUsageMap().size();
        
        waterOutletDetails = new String[mapSize][3];
        int number=0;
        for(Entry<Date, String> entry : account.getCustomer().getConsumer().getTrackWaterUsageMap().entrySet())  
        {
          Date key = entry.getKey();
          String value = entry.getValue();
          String[] waterOulet =value.split(",");
          String waterOutletName = waterOulet[0];
          String waterOutletUsage = waterOulet[1];
        
          waterOutletDetails[number][0]=key.toString();
          waterOutletDetails[number][1]=waterOutletName;
          waterOutletDetails[number][2]=waterOutletUsage;
          number++;
          //System.out.println(key + " " + value);
        }
        calculateOverallUsage();
        populateTable();
    }
    
    public void populateTable(){
        
        DefaultTableModel usageTable = (DefaultTableModel)waterUsageTable.getModel();
        
        for(int i=0;i<totalWaterUsage.length;i++){
            Object[] row=new Object[2];
            row[0]=totalWaterUsage[i][0];
            row[1]=totalWaterUsage[i][1];
            usageTable.addRow(row);
        }
    }
    public void calculateOverallUsage(){
        totalWaterUsage= new String[size][2];
        for(int i=0;i<size;i++){
            totalWaterUsage[i][0]=account.getCustomer().getConsumer().getWaterOutlets().getWaterOutlets().get(i).toString();
            totalWaterUsage[i][1]=Double.toString(0);
        }
        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<waterOutletDetails.length;j++)
            {
                if(totalWaterUsage[i][0].equals(waterOutletDetails[j][1]))
                {
//                    if(totalWaterUsage[i][1]==null)
//                    totalWaterUsage[i][1]=Double.toString(0+Double.parseDouble(waterOutletDetails[j][2]));
//                    else
                    totalWaterUsage[i][1]=Double.toString(Double.parseDouble(totalWaterUsage[i][1])+Double.parseDouble(waterOutletDetails[j][2]));    
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        summaryBillBtn = new javax.swing.JButton();
        detailBillBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        waterUsageTable = new javax.swing.JTable();
        backBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        summaryBillBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        summaryBillBtn.setText("Generate Summary Bill");
        summaryBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryBillBtnActionPerformed(evt);
            }
        });

        detailBillBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        detailBillBtn.setText("Generate Detailed Bill");
        detailBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBillBtnActionPerformed(evt);
            }
        });

        waterUsageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Water Outlet Name", "Usage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(waterUsageTable);
        if (waterUsageTable.getColumnModel().getColumnCount() > 0) {
            waterUsageTable.getColumnModel().getColumn(0).setResizable(false);
            waterUsageTable.getColumnModel().getColumn(1).setResizable(false);
        }

        backBtn1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        backBtn1.setText("<< BACK");
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel1.setText("         Usage Summary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(summaryBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(detailBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detailBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(summaryBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void summaryBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryBillBtnActionPerformed
        try {
            // TODO add your handling code here:
            createPdf(RESULT);
        } catch (IOException ex) {
            Logger.getLogger(ResidentialCustomerBillingDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ResidentialCustomerBillingDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Your Statement has been generated Successfully","Success", 1);
    }//GEN-LAST:event_summaryBillBtnActionPerformed

    private void detailBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBillBtnActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            createDetailedPdf(DETAILED_RESULT);
        } catch (IOException ex) {
            Logger.getLogger(ResidentialCustomerBillingDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ResidentialCustomerBillingDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Your Statement has been generated Successfully","Success", 1);
    }//GEN-LAST:event_detailBillBtnActionPerformed

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtn1ActionPerformed

    
    public void createDetailedPdf(String filename)
        throws IOException, DocumentException {
    
            Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
       // PdfPTable table = new PdfPTable(1);
         Paragraph right = new Paragraph("Water Usage Summary - Detailed",FontFactory.getFont(FontFactory.TIMES_BOLD, 18,Font.UNDERLINE));
        right.setIndentationLeft(CENTER_ALIGNMENT);
       // PdfPCell rightCell = new PdfPCell();
       // rightCell.addElement(right);
        //table.addCell(rightCell);
        document.add(right);
        
                
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(Chunk.NEWLINE);
        Paragraph date = new Paragraph("Date :"+new Date(),FontFactory.getFont(FontFactory.TIMES, 10,Font.UNDERLINE));
        date.setIndentationLeft(RIGHT_ALIGNMENT);
        document.add(date);
        
         document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(createFirstTableDetailed());
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(createSecondTable());
        
       document.add(Chunk.NEWLINE);
       document.add(Chunk.NEWLINE);
       
       document.add(Chunk.NEWLINE);
        Paragraph footer = new Paragraph("Smart Water Solution",FontFactory.getFont(FontFactory.TIMES_BOLD, 12,Font.UNDERLINE));
        footer.setIndentationLeft(RIGHT_ALIGNMENT);
       // PdfPCell rightCell = new PdfPCell();
       // rightCell.addElement(right);
        //table.addCell(rightCell);
        document.add(footer);
        
        // step 5
        document.close();
    
    }
    
     public PdfPTable createFirstTableDetailed() throws DocumentException {
        
         PdfPTable table = new PdfPTable(3);
        
        table.setTotalWidth(500);
        table.setLockedWidth(true);
        table.setWidths(new float[]{1, 1, 1});
        PdfPCell cell;
       
        table.addCell(new Paragraph("Date/Time",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        table.addCell(new Paragraph("Water Outlet Name",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        table.addCell(new Paragraph("Usage ",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        

        for(int i=0;i<waterOutletDetails.length;i++){
            table.addCell(new Paragraph(waterOutletDetails[i][0],FontFactory.getFont(FontFactory.TIMES, 11,Font.BOLD)));
            table.addCell(waterOutletDetails[i][1]);
            table.addCell(waterOutletDetails[i][2]);
        }
     
        return table;
     }
    
    
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
       // PdfPTable table = new PdfPTable(1);
         Paragraph right = new Paragraph("Water Usage Summary - Brief",FontFactory.getFont(FontFactory.TIMES_BOLD, 18,Font.UNDERLINE));
        right.setIndentationLeft(CENTER_ALIGNMENT);
       // PdfPCell rightCell = new PdfPCell();
       // rightCell.addElement(right);
        //table.addCell(rightCell);
        document.add(right);
        
                
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(Chunk.NEWLINE);
        Paragraph date = new Paragraph("Date :"+new Date(),FontFactory.getFont(FontFactory.TIMES, 10,Font.UNDERLINE));
        date.setIndentationLeft(RIGHT_ALIGNMENT);
        document.add(date);
        
         document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(createFirstTable());
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(createSecondTable());
        
       document.add(Chunk.NEWLINE);
       document.add(Chunk.NEWLINE);
       
       document.add(Chunk.NEWLINE);
        Paragraph footer = new Paragraph("Smart Water Solution",FontFactory.getFont(FontFactory.TIMES_BOLD, 12,Font.UNDERLINE));
        footer.setIndentationLeft(RIGHT_ALIGNMENT);
       // PdfPCell rightCell = new PdfPCell();
       // rightCell.addElement(right);
        //table.addCell(rightCell);
        document.add(footer);
        
        // step 5
        document.close();
    }
 
    /**
     * Creates our first table
     * @return our first table
     */
    public PdfPTable createFirstTable() throws DocumentException {
    	// a table with three columns
        PdfPTable table = new PdfPTable(2);
        
        table.setTotalWidth(400);
        table.setLockedWidth(true);
        table.setWidths(new float[]{1, 1});
        PdfPCell cell;
       
        table.addCell(new Paragraph("Water Outlet Name",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        table.addCell(new Paragraph("Usage ",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        

        for(int i=0;i<totalWaterUsage.length;i++){
            table.addCell(totalWaterUsage[i][0]);
            table.addCell(totalWaterUsage[i][1]);
        }
     
        return table;
    }
    
       public PdfPTable createSecondTable() throws DocumentException {
    	// a table with three columns
        PdfPTable table = new PdfPTable(3);
        // the cell object
         table.setTotalWidth(500);
        table.setLockedWidth(true);
        table.setWidths(new float[]{1, 1, 1});
        PdfPCell cell;
        table.addCell(new Paragraph("Supply Source",FontFactory.getFont(FontFactory.TIMES, 14,Font.BOLD)));
        table.addCell(new Paragraph("Total Utilization",FontFactory.getFont(FontFactory.TIMES, 14,Font.BOLD)));
        table.addCell(new Paragraph("Total Amount",FontFactory.getFont(FontFactory.TIMES, 14,Font.BOLD)));
        //table.addCell("row 2; cell 2");
        
        table.addCell(new Paragraph("Storage Tank",FontFactory.getFont(FontFactory.TIMES, 14,Font.BOLD)));
        double usageStorageTank=Math.round(account.getCustomer().getStorageTankUtilization()*100)/100;
        
        table.addCell(Double.toString(usageStorageTank));
        //Multiplying by $0.5 as the standard rate per gallon of water consumed
        table.addCell("$"+Double.toString(usageStorageTank*0.5));
        
        
        table.addCell(new Paragraph("Rain Water Tank",FontFactory.getFont(FontFactory.TIMES, 14,Font.BOLD)));
        double usageRainStorageTank=Math.round(account.getCustomer().getRainWaterTankUtilization()*100)/100;
        
        table.addCell(Double.toString(usageRainStorageTank));
        //Multiplying by $0.5 as the standard rate per gallon of water consumed
        table.addCell(new Paragraph("Saved : $"+Double.toString(usageRainStorageTank*0.5),FontFactory.getFont(FontFactory.TIMES_ITALIC, 12,Font.BOLD,BaseColor.GREEN)));
       
        
       table.addCell(new Paragraph("Total Consumption ",FontFactory.getFont(FontFactory.TIMES, 14,Font.BOLD)));
        table.addCell(Double.toString(account.getCustomer().getRainWaterTankUtilization()+account.getCustomer().getRainWaterTankUtilization()));
        //Multiplying by $0.5 as the standard rate per gallon of water consumed
        table.addCell(new Paragraph("Amount Due : $"+Double.toString(usageStorageTank*0.5),FontFactory.getFont(FontFactory.TIMES_ITALIC, 12,Font.BOLD,BaseColor.BLACK)));
        
        
         
       return table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton detailBillBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton summaryBillBtn;
    private javax.swing.JTable waterUsageTable;
    // End of variables declaration//GEN-END:variables
}
