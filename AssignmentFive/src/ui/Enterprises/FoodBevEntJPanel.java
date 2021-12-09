/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Enterprises;

import business.Business;
import business.FlagClass;
import business.Restaurant.Restaurant;
import business.organizations.FoodBevOrganization;
import business.premium.Premium;
import business.premium.PremiumDirectory;
import business.role.FoodBeverageEntAdminRole;
import business.role.FoodBeverageOrgAdminRole;
import business.role.RestaurantRole;
import business.role.Role;
import business.suites.Suites;
import business.suites.SuitesDirectory;
import business.useraccount.UserAccount;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deepv
 */
public class FoodBevEntJPanel extends javax.swing.JPanel {

    Business business;
    SuitesDirectory suites;
    PremiumDirectory premium;
    FlagClass flags;

    /**
     * Creates new form FoodBevEntJPanel
     */
    public FoodBevEntJPanel(JPanel userProcessContainer, UserAccount account, Business business) {
        initComponents();

        this.business = business;

        if (business.getSuitesDirectory() == null) {
            this.suites = new SuitesDirectory();
        } else {
            this.suites = business.getSuitesDirectory();
        }

        if (business.getPremiumDirectory() == null) {
            this.premium = new PremiumDirectory();
        } else {
            this.premium = business.getPremiumDirectory();
        }
        this.flags = new FlagClass();

        pnlUpdate.setVisible(false);
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        NavigationJPanel = new javax.swing.JPanel();
        btnManageZones = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        workAreaPanel = new javax.swing.JPanel();
        lblRestaurantName1 = new javax.swing.JLabel();
        lblAddUser2 = new javax.swing.JLabel();
        lblManagerName2 = new javax.swing.JLabel();
        txtCreateFoodManagerName = new javax.swing.JTextField();
        lblRestaurantName4 = new javax.swing.JLabel();
        lblUserName2 = new javax.swing.JLabel();
        txtCreateFoodManagerUserName = new javax.swing.JTextField();
        lblPassword2 = new javax.swing.JLabel();
        pwdCreateFoodManagerPassword = new javax.swing.JPasswordField();
        btnCreateUser1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFoodBevManagers = new javax.swing.JTable();
        pnlUpdate = new javax.swing.JPanel();
        cmbCreateManager = new javax.swing.JComboBox<>();
        lblRestaurantName = new javax.swing.JLabel();
        txtRestaurantName = new javax.swing.JTextField();
        manageZones = new javax.swing.JPanel();
        lblRestaurantName2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSuitsCount = new javax.swing.JTextField();
        txtPremiumCount = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSave2 = new javax.swing.JButton();

        NavigationJPanel.setBackground(new java.awt.Color(0, 51, 51));

        btnManageZones.setBackground(new java.awt.Color(206, 217, 217));
        btnManageZones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnManageZones.setForeground(new java.awt.Color(0, 51, 51));
        btnManageZones.setText("Manage Zones");
        btnManageZones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageZones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageZonesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageZonesMouseExited(evt);
            }
        });
        btnManageZones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageZonesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationJPanelLayout = new javax.swing.GroupLayout(NavigationJPanel);
        NavigationJPanel.setLayout(NavigationJPanelLayout);
        NavigationJPanelLayout.setHorizontalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavigationJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnManageZones, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        NavigationJPanelLayout.setVerticalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationJPanelLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(btnManageZones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(NavigationJPanel);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        workAreaPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblRestaurantName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRestaurantName1.setForeground(new java.awt.Color(0, 153, 153));
        lblRestaurantName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestaurantName1.setText("Food & Beverages");

        lblAddUser2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddUser2.setForeground(new java.awt.Color(0, 102, 102));
        lblAddUser2.setText("ADD NEW USER");

        lblManagerName2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblManagerName2.setText("Manager Name :");

        lblRestaurantName4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRestaurantName4.setText("Organization Type :");

        lblUserName2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUserName2.setText("Username : ");

        lblPassword2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPassword2.setText("Password : ");

        btnCreateUser1.setBackground(new java.awt.Color(175, 211, 211));
        btnCreateUser1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreateUser1.setForeground(new java.awt.Color(0, 102, 102));
        btnCreateUser1.setText("CREATE");
        btnCreateUser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateUser1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateUser1MouseExited(evt);
            }
        });
        btnCreateUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUser1ActionPerformed(evt);
            }
        });

        btnDelete1.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(153, 0, 0));
        btnDelete1.setText("DELETE USER");
        btnDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDelete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDelete1MouseExited(evt);
            }
        });
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnUpdate1.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate1.setForeground(new java.awt.Color(0, 102, 0));
        btnUpdate1.setText("UPDATE USER");
        btnUpdate1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdate1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdate1MouseExited(evt);
            }
        });
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        tblFoodBevManagers.setBackground(new java.awt.Color(255, 255, 255));
        tblFoodBevManagers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblFoodBevManagers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "USER NAME", "PASSWORD", "MANAGER NAME", "ORG TYP"
            }
        ));
        tblFoodBevManagers.setSelectionBackground(new java.awt.Color(153, 209, 232));
        tblFoodBevManagers.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane3.setViewportView(tblFoodBevManagers);

        pnlUpdate.setBackground(new java.awt.Color(240, 255, 255));

        javax.swing.GroupLayout pnlUpdateLayout = new javax.swing.GroupLayout(pnlUpdate);
        pnlUpdate.setLayout(pnlUpdateLayout);
        pnlUpdateLayout.setHorizontalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        pnlUpdateLayout.setVerticalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        cmbCreateManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT TYPE", "SUITE", "PREMIUM" }));

        lblRestaurantName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRestaurantName.setText("Restaurant Name : ");

        javax.swing.GroupLayout workAreaPanelLayout = new javax.swing.GroupLayout(workAreaPanel);
        workAreaPanel.setLayout(workAreaPanelLayout);
        workAreaPanelLayout.setHorizontalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRestaurantName1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workAreaPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workAreaPanelLayout.createSequentialGroup()
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(workAreaPanelLayout.createSequentialGroup()
                                .addComponent(btnDelete1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate1))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(workAreaPanelLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(lblAddUser2))
                            .addGroup(workAreaPanelLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUserName2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCreateFoodManagerUserName)
                                    .addComponent(pwdCreateFoodManagerPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(btnCreateUser1)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workAreaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblManagerName2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblRestaurantName4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(workAreaPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblRestaurantName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCreateFoodManagerName, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(cmbCreateManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(38, 38, 38))
        );
        workAreaPanelLayout.setVerticalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblRestaurantName1)
                .addGap(62, 62, 62)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workAreaPanelLayout.createSequentialGroup()
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate1)
                            .addComponent(btnDelete1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(pnlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(workAreaPanelLayout.createSequentialGroup()
                        .addComponent(lblAddUser2)
                        .addGap(18, 18, 18)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblManagerName2)
                            .addComponent(txtCreateFoodManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRestaurantName4)
                            .addComponent(cmbCreateManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRestaurantName))
                        .addGap(8, 8, 8)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCreateFoodManagerUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUserName2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword2)
                            .addComponent(pwdCreateFoodManagerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateUser1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLayeredPane1.add(workAreaPanel, "card2");

        manageZones.setBackground(new java.awt.Color(240, 255, 255));

        lblRestaurantName2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRestaurantName2.setForeground(new java.awt.Color(0, 153, 153));
        lblRestaurantName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestaurantName2.setText("Zones");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("How many 'Suite' tiers do you want?");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("How many 'Premium' tiers do you want?");

        btnBack.setBackground(new java.awt.Color(255, 204, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 0, 51));
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave2.setBackground(new java.awt.Color(215, 254, 211));
        btnSave2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave2.setForeground(new java.awt.Color(72, 151, 64));
        btnSave2.setText("SAVE");
        btnSave2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageZonesLayout = new javax.swing.GroupLayout(manageZones);
        manageZones.setLayout(manageZonesLayout);
        manageZonesLayout.setHorizontalGroup(
            manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageZonesLayout.createSequentialGroup()
                .addGroup(manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, manageZonesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRestaurantName2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnBack))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, manageZonesLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSuitsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPremiumCount, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(manageZonesLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageZonesLayout.setVerticalGroup(
            manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageZonesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRestaurantName2)
                    .addComponent(btnBack))
                .addGap(191, 191, 191)
                .addGroup(manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSuitsCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(manageZonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPremiumCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143)
                .addComponent(btnSave2)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jLayeredPane1.add(manageZones, "card2");

        jSplitPane1.setRightComponent(jLayeredPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageZonesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageZonesMouseEntered

    }//GEN-LAST:event_btnManageZonesMouseEntered

    private void btnManageZonesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageZonesMouseExited

    }//GEN-LAST:event_btnManageZonesMouseExited

    private void btnManageZonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageZonesActionPerformed
        txtSuitsCount.setText(String.valueOf(suites.getCount()));
        txtPremiumCount.setText(String.valueOf(premium.getCount()));
        switchPanels(manageZones);
    }//GEN-LAST:event_btnManageZonesActionPerformed

    private void btnCreateUser1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateUser1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateUser1MouseEntered

    private void btnCreateUser1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateUser1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateUser1MouseExited

    private void btnCreateUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUser1ActionPerformed
        String userName = txtCreateFoodManagerUserName.getText();
        String password = pwdCreateFoodManagerPassword.getText();
        String orgType = cmbCreateManager.getSelectedItem().toString();

        if (!business.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            JOptionPane.showMessageDialog(null, "UserName already taken!");
            txtCreateFoodManagerUserName.setText("");
            pwdCreateFoodManagerPassword.setText("");
        } else {

            if (orgType.equals("SUITE") && suites != null && suites.getCount() > 0 && suites.getCount() == suites.getSuitesList().size()) {
                JOptionPane.showMessageDialog(null, "No more Suites to create");
                return;
            }

            if (orgType.equals("PREMIUM") && premium != null && premium.getCount() > 0 && premium.getCount() == premium.getPremiumList().size()) {
                JOptionPane.showMessageDialog(null, "No more Premium Slots to create");
                return;
            }

            String managerame = txtCreateFoodManagerName.getText();

            FoodBeverageOrgAdminRole role = new FoodBeverageOrgAdminRole();
            business.getUserAccountDirectory().createUserAccount(userName, managerame, password, role);

            if (orgType.equals("SUITE")) {
                Suites suite = suites.addSuites();
                suite.setManagerName(managerame);
                suite.setUserName(userName);
                suite.setManagerType("SUITE");
                business.setSuitesDirectory(suites);
            } else if (orgType.equals("PREMIUM")) {
                Premium prem = premium.addPremium();
                prem.setManagerName(managerame);
                prem.setUserName(userName);
                prem.setManagerType("PREMIUM");
                prem.setRestaurantName(txtRestaurantName.getText());
                business.setPremiumDirectory(premium);
            }

            txtCreateFoodManagerName.setText("");
            cmbCreateManager.setSelectedItem("SELECT TYPE");
            txtCreateFoodManagerUserName.setText("");
            pwdCreateFoodManagerPassword.setText("");
            txtRestaurantName.setText("");

            populateTable();
        }
    }//GEN-LAST:event_btnCreateUser1ActionPerformed

    private void btnDelete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelete1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1MouseEntered

    private void btnDelete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelete1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1MouseExited

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        int selectedRowIndex = tblFoodBevManagers.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a User");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblFoodBevManagers.getModel();
            UserAccount selectedUserAccount = (UserAccount) model.getValueAt(selectedRowIndex, 0);
            UserAccount accountToBeRemoved = business.getUserAccountDirectory().fetchUserAccountUsingUserName(selectedUserAccount.getUsername());
            business.getUserAccountDirectory().removeAccount(accountToBeRemoved);
            JOptionPane.showMessageDialog(null, "User Account deleted successfully.");
            populateTable();

            Suites removedSuite = suites.findSuiteByManagerName(selectedUserAccount.getName());
            if (removedSuite != null) {
                suites.removeSuite(removedSuite);
            }

            Premium removedPremium = premium.findPremiumByManagerName(selectedUserAccount.getName());
            if (removedPremium != null) {
                premium.removePremium(removedPremium);
            }
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdate1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate1MouseEntered

    private void btnUpdate1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate1MouseExited

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        int selectedRowIndex = tblFoodBevManagers.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a User");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblFoodBevManagers.getModel();
            UserAccount selectedUserAccount = (UserAccount) model.getValueAt(selectedRowIndex, 0);
            pnlUpdate.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave2ActionPerformed
        suites.setCount(Integer.parseInt(txtSuitsCount.getText()));
        premium.setCount(Integer.parseInt(txtPremiumCount.getText()));
        business.setSuitesDirectory(suites);
        business.setPremiumDirectory(premium);
        JOptionPane.showMessageDialog(this, "Updated seat count");
        switchPanels(workAreaPanel);
        txtSuitsCount.setText("");
        txtPremiumCount.setText("");
        flags.setSuiteCount(Integer.parseInt(txtSuitsCount.getText()));
        flags.setPremiumCount(Integer.parseInt(txtPremiumCount.getText()));
    }//GEN-LAST:event_btnSave2ActionPerformed

    private void switchPanels(Component component) {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(component);
        jLayeredPane1.revalidate();
        jLayeredPane1.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NavigationJPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateUser1;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnManageZones;
    private javax.swing.JButton btnSave2;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> cmbCreateManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblAddUser2;
    private javax.swing.JLabel lblManagerName2;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblRestaurantName;
    private javax.swing.JLabel lblRestaurantName1;
    private javax.swing.JLabel lblRestaurantName2;
    private javax.swing.JLabel lblRestaurantName4;
    private javax.swing.JLabel lblUserName2;
    private javax.swing.JPanel manageZones;
    private javax.swing.JPanel pnlUpdate;
    private javax.swing.JPasswordField pwdCreateFoodManagerPassword;
    private javax.swing.JTable tblFoodBevManagers;
    private javax.swing.JTextField txtCreateFoodManagerName;
    private javax.swing.JTextField txtCreateFoodManagerUserName;
    private javax.swing.JTextField txtPremiumCount;
    private javax.swing.JTextField txtRestaurantName;
    private javax.swing.JTextField txtSuitsCount;
    private javax.swing.JPanel workAreaPanel;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblFoodBevManagers.getModel();
        model.setRowCount(0);

        for (UserAccount userAccount : business.getUserAccountDirectory().getUserAccountList()) {
            Object[] row = new Object[4];
            RestaurantRole role = new RestaurantRole();
            Suites currentSuite = null;
            Premium currentPremium = null;
            if (suites != null && suites.getSuitesList() != null && !suites.getSuitesList().isEmpty()) {
                currentSuite = suites.getSuitesList().stream().filter(x -> x.getManagerName().equals(userAccount.getName())).findAny().orElse(null);
            }
            if (premium != null && premium.getPremiumList() != null && !premium.getPremiumList().isEmpty()) {
                currentPremium = premium.getPremiumList().stream().filter(x -> x.getManagerName().equals(userAccount.getName())).findAny().orElse(null);
            }
            if (userAccount.getRole() != null && userAccount.getRole().type != null && userAccount.getRole().type == Role.RoleType.FoodBeverageEntAdmin) {

                row[0] = userAccount;
                row[1] = userAccount.getPassword();
                row[2] = userAccount.getName();

                if (currentSuite != null) {
                    row[3] = currentSuite.getManagerType();
                } else if (currentPremium != null) {
                    row[3] = currentPremium.getManagerType();
                }
                model.addRow(row);
            }
        }
    }
}
