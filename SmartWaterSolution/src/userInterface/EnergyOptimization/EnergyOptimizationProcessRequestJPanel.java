/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.EnergyOptimization;

import business.EcoSystems;
import business.organization.Organization;
import business.userAccount.UserAccount;
import business.workqueue.EnergyOptimization.EnergyOptimizationRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ayush
 */
public class EnergyOptimizationProcessRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EnergyOptimizationProcessRequestJPanel
     */
    
    private JPanel userProcessContainer;
    private EnergyOptimizationRequest request;
    
    public EnergyOptimizationProcessRequestJPanel(JPanel userProcessContainer, EnergyOptimizationRequest request) 
    {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.request=request;
    }

    public EnergyOptimizationProcessRequestJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystems business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTxtArea = new javax.swing.JTextArea();
        submitBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel2.setText("Comments");

        commentsTxtArea.setColumns(20);
        commentsTxtArea.setRows(5);
        jScrollPane1.setViewportView(commentsTxtArea);

        submitBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 20)); // NOI18N
        jLabel1.setText("Energy Optimization Process Request");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(backBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        String comments = commentsTxtArea.getText();
        if(comments.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the resolution in the comments section","Warning",1);
        }
        else{
           request.setStatus("Completed");
           request.setResult(comments);
           
           String customerAddress = request.getCustomer().getConsumer().getAddress();
           String pumpingAddress = request.getCustomer().getConsumer().getPumpConfiguration().energyOptimizedPumpConfiguration(customerAddress);
           request.getCustomer().getConsumer().getPumpConfiguration().setNewPumpConfigurationAddress(pumpingAddress);
           request.getCustomer().getConsumer().getPumpConfiguration().setPumpEfficiency(request.getCustomer().getConsumer().getPumpConfiguration().getNewPumpConfigurationAddress());
           request.getSender().getCustomer().getConsumer().getPumpConfiguration().setNewPumpConfigurationAddress(pumpingAddress);
           request.getSender().getCustomer().getConsumer().getPumpConfiguration().setPumpEfficiency(request.getCustomer().getConsumer().getPumpConfiguration().getNewPumpConfigurationAddress());
           request.getSender().getCustomer().getConsumer().getPumpConfiguration().setIsOptimized(true);
           
           JOptionPane.showMessageDialog(null,"Request has been completed successfully","Success",1);
           commentsTxtArea.setText("");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        EnergyOptimizationRoleWorkAreaJPanel dwjp = (EnergyOptimizationRoleWorkAreaJPanel) component;
        dwjp.populateTable();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextArea commentsTxtArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
