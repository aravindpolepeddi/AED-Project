/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ticketing;

/**
 *
 * @author aravindpolepeddi
 */
import business.Business;
import business.Enterprise;
import business.Enterprises.EnterpriseDirectory;
import business.merchandise.merchandise;
import business.merchandise.merchandiseShop;
import business.ticketing.CarBooking;
import business.ticketing.PickandDropDirectory;
import business.useraccount.UserAccount;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class PickandDropJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Business system;
    UserAccount useraccount;
    Map<String, Enterprise> network;
    EnterpriseDirectory enterpriseDirectory;
    Enterprise enterprise;
    String networkString;
    PickandDropDirectory pdDirectory;

    /**
     * Creates new form PickandDropJPanel
     */
    public PickandDropJPanel(JPanel userProcessContainer, UserAccount account, Business system) {
        initComponents();

        this.networkString = account.getNetwork();

        if (system.getNetworkList() == null) {
            this.network = new HashMap<String, Enterprise>();
        } else {
            this.network = system.getNetworkList();
        }

        if (account != null && account.getNetwork() != null && !account.getName().isBlank()) {
            this.enterprise = system.findEnterpriseByNetwork(account.getNetwork());
        }

        if (enterprise.getPdDirectory() == null) {
            this.pdDirectory = new PickandDropDirectory();
        } else {
            this.pdDirectory = enterprise.getPdDirectory();
        }

        this.userProcessContainer = userProcessContainer;
        this.useraccount = account;
        this.system = system;
        refreshTable();
    }

    public void refreshTable() {

        int rowCount = tblBookings.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblBookings.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (CarBooking cb : pdDirectory.getCarBookingList()) {
            Object row[] = new Object[6];
            row[0] = cb;
            row[1] = cb.getCustomerName();
            row[2] = cb.getCarNumber();
            row[3] = cb.getStatus();
            row[4] = cb.getTwoWay();
            row[5] = cb.getPrice();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookings = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextPrice = new javax.swing.JTextField();
        lblRestaurantName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 255, 255));

        tblBookings.setBackground(new java.awt.Color(255, 255, 255));
        tblBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PickupPoint", "Customer Name", "Car Number", "Status", "TwoWay", "Price"
            }
        ));
        tblBookings.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblBookings.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(tblBookings);

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setText("Approve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Deny");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 51));
        jButton3.setText("Set Price");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Price");

        jTextPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblRestaurantName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRestaurantName.setForeground(new java.awt.Color(0, 153, 153));
        lblRestaurantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestaurantName.setText("Pick & Drop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextPrice))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblRestaurantName)
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int rowupdate = tblBookings.getSelectedRow();
        if (rowupdate < 0) {
            JOptionPane.showMessageDialog(this, "Please select Booking");
            return;
        }
        int j = 0;
        for (CarBooking cb : pdDirectory.getCarBookingList()) {
            if (j == rowupdate) {
                cb.setStatus("On the Way");
            }
            j++;
        }
        refreshTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int rowupdate = tblBookings.getSelectedRow();
        if (rowupdate < 0) {
            JOptionPane.showMessageDialog(this, "Please select Booking");
            return;
        }
        int j = 0;
        Random randomNum = new Random();
        int randomOrderId = randomNum.nextInt(65536 - 32768);
        for (CarBooking cb : pdDirectory.getCarBookingList()) {
            if (j == rowupdate) {
                if (jTextPrice.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please select Booking");
                    return;
                }
                if (!validateIntegerInput(jTextPrice.getText())) {
                    JOptionPane.showMessageDialog(this, "Please enter correct price value");
                    return;
                }
                cb.setPrice(Integer.parseInt(jTextPrice.getText()));
                cb.setCarNumber(randomOrderId);
            }
            j++;
        }

        refreshTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private static boolean validateIntegerInput(String userInput) {
        if (userInput.matches("^[0-9]*$")) {
            return true;
        } else {
            return false;
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int rowupdate = tblBookings.getSelectedRow();
        if (rowupdate < 0) {
            JOptionPane.showMessageDialog(this, "Please select Booking");
            return;
        }
        int j = 0;
        for (CarBooking cb : pdDirectory.getCarBookingList()) {
            if (j == rowupdate) {
                cb.setStatus("Denied");
            }
            j++;
        }
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JLabel lblRestaurantName;
    private javax.swing.JTable tblBookings;
    // End of variables declaration//GEN-END:variables

}
