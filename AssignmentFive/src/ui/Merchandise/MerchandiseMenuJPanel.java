/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Merchandise;

import business.Business;
import business.Enterprise;
import business.Enterprises.EnterpriseDirectory;
import business.useraccount.UserAccount;
import business.merchandise.merchandise;
import business.merchandise.merchandiseShop;
import business.merchandise.merchandiseShopDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aravindpolepeddi
 */
public class MerchandiseMenuJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RestaurantMenuJPanel
     */
    Boolean update = false;
    JPanel userProcessContainer;
    Business system;
    UserAccount useraccount;
    merchandise merchandise;
    merchandiseShopDirectory merchShopDirectory;
    merchandiseShop merchShop;
    ArrayList<merchandiseShop> mergeShopList;
    Map<String, Enterprise> network;
    EnterpriseDirectory enterpriseDirectory;
    Enterprise enterprise;
    String networkString;

    public MerchandiseMenuJPanel(JPanel userProcessContainer, UserAccount account, Business system) {
        initComponents();
        this.networkString = account.getNetwork();
        this.mergeShopList = new ArrayList<>();
        this.userProcessContainer = userProcessContainer;
        this.useraccount = account;
        this.system = system;

        if (system.getNetworkList() == null) {
            this.network = new HashMap<String, Enterprise>();
        } else {
            this.network = system.getNetworkList();
        }

        this.enterprise = system.findEnterpriseByNetwork(account.getNetwork());

        if (enterprise.getMerchandiseShopDirectory() == null) {
            this.merchShopDirectory = new merchandiseShopDirectory();
        } else {
            this.merchShopDirectory = enterprise.getMerchandiseShopDirectory();
        }

        if (merchShopDirectory != null && merchShopDirectory.getMerchandiseShopList() != null && !merchShopDirectory.getMerchandiseShopList().isEmpty()) {
            merchShop = merchShopDirectory.getMerchandiseShopList().get(0);
        }

        if (merchShop == null) {
            merchShop = new merchandiseShop();
        }

        refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextItemName = new javax.swing.JTextField();
        jTextPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblRestaurantName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 255, 255));

        jTextItemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextItemName.setForeground(new java.awt.Color(0, 204, 204));

        jTextPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextPrice.setForeground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("ITEM NAME : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("PRICE : ");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Submit");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Price"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Back");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 51));
        jButton4.setText("Update");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblRestaurantName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRestaurantName.setForeground(new java.awt.Color(0, 153, 153));
        lblRestaurantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestaurantName.setText("MERCHANDISE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRestaurantName, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRestaurantName)
                    .addComponent(jButton3))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(199, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        boolean formValid = true;


        StringBuilder Error = new StringBuilder();

        merchandise merchandise = new merchandise();

        if (jTextItemName.getText().isEmpty()) {
            formValid = false;
            Error.append("Enter Valid Name \n");
        } else {
            merchandise.setItemName(jTextItemName.getText());
            jTextItemName.setText("");
        }
        if (jTextPrice.getText().isEmpty()) {
            formValid = false;
            Error.append("Enter Price \n");
        } else {
            if(validateIntegerInput(jTextPrice.getText())){
                
                merchandise.setPrice(Integer.parseInt(jTextPrice.getText()));
            jTextPrice.setText(""); 
            }
            else{
                formValid = false;
                Error.append("Please enter numeric values");
            }
           
        }
        
        if(formValid){
            merchShop = merchShopDirectory.findMerchandiseShop(useraccount.getUsername());

        if (merchShop == null) {
            merchShop = merchShopDirectory.addShop();
        }

        }
        if (formValid && merchShop != null && merchShop.findItem(merchandise.getItemName(), merchandise.getPrice()) != null) {
            Error.append("Item exists \n");
        }
        if (Error.isEmpty() && formValid) {
            merchShop.addMerchandise(merchandise);
        } else {
            JOptionPane.showMessageDialog(this, Error);
        }
        if(formValid){
             mergeShopList.add(merchShop);
        merchShopDirectory.setMerchandiseShopList(mergeShopList);
        enterprise.setMerchandiseShopDirectory(merchShopDirectory);
        network.put(networkString, enterprise);
        system.setNetworkList(network);

        refreshTable();
        }
//        }

    }//GEN-LAST:event_jButton1ActionPerformed
    private static boolean validateIntegerInput(String userInput) {
        if (userInput.matches("^[0-9]*$") ) {
            return true;
        } else {
            return false;
        }
    }
    public void refreshTable() {

//        mmerchShop = merchShopDirectory.findMerchandiseShop(useraccount.getUsername());
        int rowCount = jTable1.getRowCount();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        if (merchShop != null) {
            for (merchandise i : merchShop.getMerchandiseMenu()) {
                Object row[] = new Object[2];
                row[0] = i.getItemName();
                row[1] = i.getPrice();
                model.addRow(row);
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (update) {
            JOptionPane.showMessageDialog(this, "Please Save your updated order");
        } else {
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        merchandiseShop merchShop = enterprise.getMerchandiseShopDirectory().findMerchandiseShop(useraccount.getUsername());
        int rowdelete = jTable1.getSelectedRow();
        if (rowdelete < 0) {
            JOptionPane.showMessageDialog(this, "Please select Item to Delete");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(rowdelete);
        int rowCount = jTable1.getRowCount();
        int j = 0;
        for (merchandise merch : merchShop.getMerchandiseMenu()) {
            if (j == rowdelete) {
                merchShop.getMerchandiseMenu().remove(merch);
                break;
            }
            j++;
        }
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        update = true;
        merchandiseShop merchShop = system.getMerchandiseShopDirectory().findMerchandiseShop(useraccount.getUsername());
        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Merchandise");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int j = 0;
            for (merchandise merch : merchShop.getMerchandiseMenu()) {
                if (j == selectedRowIndex) {
                    jTextItemName.setText(merch.getItemName());
                    jTextPrice.setText(String.valueOf(merch.getPrice()));
                    merchShop.getMerchandiseMenu().remove(merch);
                }
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextItemName;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JLabel lblRestaurantName;
    // End of variables declaration//GEN-END:variables
}
