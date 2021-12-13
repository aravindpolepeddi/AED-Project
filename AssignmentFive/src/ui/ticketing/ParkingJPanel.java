/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ticketing;

import business.Business;
import business.Customer.Customer;
import business.Customer.CustomerDirectory;
import business.Enterprise;
import business.Enterprises.EnterpriseDirectory;
import business.hrservices.CleaningServices;
import business.hrservices.CleaningServicesDirectory;
import business.hrservices.EmergencyServices;
import business.hrservices.EmergencyServicesDirectory;
import business.hrservices.SecurityServices;
import business.hrservices.SecurityServicesDirectory;
import business.hrservices.Staff;
import business.hrservices.TechnicalServices;
import business.hrservices.TechnicalServicesDirectory;
import business.ticketing.CarBooking;
import business.ticketing.Parking;
import business.ticketing.ParkingDirectory;
import business.ticketing.PickandDropDirectory;
import business.useraccount.UserAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aravindpolepeddi
 */
public class ParkingJPanel extends javax.swing.JPanel {

    Boolean update;
    JPanel userProcessContainer;
    Business system;
    UserAccount useraccount;
    Parking parking;
    private PickandDropDirectory pdDirectory;
    Map<String, Enterprise> network;
    EnterpriseDirectory enterpriseDirectory;
    Enterprise enterprise;
    String networkString;
    CustomerDirectory customerDirectory;
    Customer customer;
    ParkingDirectory parkingDirectory;
    CleaningServicesDirectory cleaningDirectory;
    EmergencyServicesDirectory emergencyServiceDirectory;
    SecurityServicesDirectory securityServicesDirectory;
    TechnicalServicesDirectory technicalServicesDirectory;
    List<Staff> staffMembers;

