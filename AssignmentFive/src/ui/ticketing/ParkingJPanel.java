/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ticketing;

import business.Business;
import business.Enterprise;
import business.Enterprises.EnterpriseDirectory;
import business.ticketing.CarBooking;
import business.ticketing.Parking;
import business.ticketing.PickandDropDirectory;
import business.useraccount.UserAccount;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingJPanel extends javax.swing.JPanel {

    Boolean update = false;
    JPanel userProcessContainer;
    Business system;
    UserAccount useraccount;
    Parking parking;
    private PickandDropDirectory pdDirectory;
    Map<String, Enterprise> network;
    EnterpriseDirectory enterpriseDirectory;
    Enterprise enterprise;
    String networkString;

    public ParkingJPanel(JPanel userProcessContainer, UserAccount account, Business system) {
        initComponents();
        this.networkString = account.getNetwork();

        if (system.getNetworkList() == null) {
            this.network = new HashMap<String, Enterprise>();
        } else {
            this.network = system.getNetworkList();
        }

        this.enterprise = system.findEnterpriseByNetwork(account.getNetwork());

        if (enterprise.getPdDirectory() == null) {
            pdDirectory = new PickandDropDirectory();
        } else {
            this.pdDirectory = enterprise.getPdDirectory();
        }

        this.userProcessContainer = userProcessContainer;
        this.useraccount = account;
        this.system = system;
        parking = new Parking();
        refreshTable();
    }

    /**
     * Creates new form ParkingJPanel
     */
    public ParkingJPanel() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextCarNumber = new javax.swing.JTextField();
        jDateChooserEnter = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserExit = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jTextSlotNumber = new javax.swing.JTextField();
        jTextPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextTicketNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CarNumber", "EnterTime", "Exit Time", "SlotNumber", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Car Number");

        jLabel2.setText("Enter Time");

        jLabel3.setText("Exit Time");

        jLabel4.setText("Slot Number");

        jLabel5.setText("Price");

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Services");

        jLabel6.setText("Ticket Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDateChooserEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextCarNumber)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextTicketNumber)
                                    .addComponent(jDateChooserExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextSlotNumber)
                                    .addComponent(jTextPrice))))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSave)
                        .addGap(88, 88, 88))))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(214, 214, 214)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextCarNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextSlotNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTicketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void refreshTable() {

        int rowCount = jTable1.getRowCount();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Parking p : enterprise.getParkingDirectory().getParkingList()) {
            Object row[] = new Object[6];
            row[0] = p.getCarNumber();
            row[1] = p.getEnteredTie();
            row[2] = p.getExitTime();
            row[3] = p.getSlotNumber();
            row[4] = p.getTicketNumber();
            row[5] = p.getPrice();
            model.addRow(row);
        }
    }

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:

        StringBuilder Error = new StringBuilder();

        if (jTextCarNumber.getText().isEmpty()) {
            Error.append("Enter Valid Car Number \n");
        } else {
            if (pdDirectory.getCarBookingList() != null && !pdDirectory.getCarBookingList().isEmpty()) {
                for (CarBooking cb : pdDirectory.getCarBookingList()) {
                    if (cb.getCarNumber().equals(jTextCarNumber.getText())) {
                        cb.setStatus("dropped");
                    }
                }
            }
            parking.setCarNumber(jTextCarNumber.getText());
            jTextCarNumber.setText("");
        }

        if (jDateChooserEnter.getDate() == null) {
            Error.append("Enter Entry Time \n");
        } else {
            parking.setEnteredTie(jDateChooserEnter.getDate());
            jDateChooserEnter.setDate(null);
        }
        if (jDateChooserExit.getDate() == null) {
            Error.append("Enter Exit Time \n");
        } else {
            parking.setEnteredTie(jDateChooserExit.getDate());
            jDateChooserExit.setDate(null);
        }
        if (jTextSlotNumber.getText().isEmpty()) {
            Error.append("Enter Valid Slot Number \n");
        } else {
            parking.setSlotNumber(Integer.parseInt(jTextSlotNumber.getText()));
            jTextSlotNumber.setText("");
        }
        if (jTextTicketNumber.getText().isEmpty()) {
            Error.append("Enter Valid Ticket Number \n");
        } else {
            parking.setTicketNumber(Integer.parseInt(jTextTicketNumber.getText()));
            jTextTicketNumber.setText("");
        }
        if (jTextPrice.getText().isEmpty()) {
            Error.append("Enter Price \n");
        } else {
            parking.setPrice(Integer.parseInt(jTextPrice.getText()));
            jTextPrice.setText("");
        }
        if (Error.isEmpty()) {
            enterprise.getParkingDirectory().getParkingList().add(parking);
        } else {
            JOptionPane.showMessageDialog(this, Error);
        }
        if (update = true) {
            update = false;
        }

        refreshTable();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Vehicle");
            return;
        } else {
            update = true;
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int j = 0;
            for (Parking p : enterprise.getParkingDirectory().getParkingList()) {
                if (j == selectedRowIndex) {
                    jTextCarNumber.setText(p.getCarNumber());
                    jDateChooserEnter.setDate(p.getEnteredTie());
                    jDateChooserExit.setDate(p.getExitTime());
                    jTextSlotNumber.setText(String.valueOf(p.getSlotNumber()));
                    jTextTicketNumber.setText(String.valueOf(p.getTicketNumber()));
                    jTextPrice.setText(String.valueOf(p.getPrice()));
                    enterprise.getParkingDirectory().getParkingList().remove(p);
                }
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonSave;
    private com.toedter.calendar.JDateChooser jDateChooserEnter;
    private com.toedter.calendar.JDateChooser jDateChooserExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCarNumber;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jTextSlotNumber;
    private javax.swing.JTextField jTextTicketNumber;
    // End of variables declaration//GEN-END:variables
}
