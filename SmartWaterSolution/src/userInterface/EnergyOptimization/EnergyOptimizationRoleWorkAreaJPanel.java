/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.EnergyOptimization;

import business.EcoSystems;
import business.organization.EnergyOptimizationUnitOrganization;
import business.organization.Organization;
import business.userAccount.UserAccount;
import business.workqueue.EnergyOptimization.EnergyOptimizationRequest;
import business.workqueue.WorkQueue;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayush
 */
public class EnergyOptimizationRoleWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EnergyOptimizationRoleWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private  UserAccount account;
    private Organization organization;
    private EcoSystems business;

    public EnergyOptimizationRoleWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystems business) 
    {
       initComponents();
       this.userProcessContainer=userProcessContainer;
        this.account=account;
        
        this.organization=(EnergyOptimizationUnitOrganization)organization;
           
        this.business=business;
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)employeeRequestTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
        
            {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getCustomer().getCustomerName();
            row[2] = request.getStatus();
            row[3] = request.getPriority();
            
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeRequestTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        processRequest = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        employeeRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Priority"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeeRequestTable);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel2.setText("My Requests");

        processRequest.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        processRequest.setText("Process Request");
        processRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processRequestActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 20)); // NOI18N
        jLabel3.setText("Energy Optimization Work Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(processRequest))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(processRequest)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = employeeRequestTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        
        EnergyOptimizationRequest request = (EnergyOptimizationRequest)employeeRequestTable.getValueAt(selectedRow, 0);
        if(!request.getStatus().equalsIgnoreCase("completed")||!request.getResult().equalsIgnoreCase("Completed")){
        request.setStatus("Processing");
        EnergyOptimizationProcessRequestJPanel processWorkRequestJPanel = new EnergyOptimizationProcessRequestJPanel(userProcessContainer, request);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Process has already been resolved!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_processRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeeRequestTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processRequest;
    // End of variables declaration//GEN-END:variables
}