    public ParkingJPanel(JPanel userProcessContainer, UserAccount account, Business system) {
        initComponents();
        pnlTable.setVisible(false);
        this.update = system.isUpdate();
        this.networkString = account.getNetwork();
        this.staffMembers = new ArrayList<>();
        txtInstructions.setVisible(false);
        btnSubmit.setVisible(false);
        btnDetails2.setVisible(false);
        btnDetails4.setVisible(false);
        btnDetails3.setVisible(false);

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

        if (enterprise.getParkingDirectory() == null) {
            parkingDirectory = new ParkingDirectory();
        } else {
            this.parkingDirectory = enterprise.getParkingDirectory();
        }

        if (enterprise.getCustomerDirectory() == null) {
            this.customerDirectory = new CustomerDirectory();
        } else {
            this.customerDirectory = enterprise.getCustomerDirectory();
        }

        if (enterprise.getCleaningServices() != null) {
            this.cleaningDirectory = enterprise.getCleaningServices();
            for (CleaningServices cleaningServices : this.cleaningDirectory.getCleaningServices()) {
                if (cleaningServices.getStaffDirectory() != null && cleaningServices.getStaffDirectory().getStaffList() != null && !cleaningServices.getStaffDirectory().getStaffList().isEmpty()) {
                    staffMembers.addAll(cleaningServices.getStaffDirectory().getStaffList());
                }
            }
        }

        if (enterprise.getEmergencyServices() != null) {
            this.emergencyServiceDirectory = enterprise.getEmergencyServices();
            for (EmergencyServices emergencyServices : this.emergencyServiceDirectory.getEmergencyServices()) {
                if (emergencyServices.getStaffDirectory() != null && emergencyServices.getStaffDirectory().getStaffList() != null && !emergencyServices.getStaffDirectory().getStaffList().isEmpty()) {
                    staffMembers.addAll(emergencyServices.getStaffDirectory().getStaffList());
                }
            }
        }

        if (enterprise.getSecurityServices() != null) {
            this.securityServicesDirectory = enterprise.getSecurityServices();
            for (SecurityServices securityServices : this.securityServicesDirectory.getSecurityServices()) {
                if (securityServices.getStaffDirectory() != null && securityServices.getStaffDirectory().getStaffList() != null && !securityServices.getStaffDirectory().getStaffList().isEmpty()) {
                    staffMembers.addAll(securityServices.getStaffDirectory().getStaffList());
                }
            }
        }

        if (enterprise.getTechnicalServices() != null) {
            this.technicalServicesDirectory = enterprise.getTechnicalServices();
            for (TechnicalServices techServices : this.technicalServicesDirectory.getGroundServices()) {
                if (techServices.getStaffDirectory() != null && techServices.getStaffDirectory().getStaffList() != null && !techServices.getStaffDirectory().getStaffList().isEmpty()) {
                    staffMembers.addAll(techServices.getStaffDirectory().getStaffList());
                }
            }
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
        jTextTicketNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblRestaurantName = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServices = new javax.swing.JTable();
        btnServices = new javax.swing.JButton();
        btnDetails4 = new javax.swing.JButton();
        btnDetails3 = new javax.swing.JButton();
        btnDetails2 = new javax.swing.JButton();
        txtInstructions = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 51));
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
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Car Number");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Enter Time");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Exit Time");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Slot Number");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Price");

        jButtonSave.setBackground(new java.awt.Color(204, 255, 204));
        jButtonSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(0, 102, 0));
        jButtonSave.setText("Save");
        jButtonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 51));
        jButton2.setText("Update");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Ticket Number");

        lblRestaurantName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRestaurantName.setForeground(new java.awt.Color(0, 153, 153));
        lblRestaurantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestaurantName.setText("PARKING");

        pnlTable.setBackground(new java.awt.Color(240, 255, 255));

        tblServices.setBackground(new java.awt.Color(255, 255, 255));
        tblServices.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblServices.setForeground(new java.awt.Color(0, 51, 51));
        tblServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STAFF MANAGER", "SERVICE TYPE", "SUB-TYPE", "SERVICE-MANAGER", "STATUS"
            }
        ));
        tblServices.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblServices.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane2.setViewportView(tblServices);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnServices.setBackground(new java.awt.Color(204, 255, 204));
        btnServices.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnServices.setForeground(new java.awt.Color(0, 153, 0));
        btnServices.setText("Services");
        btnServices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });

        btnDetails4.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails4.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails4.setText("Add Instructions");
        btnDetails4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetails4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetails4MouseExited(evt);
            }
        });
        btnDetails4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails4ActionPerformed(evt);
            }
        });

        btnDetails3.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails3.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails3.setText("Release");
        btnDetails3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetails3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetails3MouseExited(evt);
            }
        });
        btnDetails3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails3ActionPerformed(evt);
            }
        });

        btnDetails2.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails2.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails2.setText("Hire");
        btnDetails2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetails2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetails2MouseExited(evt);
            }
        });
        btnDetails2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails2ActionPerformed(evt);
            }
        });

        txtInstructions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtInstructions.setForeground(new java.awt.Color(0, 51, 51));

        btnSubmit.setBackground(new java.awt.Color(204, 255, 204));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(0, 102, 0));
        btnSubmit.setText("Submit Instructions");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(btnDetails2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDetails4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDetails3)
                                        .addGap(28, 28, 28)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jTextCarNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserExit, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextSlotNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextTicketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton2)
                                .addGap(272, 272, 272)
                                .addComponent(btnServices))
                            .addComponent(lblRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSave)
                        .addGap(51, 51, 51))))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDateChooserEnter, jDateChooserExit, jTextCarNumber});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextPrice, jTextSlotNumber, jTextTicketNumber});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblRestaurantName)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(btnServices))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
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
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDetails2)
                            .addComponent(btnDetails3)
                            .addComponent(btnDetails4))
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDateChooserEnter, jDateChooserExit, jTextCarNumber, jTextPrice, jTextSlotNumber, jTextTicketNumber});

    }// </editor-fold>//GEN-END:initComponents

    public void refreshTable() {

        int rowCount = jTable1.getRowCount();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Parking p : parkingDirectory.getParkingList()) {
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
                    if (cb.getCarNumber() == Integer.parseInt(jTextCarNumber.getText())) {
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
            parking.setExitTime(jDateChooserExit.getDate());
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
            customer = customerDirectory.findCustomerByTicketId(Integer.parseInt(jTextTicketNumber.getText()));
            jTextTicketNumber.setText("");
        }
        if (jTextPrice.getText().isEmpty()) {
            Error.append("Enter Price \n");
        } else {
            parking.setPrice(Integer.parseInt(jTextPrice.getText()));
            if (customer.getParkingCost() == 0) {
                customer.setParkingCost(Integer.parseInt(jTextPrice.getText()));
            } else {
                customer.setParkingCost(customer.getParkingCost() + Integer.parseInt(jTextPrice.getText()));
            }
            jTextPrice.setText("");
        }
        if (Error.isEmpty()) {
            enterprise.getParkingDirectory().getParkingList().add(parking);
        } else {
            JOptionPane.showMessageDialog(this, Error);
        }
        if (system.isUpdate() == true) {
            system.setUpdate(false);
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
            system.setUpdate(true);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int j = 0;
            for (Parking p : parkingDirectory.getParkingList()) {
                if (j == selectedRowIndex) {
                    jTextCarNumber.setText(p.getCarNumber());
                    jDateChooserEnter.setDate(p.getEnteredTie());
                    jDateChooserExit.setDate(p.getExitTime());
                    jTextSlotNumber.setText(String.valueOf(p.getSlotNumber()));
                    jTextTicketNumber.setText(String.valueOf(p.getTicketNumber()));
                    jTextPrice.setText(String.valueOf(p.getPrice()));
                    enterprise.getParkingDirectory().getParkingList().remove(p);
                    return;
                }
                j++;
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        pnlTable.setVisible(true);
        btnDetails2.setVisible(true);
        btnDetails4.setVisible(true);
        btnDetails3.setVisible(true);
        populateStaff();
    }//GEN-LAST:event_btnServicesActionPerformed

    private void btnDetails2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails2MouseEntered

    private void btnDetails2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails2MouseExited

    private void btnDetails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails2ActionPerformed
        int selectedRowIndex = tblServices.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Staff member");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblServices.getModel();
            Staff selectedStaff = (Staff) model.getValueAt(selectedRowIndex, 0);
            selectedStaff.setStatus("REQUESTED");
            populateStaff();
        }
    }//GEN-LAST:event_btnDetails2ActionPerformed

    private void btnDetails4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails4MouseEntered

    private void btnDetails4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails4MouseExited

    private void btnDetails4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails4ActionPerformed
        txtInstructions.setVisible(true);
        btnSubmit.setVisible(true);
    }//GEN-LAST:event_btnDetails4ActionPerformed

    private void btnDetails3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails3MouseEntered

    private void btnDetails3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails3MouseExited

    private void btnDetails3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails3ActionPerformed
        int selectedRowIndex = tblServices.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Staff member");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblServices.getModel();
            Staff selectedStaff = (Staff) model.getValueAt(selectedRowIndex, 0);

            if (selectedStaff.getStatus() == null || selectedStaff.getStatus().isEmpty() || selectedStaff.getStatus().isBlank() || !selectedStaff.getStatus().equals("HIRED")) {
                JOptionPane.showMessageDialog(this, "Hire this staff member first");
                return;
            }
            selectedStaff.setStatus("FREE");
            populateStaff();
        }
    }//GEN-LAST:event_btnDetails3ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int selectedRowIndex = tblServices.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Staff member");
            return;
        } else {

            if (txtInstructions.getText() == "") {
                JOptionPane.showMessageDialog(this, "Please enter some instructions");
                return;
            } else {
                DefaultTableModel model = (DefaultTableModel) tblServices.getModel();
                Staff selectedStaff = (Staff) model.getValueAt(selectedRowIndex, 0);
                selectedStaff.setInstructions(txtInstructions.getText());
                populateStaff();
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void populateStaff() {
        DefaultTableModel model = (DefaultTableModel) tblServices.getModel();
        model.setRowCount(0);

        if (staffMembers != null && !staffMembers.isEmpty()) {
            for (Staff staffMember : staffMembers) {
                Object[] row = new Object[5];
                row[0] = staffMember;
                row[1] = staffMember.getStaffType();

                if (staffMember.getStaffType().equals("EMERGENCY")) {
                    row[2] = staffMember.getStaffSubType();
                } else {
                    row[2] = "NA";
                }

                row[3] = staffMember.getManager();
                row[4] = staffMember.getStatus();

                model.addRow(row);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails2;
    private javax.swing.JButton btnDetails3;
    private javax.swing.JButton btnDetails4;
    private javax.swing.JButton btnServices;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCarNumber;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jTextSlotNumber;
    private javax.swing.JTextField jTextTicketNumber;
    private javax.swing.JLabel lblRestaurantName;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JTable tblServices;
    private javax.swing.JTextField txtInstructions;
    // End of variables declaration//GEN-END:variables
}
