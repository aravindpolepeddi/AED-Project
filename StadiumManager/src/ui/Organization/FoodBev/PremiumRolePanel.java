/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Organization.FoodBev;

import business.Business;
import business.Customer.Ticket;
import business.Customer.TicketDirectory;
import business.Enterprise;
import business.Enterprises.EnterpriseDirectory;
import business.Restaurant.Menu;
import business.hrservices.CleaningServices;
import business.hrservices.CleaningServicesDirectory;
import business.hrservices.EmergencyServices;
import business.hrservices.EmergencyServicesDirectory;
import business.hrservices.SecurityServices;
import business.hrservices.SecurityServicesDirectory;
import business.hrservices.Staff;
import business.hrservices.TechnicalServices;
import business.hrservices.TechnicalServicesDirectory;
import business.premium.Premium;
import business.premium.PremiumDirectory;
import business.useraccount.UserAccount;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author deepv
 */
public class PremiumRolePanel extends javax.swing.JPanel {

    Premium premium;
    PremiumDirectory premiumDirectory;
    CleaningServicesDirectory cleaningDirectory;
    EmergencyServicesDirectory emergencyServiceDirectory;
    SecurityServicesDirectory securityServicesDirectory;
    TechnicalServicesDirectory technicalServicesDirectory;
    List<Staff> staffMembers;
    TicketDirectory ticketDirectory;
    Map<String, Enterprise> network;
    EnterpriseDirectory enterpriseDirectory;
    Enterprise enterprise;
    String networkString;

    /**
     * Creates new form PremiumRolePanel
     */
    public PremiumRolePanel(JPanel userProcessContainer, UserAccount account, Business business) {
        initComponents();
        this.networkString = account.getNetwork();
        staffMembers = new ArrayList<>();
        pnlFeedbackTable.setVisible(false);
        btnClose.setVisible(false);
        txtInstructions.setVisible(false);
        btnSubmit.setVisible(false);

        if (business.getNetworkList() == null) {
            this.network = new HashMap<String, Enterprise>();
        } else {
            this.network = business.getNetworkList();
        }

        this.enterprise = business.findEnterpriseByNetwork(account.getNetwork());

        if (enterprise.getPremiumDirectory() == null) {
            this.premiumDirectory = new PremiumDirectory();
        } else {
            this.premiumDirectory = enterprise.getPremiumDirectory();
        }

        if (enterprise.getTicketDirectory() == null) {
            this.ticketDirectory = new TicketDirectory();
        } else {
            this.ticketDirectory = enterprise.getTicketDirectory();
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

        JTableHeader tableHeader = tblOrders.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) tableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        premium = premiumDirectory.findPremiumByManagerName(account.getName());
        lblRestaurantName.setText(premium.getRestaurantName() == null ? account.getName() + "'s Dashboard" : premium.getRestaurantName());
        populateOrders();

        ImageIcon icon1 = new ImageIcon(".\\src\\images\\menu.png");
        Image image1 = icon1.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        btnMenu.setIcon(new ImageIcon(image1));

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
        btnMenu = new javax.swing.JButton();
        btnMenu2 = new javax.swing.JButton();
        btnMenu3 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        workAreaPanel = new javax.swing.JPanel();
        lblRestaurantName = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnFeedback = new javax.swing.JButton();
        pnlFeedbackTable = new javax.swing.JPanel();
        txtTiers = new javax.swing.JTextField();
        btnFeedback1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        EditDetailsPanel = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblCuisine = new javax.swing.JLabel();
        txtCuisine = new javax.swing.JTextField();
        lblVeg = new javax.swing.JLabel();
        chkVeg = new javax.swing.JCheckBox();
        lblNonVeg = new javax.swing.JLabel();
        chkNonVeg = new javax.swing.JCheckBox();
        lblVegan = new javax.swing.JLabel();
        chkVegan = new javax.swing.JCheckBox();
        lvlAll = new javax.swing.JLabel();
        chkAll = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblPhoneNum = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();
        lblEmailId = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        MenuPanel1 = new javax.swing.JPanel();
        lblHeader2 = new javax.swing.JLabel();
        btnBack3 = new javax.swing.JButton();
        btnBack4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblApetizers1 = new javax.swing.JLabel();
        lblAptVeg1 = new javax.swing.JLabel();
        lblAptNonVeg1 = new javax.swing.JLabel();
        lblAptVegan1 = new javax.swing.JLabel();
        rdOnionRings1 = new javax.swing.JRadioButton();
        txtOnionRings = new javax.swing.JTextField();
        rdSpinachPie1 = new javax.swing.JRadioButton();
        txtSpinachPie = new javax.swing.JTextField();
        rdSpringRoles1 = new javax.swing.JRadioButton();
        txtSpringRoles = new javax.swing.JTextField();
        rdMeatBalls1 = new javax.swing.JRadioButton();
        txtMeatBalls = new javax.swing.JTextField();
        rdSausageDip1 = new javax.swing.JRadioButton();
        txtSausageDip = new javax.swing.JTextField();
        rdFriedShrimp1 = new javax.swing.JRadioButton();
        txtFriedShrimp = new javax.swing.JTextField();
        rdWhiteBeanDip1 = new javax.swing.JRadioButton();
        txtWhiteBeanDip = new javax.swing.JTextField();
        rdTortillaChips1 = new javax.swing.JRadioButton();
        txtTortillaChips = new javax.swing.JTextField();
        rdCrispyTofu1 = new javax.swing.JRadioButton();
        txtCrispyTofu = new javax.swing.JTextField();
        lblMains1 = new javax.swing.JLabel();
        lblMainsVeg1 = new javax.swing.JLabel();
        lblMainsNonVeg1 = new javax.swing.JLabel();
        lblAptVegan2 = new javax.swing.JLabel();
        rdCheeseBurger1 = new javax.swing.JRadioButton();
        txtCheeseBurger = new javax.swing.JTextField();
        rdFriedRice1 = new javax.swing.JRadioButton();
        txtFriedRice = new javax.swing.JTextField();
        rdVeggiePizza1 = new javax.swing.JRadioButton();
        txtVeggiePizza = new javax.swing.JTextField();
        rdHamBurger1 = new javax.swing.JRadioButton();
        rdFishNChips1 = new javax.swing.JRadioButton();
        rdPrawnFriedRice1 = new javax.swing.JRadioButton();
        txtHamBurger = new javax.swing.JTextField();
        txtFishNChips = new javax.swing.JTextField();
        txtPrawnFriedRice = new javax.swing.JTextField();
        rdTofuSalad1 = new javax.swing.JRadioButton();
        txtTofuSalad = new javax.swing.JTextField();
        rdFalafelBowl1 = new javax.swing.JRadioButton();
        txtFalafelBowl = new javax.swing.JTextField();
        rdTofuAndRiceBowl1 = new javax.swing.JRadioButton();
        txtTofuAndRiceBowl = new javax.swing.JTextField();
        lblDesserts1 = new javax.swing.JLabel();
        rdBlackForestCake1 = new javax.swing.JRadioButton();
        txtBlackForestCake = new javax.swing.JTextField();
        rdPineappleSwissRole1 = new javax.swing.JRadioButton();
        txtPineappleSwissRole = new javax.swing.JTextField();
        rdChocolateMousse1 = new javax.swing.JRadioButton();
        txtChocolateMousse = new javax.swing.JTextField();
        lbBeverages1 = new javax.swing.JLabel();
        rdCocaCola1 = new javax.swing.JRadioButton();
        txtCocaCola = new javax.swing.JTextField();
        rdFreshLimesalted1 = new javax.swing.JRadioButton();
        txtFreshLimeSalted = new javax.swing.JTextField();
        rdPepsi1 = new javax.swing.JRadioButton();
        txtPepsi = new javax.swing.JTextField();
        OrderDetails = new javax.swing.JPanel();
        lblHeader3 = new javax.swing.JLabel();
        btnBack5 = new javax.swing.JButton();
        lblOrderedBy = new javax.swing.JLabel();
        lblOrderedAt = new javax.swing.JLabel();
        lblOrderedByValue = new javax.swing.JLabel();
        lblOrderedAtValue = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFoodList = new javax.swing.JTable();
        AssignDeliveryPanel = new javax.swing.JPanel();
        lblHeader4 = new javax.swing.JLabel();
        btnBack6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDeliveryStaff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAssign = new javax.swing.JButton();
        ServiceDetails = new javax.swing.JPanel();
        lblHeader1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        btnDetails2 = new javax.swing.JButton();
        btnDetails3 = new javax.swing.JButton();
        btnDetails4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblServices = new javax.swing.JTable();
        txtInstructions = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnDetails5 = new javax.swing.JButton();
        ViewServiceDetails = new javax.swing.JPanel();
        lblStaffMemberName = new javax.swing.JLabel();
        btnBack8 = new javax.swing.JButton();
        lblProfileImageView = new javax.swing.JLabel();
        lblFullName1 = new javax.swing.JLabel();
        txtFullName1 = new javax.swing.JTextField();
        lblPhoneNumber1 = new javax.swing.JLabel();
        txtPhoneNumber1 = new javax.swing.JTextField();
        lblEmail2 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();

        NavigationJPanel.setBackground(new java.awt.Color(0, 51, 51));

        btnMenu.setBackground(new java.awt.Color(206, 217, 217));
        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(0, 51, 51));
        btnMenu.setText("MENU");
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuMouseExited(evt);
            }
        });
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnMenu2.setBackground(new java.awt.Color(206, 217, 217));
        btnMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu2.setForeground(new java.awt.Color(0, 51, 51));
        btnMenu2.setText("SERVICES");
        btnMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenu2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenu2MouseExited(evt);
            }
        });
        btnMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu2ActionPerformed(evt);
            }
        });

        btnMenu3.setBackground(new java.awt.Color(206, 217, 217));
        btnMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu3.setForeground(new java.awt.Color(0, 51, 51));
        btnMenu3.setText("ADD TIERS");
        btnMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenu3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenu3MouseExited(evt);
            }
        });
        btnMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationJPanelLayout = new javax.swing.GroupLayout(NavigationJPanel);
        NavigationJPanel.setLayout(NavigationJPanelLayout);
        NavigationJPanelLayout.setHorizontalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NavigationJPanelLayout.createSequentialGroup()
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NavigationJPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        NavigationJPanelLayout.setVerticalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationJPanelLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NavigationJPanelLayout.createSequentialGroup()
                    .addGap(321, 321, 321)
                    .addComponent(btnMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(322, Short.MAX_VALUE)))
        );

        jSplitPane1.setLeftComponent(NavigationJPanel);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        workAreaPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblRestaurantName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRestaurantName.setForeground(new java.awt.Color(0, 153, 153));
        lblRestaurantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestaurantName.setText("<restaurant name>");

        tblOrders.setBackground(new java.awt.Color(255, 255, 255));
        tblOrders.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "CUSTOMER", "BILL AMOUNT", "EVENT", "TIER"
            }
        ));
        tblOrders.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblOrders.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane3.setViewportView(tblOrders);

        btnFeedback.setBackground(new java.awt.Color(255, 255, 255));
        btnFeedback.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFeedback.setForeground(new java.awt.Color(0, 102, 102));
        btnFeedback.setText("VIEW FEEDBACK");
        btnFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFeedbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFeedbackMouseExited(evt);
            }
        });
        btnFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedbackActionPerformed(evt);
            }
        });

        pnlFeedbackTable.setBackground(new java.awt.Color(240, 255, 255));

        btnFeedback1.setBackground(new java.awt.Color(255, 255, 255));
        btnFeedback1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFeedback1.setForeground(new java.awt.Color(0, 102, 102));
        btnFeedback1.setText("ADD");
        btnFeedback1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFeedback1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFeedback1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFeedback1MouseExited(evt);
            }
        });
        btnFeedback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Enter tiers comma ( , ) seperated");

        javax.swing.GroupLayout pnlFeedbackTableLayout = new javax.swing.GroupLayout(pnlFeedbackTable);
        pnlFeedbackTable.setLayout(pnlFeedbackTableLayout);
        pnlFeedbackTableLayout.setHorizontalGroup(
            pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFeedbackTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFeedbackTableLayout.createSequentialGroup()
                        .addComponent(txtTiers, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedback1))
                    .addComponent(jLabel2))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlFeedbackTableLayout.setVerticalGroup(
            pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFeedbackTableLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeedback1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnClose.setBackground(new java.awt.Color(255, 204, 204));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(204, 0, 0));
        btnClose.setText("X");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnDetails.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails.setText("DETAILS");
        btnDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetailsMouseExited(evt);
            }
        });
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout workAreaPanelLayout = new javax.swing.GroupLayout(workAreaPanel);
        workAreaPanel.setLayout(workAreaPanelLayout);
        workAreaPanelLayout.setHorizontalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFeedback, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnClose)
                        .addComponent(pnlFeedbackTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetails)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addComponent(lblRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workAreaPanelLayout.setVerticalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblRestaurantName)
                .addGap(68, 68, 68)
                .addComponent(btnDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFeedback)
                .addGap(20, 20, 20)
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFeedbackTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jLayeredPane1.add(workAreaPanel, "card2");

        EditDetailsPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Edit Restaurant Details");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 51, 51));
        lblName.setText("NAME : ");

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 102, 102));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(0, 51, 51));
        lblAddress.setText("ADDRESS : ");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(0, 102, 102));

        lblCuisine.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCuisine.setForeground(new java.awt.Color(0, 51, 51));
        lblCuisine.setText("CUISINE : ");

        txtCuisine.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCuisine.setForeground(new java.awt.Color(0, 102, 102));

        lblVeg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblVeg.setForeground(new java.awt.Color(0, 51, 51));
        lblVeg.setText("VEG : ");

        chkVeg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkVeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVegActionPerformed(evt);
            }
        });

        lblNonVeg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNonVeg.setForeground(new java.awt.Color(0, 51, 51));
        lblNonVeg.setText("NON-VEG : ");

        chkNonVeg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkNonVeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNonVegActionPerformed(evt);
            }
        });

        lblVegan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblVegan.setForeground(new java.awt.Color(0, 51, 51));
        lblVegan.setText("VEGAN : ");

        chkVegan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkVegan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVeganActionPerformed(evt);
            }
        });

        lvlAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lvlAll.setForeground(new java.awt.Color(0, 51, 51));
        lvlAll.setText("ALL :");

        chkAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAllActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(215, 254, 211));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(72, 151, 64));
        btnSave.setText("SAVE CHANGES");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 204, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 0, 51));
        btnBack.setText("BACK");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPhoneNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhoneNum.setForeground(new java.awt.Color(0, 51, 51));
        lblPhoneNum.setText("PHONE NO. : ");

        txtPhoneNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPhoneNum.setForeground(new java.awt.Color(0, 102, 102));

        lblEmailId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmailId.setForeground(new java.awt.Color(0, 51, 51));
        lblEmailId.setText("EMAIL ID : ");

        txtEmailId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtEmailId.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout EditDetailsPanelLayout = new javax.swing.GroupLayout(EditDetailsPanel);
        EditDetailsPanel.setLayout(EditDetailsPanelLayout);
        EditDetailsPanelLayout.setHorizontalGroup(
            EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                        .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, EditDetailsPanelLayout.createSequentialGroup()
                                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblEmailId))
                                    .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblPhoneNum)
                                        .addComponent(lblName)
                                        .addComponent(lblAddress)
                                        .addComponent(lblCuisine)
                                        .addComponent(lblVeg)
                                        .addComponent(lblNonVeg)
                                        .addComponent(lblVegan)
                                        .addComponent(lvlAll)))
                                .addGap(18, 18, 18)
                                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtName)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtCuisine)
                                    .addComponent(txtPhoneNum)
                                    .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, EditDetailsPanelLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkAll, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkVegan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkNonVeg, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkVeg, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(245, 245, 245))
                    .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(24, 24, 24))))
        );
        EditDetailsPanelLayout.setVerticalGroup(
            EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblHeader))
                    .addGroup(EditDetailsPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnBack)))
                .addGap(97, 97, 97)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuisine)
                    .addComponent(txtCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNum)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailId)
                    .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVeg)
                    .addComponent(chkVeg))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNonVeg)
                    .addComponent(chkNonVeg))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVegan)
                    .addComponent(chkVegan))
                .addGap(18, 18, 18)
                .addGroup(EditDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvlAll)
                    .addComponent(chkAll))
                .addGap(31, 31, 31)
                .addComponent(btnSave)
                .addGap(76, 76, 76))
        );

        jLayeredPane1.add(EditDetailsPanel, "card3");

        MenuPanel1.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader2.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader2.setText("MENU");

        btnBack3.setBackground(new java.awt.Color(255, 204, 204));
        btnBack3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack3.setForeground(new java.awt.Color(255, 0, 51));
        btnBack3.setText("BACK");
        btnBack3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack3MouseExited(evt);
            }
        });
        btnBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack3ActionPerformed(evt);
            }
        });

        btnBack4.setBackground(new java.awt.Color(215, 254, 211));
        btnBack4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack4.setForeground(new java.awt.Color(72, 151, 64));
        btnBack4.setText("SAVE");
        btnBack4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack4MouseExited(evt);
            }
        });
        btnBack4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack4ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(240, 255, 255));

        lblApetizers1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApetizers1.setForeground(new java.awt.Color(0, 204, 204));
        lblApetizers1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApetizers1.setText("Appetizers");

        lblAptVeg1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAptVeg1.setForeground(new java.awt.Color(0, 102, 102));
        lblAptVeg1.setText("VEG");

        lblAptNonVeg1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAptNonVeg1.setForeground(new java.awt.Color(0, 102, 102));
        lblAptNonVeg1.setText("NON-VEG");

        lblAptVegan1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAptVegan1.setForeground(new java.awt.Color(0, 102, 102));
        lblAptVegan1.setText("VEGAN");

        rdOnionRings1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdOnionRings1.setForeground(new java.awt.Color(0, 0, 0));
        rdOnionRings1.setText("Onion Rings");
        rdOnionRings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdOnionRings1ActionPerformed(evt);
            }
        });

        rdSpinachPie1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdSpinachPie1.setForeground(new java.awt.Color(0, 0, 0));
        rdSpinachPie1.setText("Spinach Pie");

        rdSpringRoles1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdSpringRoles1.setForeground(new java.awt.Color(0, 0, 0));
        rdSpringRoles1.setText("Spring Roles");

        rdMeatBalls1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdMeatBalls1.setForeground(new java.awt.Color(0, 0, 0));
        rdMeatBalls1.setText("Meatballs");

        rdSausageDip1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdSausageDip1.setForeground(new java.awt.Color(0, 0, 0));
        rdSausageDip1.setText("Sausage Dip");

        rdFriedShrimp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFriedShrimp1.setForeground(new java.awt.Color(0, 0, 0));
        rdFriedShrimp1.setText("Fired Shrimp");

        rdWhiteBeanDip1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdWhiteBeanDip1.setForeground(new java.awt.Color(0, 0, 0));
        rdWhiteBeanDip1.setText("White Bean Dip");

        rdTortillaChips1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdTortillaChips1.setForeground(new java.awt.Color(0, 0, 0));
        rdTortillaChips1.setText("Tortilla Chips");

        rdCrispyTofu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdCrispyTofu1.setForeground(new java.awt.Color(0, 0, 0));
        rdCrispyTofu1.setText("Crispy Tofu");

        lblMains1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMains1.setForeground(new java.awt.Color(0, 204, 204));
        lblMains1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMains1.setText("MAINS");

        lblMainsVeg1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMainsVeg1.setForeground(new java.awt.Color(0, 102, 102));
        lblMainsVeg1.setText("VEG");

        lblMainsNonVeg1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMainsNonVeg1.setForeground(new java.awt.Color(0, 102, 102));
        lblMainsNonVeg1.setText("NON-VEG");

        lblAptVegan2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAptVegan2.setForeground(new java.awt.Color(0, 102, 102));
        lblAptVegan2.setText("VEGAN");

        rdCheeseBurger1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdCheeseBurger1.setForeground(new java.awt.Color(0, 0, 0));
        rdCheeseBurger1.setText("Cheese Burger");
        rdCheeseBurger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCheeseBurger1ActionPerformed(evt);
            }
        });

        rdFriedRice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFriedRice1.setForeground(new java.awt.Color(0, 0, 0));
        rdFriedRice1.setText("Fried Rice");

        rdVeggiePizza1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVeggiePizza1.setForeground(new java.awt.Color(0, 0, 0));
        rdVeggiePizza1.setText("Veggie Pizza");

        rdHamBurger1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdHamBurger1.setForeground(new java.awt.Color(0, 0, 0));
        rdHamBurger1.setText("Ham Burger");

        rdFishNChips1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFishNChips1.setForeground(new java.awt.Color(0, 0, 0));
        rdFishNChips1.setText("Fish N' Chips");

        rdPrawnFriedRice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdPrawnFriedRice1.setForeground(new java.awt.Color(0, 0, 0));
        rdPrawnFriedRice1.setText("Prawn Fried Rice");

        rdTofuSalad1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdTofuSalad1.setForeground(new java.awt.Color(0, 0, 0));
        rdTofuSalad1.setText("Tofu Salad");

        txtTofuSalad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTofuSaladActionPerformed(evt);
            }
        });

        rdFalafelBowl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFalafelBowl1.setForeground(new java.awt.Color(0, 0, 0));
        rdFalafelBowl1.setText("Falafel Bowl");

        rdTofuAndRiceBowl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdTofuAndRiceBowl1.setForeground(new java.awt.Color(0, 0, 0));
        rdTofuAndRiceBowl1.setText("Tofu & Rice platter");

        lblDesserts1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDesserts1.setForeground(new java.awt.Color(0, 204, 204));
        lblDesserts1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesserts1.setText("DESSERTS");

        rdBlackForestCake1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdBlackForestCake1.setForeground(new java.awt.Color(0, 0, 0));
        rdBlackForestCake1.setText("Black Forest Cake");

        rdPineappleSwissRole1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdPineappleSwissRole1.setForeground(new java.awt.Color(0, 0, 0));
        rdPineappleSwissRole1.setText("Pineapple Swiss Role");

        rdChocolateMousse1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdChocolateMousse1.setForeground(new java.awt.Color(0, 0, 0));
        rdChocolateMousse1.setText("Chocolate Mousse with Whipped Cream");

        lbBeverages1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBeverages1.setForeground(new java.awt.Color(0, 204, 204));
        lbBeverages1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBeverages1.setText("BEVERAGES");

        rdCocaCola1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdCocaCola1.setForeground(new java.awt.Color(0, 0, 0));
        rdCocaCola1.setText("CocaCola");

        rdFreshLimesalted1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFreshLimesalted1.setForeground(new java.awt.Color(0, 0, 0));
        rdFreshLimesalted1.setText("Fresh Lime Salted");

        rdPepsi1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdPepsi1.setForeground(new java.awt.Color(0, 0, 0));
        rdPepsi1.setText("Pepsi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(lblAptVeg1)
                .addGap(188, 188, 188)
                .addComponent(lblAptNonVeg1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAptVegan1)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(lblApetizers1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdOnionRings1)
                                    .addComponent(rdSpinachPie1)
                                    .addComponent(rdSpringRoles1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOnionRings, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSpinachPie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSpringRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdSausageDip1)
                                                    .addComponent(rdMeatBalls1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtSausageDip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMeatBalls, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblMains1)
                                                    .addComponent(rdFriedShrimp1))
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFriedShrimp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(65, 65, 65)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdWhiteBeanDip1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtWhiteBeanDip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdTortillaChips1)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblAptVegan2)
                                                        .addComponent(rdCrispyTofu1)))
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCrispyTofu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTortillaChips, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdTofuAndRiceBowl1)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(rdTofuSalad1)
                                                            .addComponent(rdFalafelBowl1))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtFalafelBowl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTofuAndRiceBowl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTofuSalad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdPrawnFriedRice1)
                                            .addComponent(rdHamBurger1)
                                            .addComponent(rdFishNChips1))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(txtPrawnFriedRice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHamBurger, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFishNChips, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdCheeseBurger1)
                                    .addComponent(rdFriedRice1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFriedRice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCheeseBurger, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdVeggiePizza1)
                                .addGap(18, 18, 18)
                                .addComponent(txtVeggiePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDesserts1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rdBlackForestCake1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtBlackForestCake, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rdPineappleSwissRole1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPineappleSwissRole, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rdChocolateMousse1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtChocolateMousse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rdPepsi1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPepsi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rdCocaCola1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCocaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rdFreshLimesalted1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtFreshLimeSalted, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbBeverages1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblMainsVeg1)
                        .addGap(189, 189, 189)
                        .addComponent(lblMainsNonVeg1)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblApetizers1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAptVeg1)
                    .addComponent(lblAptNonVeg1)
                    .addComponent(lblAptVegan1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdOnionRings1)
                            .addComponent(txtOnionRings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdSpinachPie1)
                            .addComponent(txtSpinachPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdSpringRoles1)
                            .addComponent(txtSpringRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdMeatBalls1)
                            .addComponent(txtMeatBalls, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSausageDip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdSausageDip1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFriedShrimp1)
                            .addComponent(txtFriedShrimp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdWhiteBeanDip1)
                            .addComponent(txtWhiteBeanDip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdTortillaChips1)
                            .addComponent(txtTortillaChips, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdCrispyTofu1)
                            .addComponent(txtCrispyTofu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addComponent(lblMains1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMainsVeg1)
                    .addComponent(lblMainsNonVeg1)
                    .addComponent(lblAptVegan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdCheeseBurger1)
                            .addComponent(txtCheeseBurger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFriedRice1)
                            .addComponent(txtFriedRice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdVeggiePizza1)
                            .addComponent(txtVeggiePizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdHamBurger1)
                            .addComponent(txtHamBurger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFishNChips1)
                            .addComponent(txtFishNChips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdPrawnFriedRice1)
                            .addComponent(txtPrawnFriedRice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdTofuSalad1)
                            .addComponent(txtTofuSalad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFalafelBowl1)
                            .addComponent(txtFalafelBowl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdTofuAndRiceBowl1)
                            .addComponent(txtTofuAndRiceBowl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDesserts1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBlackForestCake, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdBlackForestCake1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPineappleSwissRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdPineappleSwissRole1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdChocolateMousse1)
                            .addComponent(txtChocolateMousse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbBeverages1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdCocaCola1)
                            .addComponent(txtCocaCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFreshLimesalted1)
                            .addComponent(txtFreshLimeSalted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdPepsi1)
                            .addComponent(txtPepsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout MenuPanel1Layout = new javax.swing.GroupLayout(MenuPanel1);
        MenuPanel1.setLayout(MenuPanel1Layout);
        MenuPanel1Layout.setHorizontalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack3)
                    .addComponent(btnBack4))
                .addGap(39, 39, 39))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        MenuPanel1Layout.setVerticalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack3)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack4))
                    .addGroup(MenuPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblHeader2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );

        jLayeredPane1.add(MenuPanel1, "card5");

        OrderDetails.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader3.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader3.setText("<ORDER xyz details>");

        btnBack5.setBackground(new java.awt.Color(255, 204, 204));
        btnBack5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack5.setForeground(new java.awt.Color(255, 0, 51));
        btnBack5.setText("BACK");
        btnBack5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack5MouseExited(evt);
            }
        });
        btnBack5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack5ActionPerformed(evt);
            }
        });

        lblOrderedBy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrderedBy.setForeground(new java.awt.Color(0, 51, 51));
        lblOrderedBy.setText("ORDERED BY : ");

        lblOrderedAt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrderedAt.setForeground(new java.awt.Color(0, 51, 51));
        lblOrderedAt.setText("ORDERED AT :");

        lblOrderedByValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrderedByValue.setForeground(new java.awt.Color(0, 153, 51));
        lblOrderedByValue.setText("<Customer Name>");

        lblOrderedAtValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrderedAtValue.setForeground(new java.awt.Color(0, 153, 51));
        lblOrderedAtValue.setText("<OrderTime>");

        tblFoodList.setBackground(new java.awt.Color(255, 255, 255));
        tblFoodList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblFoodList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "FOOD ITEMS"
            }
        ));
        tblFoodList.setSelectionBackground(new java.awt.Color(153, 209, 232));
        tblFoodList.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane5.setViewportView(tblFoodList);

        javax.swing.GroupLayout OrderDetailsLayout = new javax.swing.GroupLayout(OrderDetails);
        OrderDetails.setLayout(OrderDetailsLayout);
        OrderDetailsLayout.setHorizontalGroup(
            OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderDetailsLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(OrderDetailsLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderDetailsLayout.createSequentialGroup()
                        .addGroup(OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrderedBy)
                            .addComponent(lblOrderedAt))
                        .addGap(18, 18, 18)
                        .addGroup(OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrderedAtValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOrderedByValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(OrderDetailsLayout.createSequentialGroup()
                        .addComponent(lblHeader3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(btnBack5)))
                .addGap(34, 34, 34))
        );
        OrderDetailsLayout.setVerticalGroup(
            OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderDetailsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack5)
                    .addComponent(lblHeader3))
                .addGap(83, 83, 83)
                .addGroup(OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderedBy)
                    .addComponent(lblOrderedByValue))
                .addGap(37, 37, 37)
                .addGroup(OrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderedAtValue)
                    .addComponent(lblOrderedAt))
                .addGap(102, 102, 102)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jLayeredPane1.add(OrderDetails, "card5");

        AssignDeliveryPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader4.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader4.setText("<ORDER xyz delivery>");

        btnBack6.setBackground(new java.awt.Color(255, 204, 204));
        btnBack6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack6.setForeground(new java.awt.Color(255, 0, 51));
        btnBack6.setText("BACK");
        btnBack6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack6MouseExited(evt);
            }
        });
        btnBack6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack6ActionPerformed(evt);
            }
        });

        tblDeliveryStaff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblDeliveryStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Delivery Staff Member"
            }
        ));
        tblDeliveryStaff.setSelectionBackground(new java.awt.Color(153, 209, 232));
        tblDeliveryStaff.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane6.setViewportView(tblDeliveryStaff);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("ASSIGN ORDER TO A DELIVERY STAFF MEMBER BELOW");

        btnAssign.setBackground(new java.awt.Color(215, 254, 211));
        btnAssign.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAssign.setForeground(new java.awt.Color(72, 151, 64));
        btnAssign.setText("ASSIGN");
        btnAssign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAssign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAssignMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAssignMouseExited(evt);
            }
        });
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AssignDeliveryPanelLayout = new javax.swing.GroupLayout(AssignDeliveryPanel);
        AssignDeliveryPanel.setLayout(AssignDeliveryPanelLayout);
        AssignDeliveryPanelLayout.setHorizontalGroup(
            AssignDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignDeliveryPanelLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(lblHeader4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnBack6)
                .addGap(40, 40, 40))
            .addGroup(AssignDeliveryPanelLayout.createSequentialGroup()
                .addGroup(AssignDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AssignDeliveryPanelLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1))
                    .addGroup(AssignDeliveryPanelLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(AssignDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAssign, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AssignDeliveryPanelLayout.setVerticalGroup(
            AssignDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignDeliveryPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(AssignDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack6)
                    .addComponent(lblHeader4))
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnAssign)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jLayeredPane1.add(AssignDeliveryPanel, "card6");

        ServiceDetails.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader1.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader1.setText("Services");

        btnBack1.setBackground(new java.awt.Color(255, 204, 204));
        btnBack1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 0, 51));
        btnBack1.setText("BACK");
        btnBack1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack1MouseExited(evt);
            }
        });
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        btnDetails2.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails2.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails2.setText("VIEW SERVICE PERSONEL");
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

        btnDetails3.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails3.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails3.setText("Hire");
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

        btnDetails4.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails4.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails4.setText("Release");
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

        tblServices.setBackground(new java.awt.Color(255, 255, 255));
        tblServices.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STAFF MEMBER", "SERVICE TYPE", "SUB-TYPE", "SERVICE MANAGER", "STATUS"
            }
        ));
        tblServices.setSelectionBackground(new java.awt.Color(153, 209, 232));
        tblServices.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane7.setViewportView(tblServices);

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

        btnDetails5.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails5.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails5.setText("Add Instructions");
        btnDetails5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetails5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetails5MouseExited(evt);
            }
        });
        btnDetails5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ServiceDetailsLayout = new javax.swing.GroupLayout(ServiceDetails);
        ServiceDetails.setLayout(ServiceDetailsLayout);
        ServiceDetailsLayout.setHorizontalGroup(
            ServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack1)
                .addGap(50, 50, 50))
            .addGroup(ServiceDetailsLayout.createSequentialGroup()
                .addGroup(ServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ServiceDetailsLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(lblHeader1))
                    .addGroup(ServiceDetailsLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(ServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit)
                            .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ServiceDetailsLayout.createSequentialGroup()
                                    .addComponent(btnDetails2)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDetails3)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDetails5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDetails4))
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        ServiceDetailsLayout.setVerticalGroup(
            ServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceDetailsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnBack1)
                .addGap(3, 3, 3)
                .addComponent(lblHeader1)
                .addGap(42, 42, 42)
                .addGroup(ServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails2)
                    .addComponent(btnDetails3)
                    .addComponent(btnDetails4)
                    .addComponent(btnDetails5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jLayeredPane1.add(ServiceDetails, "card7");

        ViewServiceDetails.setBackground(new java.awt.Color(240, 255, 255));

        lblStaffMemberName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStaffMemberName.setForeground(new java.awt.Color(0, 153, 153));
        lblStaffMemberName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStaffMemberName.setText("<<Staff Member Name>>");

        btnBack8.setBackground(new java.awt.Color(255, 204, 204));
        btnBack8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack8.setForeground(new java.awt.Color(255, 0, 51));
        btnBack8.setText("BACK");
        btnBack8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack8MouseExited(evt);
            }
        });
        btnBack8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack8ActionPerformed(evt);
            }
        });

        lblProfileImageView.setBackground(new java.awt.Color(204, 204, 204));
        lblProfileImageView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProfileImageView.setForeground(new java.awt.Color(0, 0, 0));
        lblProfileImageView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfileImageView.setText("Profile Image");
        lblProfileImageView.setOpaque(true);

        lblFullName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFullName1.setText("FULL NAME :");

        txtFullName1.setEditable(false);

        lblPhoneNumber1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhoneNumber1.setText("PHONE NUMBER : ");

        txtPhoneNumber1.setEditable(false);

        lblEmail2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail2.setText("EMAIL : ");

        txtEmail1.setEditable(false);

        javax.swing.GroupLayout ViewServiceDetailsLayout = new javax.swing.GroupLayout(ViewServiceDetails);
        ViewServiceDetails.setLayout(ViewServiceDetailsLayout);
        ViewServiceDetailsLayout.setHorizontalGroup(
            ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewServiceDetailsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ViewServiceDetailsLayout.createSequentialGroup()
                            .addComponent(lblStaffMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewServiceDetailsLayout.createSequentialGroup()
                            .addGap(600, 600, 600)
                            .addComponent(btnBack8)))
                    .addGroup(ViewServiceDetailsLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFullName1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhoneNumber1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProfileImageView, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber1)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        ViewServiceDetailsLayout.setVerticalGroup(
            ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewServiceDetailsLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnBack8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStaffMemberName)
                .addGap(57, 57, 57)
                .addComponent(lblProfileImageView, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFullName1)
                    .addComponent(txtFullName1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoneNumber1)
                    .addGroup(ViewServiceDetailsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtPhoneNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewServiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        jLayeredPane1.add(ViewServiceDetails, "card8");

        jSplitPane1.setRightComponent(jLayeredPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFeedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackMouseEntered
    }//GEN-LAST:event_btnFeedbackMouseEntered

    private void btnFeedbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedbackMouseExited
    }//GEN-LAST:event_btnFeedbackMouseExited

    private void btnFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackActionPerformed

    }//GEN-LAST:event_btnFeedbackActionPerformed

    private void btnDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailsMouseEntered

    }//GEN-LAST:event_btnDetailsMouseEntered

    private void btnDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailsMouseExited
    }//GEN-LAST:event_btnDetailsMouseExited

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        int selectedRowIndex = tblOrders.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Order");
            return;
        } else {
            switchPanels(OrderDetails);
            DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
            Ticket selectedTicket = (Ticket) model.getValueAt(selectedRowIndex, 0);
            lblHeader3.setText("Ticket " + selectedTicket.getId() + "order details");
            lblOrderedByValue.setText(selectedTicket.getCustomerName());
            lblOrderedAtValue.setText(String.valueOf(selectedTicket.getEventName()));
            popuateFoodItemList(selectedTicket.getId());
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void chkVegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVegActionPerformed

    }//GEN-LAST:event_chkVegActionPerformed

    private void chkNonVegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNonVegActionPerformed

    }//GEN-LAST:event_chkNonVegActionPerformed

    private void chkVeganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVeganActionPerformed

    }//GEN-LAST:event_chkVeganActionPerformed

    private void chkAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAllActionPerformed

    }//GEN-LAST:event_chkAllActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered

    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited

    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered

    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited

    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack3MouseEntered

    }//GEN-LAST:event_btnBack3MouseEntered

    private void btnBack3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack3MouseExited

    }//GEN-LAST:event_btnBack3MouseExited

    private void btnBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack3ActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBack3ActionPerformed

    private void btnBack4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack4MouseEntered

    }//GEN-LAST:event_btnBack4MouseEntered

    private void btnBack4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack4MouseExited

    }//GEN-LAST:event_btnBack4MouseExited

    /**
     * set appetizer map
     *
     * @return
     */
    private HashMap<String, Integer> setApetizers() {
        HashMap<String, Integer> apetizers = new HashMap<>();
        boolean valid = true;
        if (rdOnionRings1.isSelected() && txtOnionRings.getText() != null && !txtOnionRings.getText().isBlank() && !txtOnionRings.getText().isEmpty()) {
            apetizers.put("Onion Rings", Integer.parseInt(txtOnionRings.getText()));
        }

        if (rdSpinachPie1.isSelected() && txtSpinachPie.getText() != null && !txtSpinachPie.getText().isBlank() && !txtSpinachPie.getText().isEmpty()) {
            apetizers.put("Spinach Pie", Integer.parseInt(txtSpinachPie.getText()));
        }

        if (rdSpringRoles1.isSelected() && txtSpringRoles.getText() != null && !txtSpringRoles.getText().isBlank() && !txtSpringRoles.getText().isEmpty()) {
            apetizers.put("Spring Roles", Integer.parseInt(txtSpringRoles.getText()));
        }

        if (rdMeatBalls1.isSelected() && txtMeatBalls.getText() != null && !txtMeatBalls.getText().isBlank() && !txtMeatBalls.getText().isEmpty()) {
            apetizers.put("Meat Balls", Integer.parseInt(txtMeatBalls.getText()));
        }

        if (rdSausageDip1.isSelected() && txtSausageDip.getText() != null && !txtSausageDip.getText().isBlank() && !txtSausageDip.getText().isEmpty()) {
            apetizers.put("Sausage Dip", Integer.parseInt(txtSausageDip.getText()));
        }

        if (rdFriedShrimp1.isSelected() && txtFriedShrimp.getText() != null && !txtFriedShrimp.getText().isBlank() && !txtFriedShrimp.getText().isEmpty()) {
            apetizers.put("Fried Shrimp", Integer.parseInt(txtFriedShrimp.getText()));
        }

        if (rdWhiteBeanDip1.isSelected() && txtWhiteBeanDip.getText() != null && !txtWhiteBeanDip.getText().isBlank() && !txtWhiteBeanDip.getText().isEmpty()) {
            apetizers.put("White Bean Dip", Integer.parseInt(txtWhiteBeanDip.getText()));
        }

        if (rdTortillaChips1.isSelected() && txtTortillaChips.getText() != null && !txtTortillaChips.getText().isBlank() && !txtTortillaChips.getText().isEmpty()) {
            apetizers.put("Tortilla Chips", Integer.parseInt(txtTortillaChips.getText()));
        }

        if (rdCrispyTofu1.isSelected() && txtCrispyTofu.getText() != null && !txtCrispyTofu.getText().isBlank() && !txtCrispyTofu.getText().isEmpty()) {
            apetizers.put("Crispy Tofu", Integer.parseInt(txtCrispyTofu.getText()));
        }
        return apetizers;
    }

    /**
     * set mains map
     *
     * @return
     */
    private HashMap<String, Integer> setMains() {
        HashMap<String, Integer> mains = new HashMap<>();
        if (rdCheeseBurger1.isSelected() && txtCheeseBurger.getText() != null && !txtCheeseBurger.getText().isBlank() && !txtCheeseBurger.getText().isEmpty()) {
            mains.put("Cheese Burger", Integer.parseInt(txtCheeseBurger.getText()));
        }

        if (rdFriedRice1.isSelected() && txtFriedRice.getText() != null && !txtFriedRice.getText().isBlank() && !txtFriedRice.getText().isEmpty()) {
            mains.put("Fried Rice", Integer.parseInt(txtFriedRice.getText()));
        }

        if (rdVeggiePizza1.isSelected() && txtVeggiePizza.getText() != null && !txtVeggiePizza.getText().isBlank() && !txtVeggiePizza.getText().isEmpty()) {
            mains.put("Veggie Pizza", Integer.parseInt(txtVeggiePizza.getText()));
        }

        if (rdHamBurger1.isSelected() && txtHamBurger.getText() != null && !txtHamBurger.getText().isBlank() && !txtHamBurger.getText().isEmpty()) {
            mains.put("Ham Burger", Integer.parseInt(txtHamBurger.getText()));
        }

        if (rdFishNChips1.isSelected() && txtFishNChips.getText() != null && !txtFishNChips.getText().isBlank() && !txtFishNChips.getText().isEmpty()) {
            mains.put("Fish N' Chips", Integer.parseInt(txtFishNChips.getText()));
        }

        if (rdPrawnFriedRice1.isSelected() && txtPrawnFriedRice.getText() != null && !txtPrawnFriedRice.getText().isBlank() && !txtPrawnFriedRice.getText().isEmpty()) {
            mains.put("Prawn Fried Rice", Integer.parseInt(txtPrawnFriedRice.getText()));
        }

        if (rdTofuSalad1.isSelected() && txtTofuSalad.getText() != null && !txtTofuSalad.getText().isBlank() && !txtTofuSalad.getText().isEmpty()) {
            mains.put("Tofu Salad", Integer.parseInt(txtTofuSalad.getText()));
        }

        if (rdFalafelBowl1.isSelected() && txtFalafelBowl.getText() != null && !txtFalafelBowl.getText().isBlank() && !txtFalafelBowl.getText().isEmpty()) {
            mains.put("Falafel Bowl", Integer.parseInt(txtFalafelBowl.getText()));
        }

        if (rdTofuAndRiceBowl1.isSelected() && txtTofuAndRiceBowl.getText() != null && !txtTofuAndRiceBowl.getText().isBlank() && !txtTofuAndRiceBowl.getText().isEmpty()) {
            mains.put("Tofu & Rice Platter", Integer.parseInt(txtTofuAndRiceBowl.getText()));
        }
        return mains;
    }

    /**
     * sets desserts map
     *
     * @return
     */
    private HashMap<String, Integer> setDessert() {
        HashMap<String, Integer> desserts = new HashMap<>();
        if (rdBlackForestCake1.isSelected() && txtBlackForestCake.getText() != null && !txtBlackForestCake.getText().isBlank() && !txtBlackForestCake.getText().isEmpty()) {
            desserts.put("Black Forest Cake", Integer.parseInt(txtBlackForestCake.getText()));
        }

        if (rdPineappleSwissRole1.isSelected() && txtPineappleSwissRole.getText() != null && !txtPineappleSwissRole.getText().isBlank() && !txtPineappleSwissRole.getText().isEmpty()) {
            desserts.put("Pineapple Swiss Role", Integer.parseInt(txtPineappleSwissRole.getText()));
        }

        if (rdChocolateMousse1.isSelected() && txtChocolateMousse.getText() != null && !txtChocolateMousse.getText().isBlank() && !txtChocolateMousse.getText().isEmpty()) {
            desserts.put("Chocolate Mousse", Integer.parseInt(txtChocolateMousse.getText()));
        }

        return desserts;
    }

    /**
     * set beverages map
     *
     * @return
     */
    private HashMap<String, Integer> setBeverages() {
        HashMap<String, Integer> beverages = new HashMap<>();
        if (rdCocaCola1.isSelected() && txtCocaCola.getText() != null && !txtCocaCola.getText().isBlank() && !txtCocaCola.getText().isEmpty()) {
            beverages.put("CocaCola", Integer.parseInt(txtCocaCola.getText()));
        }

        if (rdFreshLimesalted1.isSelected() && txtFreshLimeSalted.getText() != null && !txtFreshLimeSalted.getText().isBlank() && !txtFreshLimeSalted.getText().isEmpty()) {
            beverages.put("Fresh Lime Salted", Integer.parseInt(txtFreshLimeSalted.getText()));
        }

        if (rdPepsi1.isSelected() && txtPepsi.getText() != null && !txtPepsi.getText().isBlank() && !txtPepsi.getText().isEmpty()) {
            beverages.put("Pepsi", Integer.parseInt(txtPepsi.getText()));
        }

        return beverages;
    }

    private boolean validateAppetizers() {
        boolean valid = true;

        if (rdOnionRings1.isSelected() && (txtOnionRings.getText() == null || txtOnionRings.getText().isBlank() || txtOnionRings.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Onion Rings");
            valid = false;
        } else if (rdSpinachPie1.isSelected() && (txtSpinachPie.getText() != null && txtSpinachPie.getText().isBlank() && txtSpinachPie.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Spinach Pie");
            valid = false;
        } else if (rdSpringRoles1.isSelected() && (txtSpringRoles.getText() != null && txtSpringRoles.getText().isBlank() && txtSpringRoles.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Spring Roles");
            valid = false;
        } else if (rdMeatBalls1.isSelected() && (txtMeatBalls.getText() != null && txtMeatBalls.getText().isBlank() && txtMeatBalls.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Meat Balls");
            valid = false;
        } else if (rdSausageDip1.isSelected() && (txtSausageDip.getText() != null && txtSausageDip.getText().isBlank() && txtSausageDip.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Sausage Dip");
            valid = false;
        } else if (rdFriedShrimp1.isSelected() && (txtFriedShrimp.getText() != null && txtFriedShrimp.getText().isBlank() && txtFriedShrimp.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Fried Shrimp");
            valid = false;
        } else if (rdWhiteBeanDip1.isSelected() && (txtWhiteBeanDip.getText() != null && txtWhiteBeanDip.getText().isBlank() && txtWhiteBeanDip.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the White Bean Dip");
            valid = false;
        } else if (rdTortillaChips1.isSelected() && (txtTortillaChips.getText() != null && txtTortillaChips.getText().isBlank() && txtTortillaChips.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Tortilla Chips");
            valid = false;
        } else if (rdCrispyTofu1.isSelected() && (txtCrispyTofu.getText() != null && txtCrispyTofu.getText().isBlank() && txtCrispyTofu.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Crispy Tofu");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    private boolean validateMains() {
        boolean valid = true;

        if (rdCheeseBurger1.isSelected() && (txtCheeseBurger.getText() == null || txtCheeseBurger.getText().isBlank() || txtCheeseBurger.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Cheese Burger");
            valid = false;
        } else if (rdFriedRice1.isSelected() && (txtFriedRice.getText() != null && txtFriedRice.getText().isBlank() && txtFriedRice.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Fried Rice");
            valid = false;
        } else if (rdVeggiePizza1.isSelected() && (txtVeggiePizza.getText() != null && txtVeggiePizza.getText().isBlank() && txtVeggiePizza.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Veggie Pizza");
            valid = false;
        } else if (rdHamBurger1.isSelected() && (txtHamBurger.getText() != null && txtHamBurger.getText().isBlank() && txtHamBurger.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Ham Burger");
            valid = false;
        } else if (rdFishNChips1.isSelected() && (txtFishNChips.getText() != null && txtFishNChips.getText().isBlank() && txtFishNChips.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Fish N' Chips");
            valid = false;
        } else if (rdPrawnFriedRice1.isSelected() && (txtPrawnFriedRice.getText() != null && txtPrawnFriedRice.getText().isBlank() && txtPrawnFriedRice.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Prawn Fried Rice");
            valid = false;
        } else if (rdTofuSalad1.isSelected() && (txtTofuSalad.getText() != null && txtTofuSalad.getText().isBlank() && txtTofuSalad.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Tofu Salad");
            valid = false;
        } else if (rdFalafelBowl1.isSelected() && (txtFalafelBowl.getText() != null && txtFalafelBowl.getText().isBlank() && txtFalafelBowl.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Falafel Bowl");
            valid = false;
        } else if (rdTofuAndRiceBowl1.isSelected() && (txtTofuAndRiceBowl.getText() != null && txtTofuAndRiceBowl.getText().isBlank() && txtTofuAndRiceBowl.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Tofu & Rice Platter");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    private boolean validateDesserts() {
        boolean valid = true;

        if (rdBlackForestCake1.isSelected() && (txtBlackForestCake.getText() == null || txtBlackForestCake.getText().isBlank() || txtBlackForestCake.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Black Forest Cake");
            valid = false;
        } else if (rdPineappleSwissRole1.isSelected() && (txtPineappleSwissRole.getText() != null && txtPineappleSwissRole.getText().isBlank() && txtPineappleSwissRole.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Pineapple Swiss Role");
            valid = false;
        } else if (rdChocolateMousse1.isSelected() && (txtChocolateMousse.getText() != null && txtChocolateMousse.getText().isBlank() && txtChocolateMousse.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Chocolate Mousse");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    private boolean validateBeverages() {
        boolean valid = true;

        if (rdCocaCola1.isSelected() && (txtCocaCola.getText() == null || txtCocaCola.getText().isBlank() || txtCocaCola.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the CocaCola");
            valid = false;
        } else if (rdFreshLimesalted1.isSelected() && (txtFreshLimeSalted.getText() != null && txtFreshLimeSalted.getText().isBlank() && txtFreshLimeSalted.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Fresh Lime Salted");
            valid = false;
        } else if (rdPepsi1.isSelected() && (txtPepsi.getText() != null && txtPepsi.getText().isBlank() && txtPepsi.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Enter a price for the Pepsi");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    private void btnBack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack4ActionPerformed
        HashMap<String, Integer> apetizers = setApetizers();
        HashMap<String, Integer> mains = setMains();
        HashMap<String, Integer> desserts = setDessert();
        HashMap<String, Integer> beverages = setBeverages();

        if (validateAppetizers() && validateMains() && validateDesserts() && validateBeverages()) {
            Menu menu = new Menu();
            menu.setApetizers(apetizers);
            menu.setMains(mains);
            menu.setDessert(desserts);
            menu.setBeverages(beverages);
            premium.setMenu(menu);
            JOptionPane.showMessageDialog(null, "Menu saved successfully.");
            switchPanels(workAreaPanel);
        }
    }//GEN-LAST:event_btnBack4ActionPerformed

    private void rdOnionRings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdOnionRings1ActionPerformed

    }//GEN-LAST:event_rdOnionRings1ActionPerformed

    private void rdCheeseBurger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCheeseBurger1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdCheeseBurger1ActionPerformed

    private void txtTofuSaladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTofuSaladActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTofuSaladActionPerformed

    private void btnBack5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack5MouseEntered

    }//GEN-LAST:event_btnBack5MouseEntered

    private void btnBack5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack5MouseExited

    }//GEN-LAST:event_btnBack5MouseExited

    private void btnBack5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack5ActionPerformed
    }//GEN-LAST:event_btnBack5ActionPerformed

    private void btnBack6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack6MouseEntered

    }//GEN-LAST:event_btnBack6MouseEntered

    private void btnBack6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack6MouseExited

    }//GEN-LAST:event_btnBack6MouseExited

    private void btnBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack6ActionPerformed
    }//GEN-LAST:event_btnBack6ActionPerformed

    private void btnAssignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAssignMouseEntered

    }//GEN-LAST:event_btnAssignMouseEntered

    private void btnAssignMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAssignMouseExited

    }//GEN-LAST:event_btnAssignMouseExited

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed

    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        switchPanels(MenuPanel1);
        populateMenuFields();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseExited

    }//GEN-LAST:event_btnMenuMouseExited

    private void btnMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseEntered

    }//GEN-LAST:event_btnMenuMouseEntered

    private void btnMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu2MouseEntered

    private void btnMenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu2MouseExited

    private void btnMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu2ActionPerformed
        switchPanels(ServiceDetails);
        populateStaff();
    }//GEN-LAST:event_btnMenu2ActionPerformed

    private void btnBack1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1MouseEntered

    private void btnBack1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1MouseExited

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnDetails2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails2MouseEntered

    }//GEN-LAST:event_btnDetails2MouseEntered

    private void btnDetails2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails2MouseExited

    }//GEN-LAST:event_btnDetails2MouseExited

    private void btnDetails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails2ActionPerformed
        int selectedRowIndex = tblServices.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Staff member");
            return;
        } else {
            switchPanels(ViewServiceDetails);
            DefaultTableModel model = (DefaultTableModel) tblServices.getModel();
            Staff selectedStaff = (Staff) model.getValueAt(selectedRowIndex, 0);
            lblStaffMemberName.setText(selectedStaff.getFullName());
            txtFullName1.setText(selectedStaff.getFullName());
            txtPhoneNumber1.setText(selectedStaff.getPhoneNumber());
            txtEmail1.setText(selectedStaff.getEmail());

            ImageIcon image = new ImageIcon(selectedStaff.getProfileImagePath());
            Image resizedImage = image.getImage().getScaledInstance(149, 151, Image.SCALE_SMOOTH);
            lblProfileImageView.setIcon(new ImageIcon(resizedImage));
        }
    }//GEN-LAST:event_btnDetails2ActionPerformed

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
            selectedStaff.setStatus("HIRED");
            populateStaff();
        }
    }//GEN-LAST:event_btnDetails3ActionPerformed

    private void btnDetails4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails4MouseEntered

    private void btnDetails4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails4MouseExited

    private void btnDetails4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails4ActionPerformed
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
    }//GEN-LAST:event_btnDetails4ActionPerformed

    private void btnBack8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack8MouseEntered

    private void btnBack8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack8MouseExited

    private void btnBack8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack8ActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBack8ActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        btnClose.setVisible(false);
        pnlFeedbackTable.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited

    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered

    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnFeedback1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedback1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedback1MouseEntered

    private void btnFeedback1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeedback1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedback1MouseExited

    private void btnFeedback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback1ActionPerformed
        List<String> tierList = new ArrayList<>();
        tierList = Stream.of(txtTiers.getText().split(",", -1)).collect(Collectors.toList());
        premium.setTiers(tierList);
    }//GEN-LAST:event_btnFeedback1ActionPerformed

    private void btnMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu3MouseEntered

    private void btnMenu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu3MouseExited

    private void btnMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu3ActionPerformed
        pnlFeedbackTable.setVisible(true);
        btnClose.setVisible(true);
    }//GEN-LAST:event_btnMenu3ActionPerformed

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

    private void btnDetails5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails5MouseEntered

    private void btnDetails5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetails5MouseExited

    private void btnDetails5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails5ActionPerformed
        txtInstructions.setVisible(true);
        btnSubmit.setVisible(true);
    }//GEN-LAST:event_btnDetails5ActionPerformed

    private void switchPanels(Component component) {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(component);
        jLayeredPane1.revalidate();
        jLayeredPane1.repaint();
    }

    /**
     * @param appetizerMap1
     */
    private void populateAppetizerFields(HashMap<String, Integer> appetizerMap1) {
        for (Map.Entry<String, Integer> appetizerMap : appetizerMap1.entrySet()) {
            if (appetizerMap.getKey().equals("Onion Rings")) {
                rdOnionRings1.setSelected(true);
                txtOnionRings.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Spinach Pie")) {
                rdSpinachPie1.setSelected(true);
                txtSpinachPie.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Spring Roles")) {
                rdSpringRoles1.setSelected(true);
                txtSpringRoles.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Meat Balls")) {
                rdMeatBalls1.setSelected(true);
                txtMeatBalls.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Sausage Dip")) {
                rdSausageDip1.setSelected(true);
                txtSausageDip.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Fried Shrimp")) {
                rdFriedShrimp1.setSelected(true);
                txtFriedShrimp.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("White Bean Dip")) {
                rdWhiteBeanDip1.setSelected(true);
                txtWhiteBeanDip.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Tortilla Chips")) {
                rdTortillaChips1.setSelected(true);
                txtTortillaChips.setText(String.valueOf(appetizerMap.getValue()));
            }

            if (appetizerMap.getKey().equals("Crispy Tofu")) {
                rdCrispyTofu1.setSelected(true);
                txtCrispyTofu.setText(String.valueOf(appetizerMap.getValue()));
            }
        }
    }

    /**
     * @param mainsMap1
     */
    private void populateMainsFields(HashMap<String, Integer> mainsMap1) {
        for (Map.Entry<String, Integer> mainsMap : mainsMap1.entrySet()) {
            if (mainsMap.getKey().equals("Cheese Burger")) {
                rdCheeseBurger1.setSelected(true);
                txtCheeseBurger.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Fried Rice")) {
                rdFriedRice1.setSelected(true);
                txtFriedRice.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Veggie Pizza")) {
                rdVeggiePizza1.setSelected(true);
                txtVeggiePizza.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Ham Burger")) {
                rdHamBurger1.setSelected(true);
                txtHamBurger.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Fish N' Chips")) {
                rdFishNChips1.setSelected(true);
                txtFishNChips.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Prawn Fried Rice")) {
                rdPrawnFriedRice1.setSelected(true);
                txtPrawnFriedRice.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Tofu Salad")) {
                rdTofuSalad1.setSelected(true);
                txtTofuSalad.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Falafel Bowl")) {
                rdFalafelBowl1.setSelected(true);
                txtFalafelBowl.setText(String.valueOf(mainsMap.getValue()));
            }

            if (mainsMap.getKey().equals("Tofu & Rice Platter")) {
                rdTofuAndRiceBowl1.setSelected(true);
                txtTofuAndRiceBowl.setText(String.valueOf(mainsMap.getValue()));
            }
        }
    }

    /**
     * @param dessertsMap1
     */
    private void populateDessertsFields(HashMap<String, Integer> dessertsMap1) {
        for (Map.Entry<String, Integer> dessertsMap : dessertsMap1.entrySet()) {
            if (dessertsMap.getKey().equals("Black Forest Cake")) {
                rdBlackForestCake1.setSelected(true);
                txtBlackForestCake.setText(String.valueOf(dessertsMap.getValue()));
            }

            if (dessertsMap.getKey().equals("Pineapple Swiss Role")) {
                rdPineappleSwissRole1.setSelected(true);
                txtPineappleSwissRole.setText(String.valueOf(dessertsMap.getValue()));
            }

            if (dessertsMap.getKey().equals("Chocolate Mousse")) {
                rdChocolateMousse1.setSelected(true);
                txtChocolateMousse.setText(String.valueOf(dessertsMap.getValue()));
            }
        }
    }

    /**
     * @param beveragesMap1
     */
    private void populateBeveragesFields(HashMap<String, Integer> beveragesMap1) {
        for (Map.Entry<String, Integer> beveragesMap : beveragesMap1.entrySet()) {
            if (beveragesMap.getKey().equals("CocaCola")) {
                rdCocaCola1.setSelected(true);
                txtCocaCola.setText(String.valueOf(beveragesMap.getValue()));
            }

            if (beveragesMap.getKey().equals("Fresh Lime Salted")) {
                rdFreshLimesalted1.setSelected(true);
                txtFreshLimeSalted.setText(String.valueOf(beveragesMap.getValue()));
            }

            if (beveragesMap.getKey().equals("Pepsi")) {
                rdPepsi1.setSelected(true);
                txtPepsi.setText(String.valueOf(beveragesMap.getValue()));
            }
        }
    }

    /**
     * Populate the menu fields
     */
    private void populateMenuFields() {
        if (premium.getMenu() != null) {
            if (premium.getMenu().getApetizers() != null && !premium.getMenu().getApetizers().isEmpty()) {
                populateAppetizerFields(premium.getMenu().getApetizers());
            }

            if (premium.getMenu().getMains() != null && !premium.getMenu().getMains().isEmpty()) {
                populateMainsFields(premium.getMenu().getMains());
            }

            if (premium.getMenu().getDessert() != null && !premium.getMenu().getDessert().isEmpty()) {
                populateDessertsFields(premium.getMenu().getDessert());
            }

            if (premium.getMenu().getBeverages() != null && !premium.getMenu().getBeverages().isEmpty()) {
                populateBeveragesFields(premium.getMenu().getBeverages());
            }
        }
    }

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

    private void populateOrders() {
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);

        for (Ticket ticket : ticketDirectory.getTicketList()) {
            if (ticket.getSuiteName() != null && ticket.getSuiteName().equals(premium.getRestaurantName())) {
                Object[] row = new Object[5];
                row[0] = ticket;
                row[1] = ticket.getCustomerName();
                row[2] = "$ " + String.valueOf(ticket.getFoodCost() + ticket.getReservationCost());
                row[3] = ticket.getEventName();
                row[4] = ticket.getTier();

                model.addRow(row);
            }
        }
    }

    private void popuateFoodItemList(int id) {
        DefaultTableModel model = (DefaultTableModel) tblFoodList.getModel();
        model.setRowCount(0);
        Ticket ticket = ticketDirectory.findTicketById(id);

        if (ticket != null && ticket.getFoodItems() != null && !ticket.getFoodItems().isEmpty()) {
            for (String food : ticket.getFoodItems()) {
                Object[] row = new Object[1];
                row[0] = food;
                model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssignDeliveryPanel;
    private javax.swing.JPanel EditDetailsPanel;
    private javax.swing.JPanel MenuPanel1;
    private javax.swing.JPanel NavigationJPanel;
    private javax.swing.JPanel OrderDetails;
    private javax.swing.JPanel ServiceDetails;
    private javax.swing.JPanel ViewServiceDetails;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnBack4;
    private javax.swing.JButton btnBack5;
    private javax.swing.JButton btnBack6;
    private javax.swing.JButton btnBack8;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnDetails2;
    private javax.swing.JButton btnDetails3;
    private javax.swing.JButton btnDetails4;
    private javax.swing.JButton btnDetails5;
    private javax.swing.JButton btnFeedback;
    private javax.swing.JButton btnFeedback1;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMenu2;
    private javax.swing.JButton btnMenu3;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JCheckBox chkAll;
    private javax.swing.JCheckBox chkNonVeg;
    private javax.swing.JCheckBox chkVeg;
    private javax.swing.JCheckBox chkVegan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbBeverages1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblApetizers1;
    private javax.swing.JLabel lblAptNonVeg1;
    private javax.swing.JLabel lblAptVeg1;
    private javax.swing.JLabel lblAptVegan1;
    private javax.swing.JLabel lblAptVegan2;
    private javax.swing.JLabel lblCuisine;
    private javax.swing.JLabel lblDesserts1;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblFullName1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblHeader1;
    private javax.swing.JLabel lblHeader2;
    private javax.swing.JLabel lblHeader3;
    private javax.swing.JLabel lblHeader4;
    private javax.swing.JLabel lblMains1;
    private javax.swing.JLabel lblMainsNonVeg1;
    private javax.swing.JLabel lblMainsVeg1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNonVeg;
    private javax.swing.JLabel lblOrderedAt;
    private javax.swing.JLabel lblOrderedAtValue;
    private javax.swing.JLabel lblOrderedBy;
    private javax.swing.JLabel lblOrderedByValue;
    private javax.swing.JLabel lblPhoneNum;
    private javax.swing.JLabel lblPhoneNumber1;
    private javax.swing.JLabel lblProfileImageView;
    private javax.swing.JLabel lblRestaurantName;
    private javax.swing.JLabel lblStaffMemberName;
    private javax.swing.JLabel lblVeg;
    private javax.swing.JLabel lblVegan;
    private javax.swing.JLabel lvlAll;
    private javax.swing.JPanel pnlFeedbackTable;
    private javax.swing.JRadioButton rdBlackForestCake1;
    private javax.swing.JRadioButton rdCheeseBurger1;
    private javax.swing.JRadioButton rdChocolateMousse1;
    private javax.swing.JRadioButton rdCocaCola1;
    private javax.swing.JRadioButton rdCrispyTofu1;
    private javax.swing.JRadioButton rdFalafelBowl1;
    private javax.swing.JRadioButton rdFishNChips1;
    private javax.swing.JRadioButton rdFreshLimesalted1;
    private javax.swing.JRadioButton rdFriedRice1;
    private javax.swing.JRadioButton rdFriedShrimp1;
    private javax.swing.JRadioButton rdHamBurger1;
    private javax.swing.JRadioButton rdMeatBalls1;
    private javax.swing.JRadioButton rdOnionRings1;
    private javax.swing.JRadioButton rdPepsi1;
    private javax.swing.JRadioButton rdPineappleSwissRole1;
    private javax.swing.JRadioButton rdPrawnFriedRice1;
    private javax.swing.JRadioButton rdSausageDip1;
    private javax.swing.JRadioButton rdSpinachPie1;
    private javax.swing.JRadioButton rdSpringRoles1;
    private javax.swing.JRadioButton rdTofuAndRiceBowl1;
    private javax.swing.JRadioButton rdTofuSalad1;
    private javax.swing.JRadioButton rdTortillaChips1;
    private javax.swing.JRadioButton rdVeggiePizza1;
    private javax.swing.JRadioButton rdWhiteBeanDip1;
    private javax.swing.JTable tblDeliveryStaff;
    private javax.swing.JTable tblFoodList;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblServices;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBlackForestCake;
    private javax.swing.JTextField txtCheeseBurger;
    private javax.swing.JTextField txtChocolateMousse;
    private javax.swing.JTextField txtCocaCola;
    private javax.swing.JTextField txtCrispyTofu;
    private javax.swing.JTextField txtCuisine;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtFalafelBowl;
    private javax.swing.JTextField txtFishNChips;
    private javax.swing.JTextField txtFreshLimeSalted;
    private javax.swing.JTextField txtFriedRice;
    private javax.swing.JTextField txtFriedShrimp;
    private javax.swing.JTextField txtFullName1;
    private javax.swing.JTextField txtHamBurger;
    private javax.swing.JTextField txtInstructions;
    private javax.swing.JTextField txtMeatBalls;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOnionRings;
    private javax.swing.JTextField txtPepsi;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtPhoneNumber1;
    private javax.swing.JTextField txtPineappleSwissRole;
    private javax.swing.JTextField txtPrawnFriedRice;
    private javax.swing.JTextField txtSausageDip;
    private javax.swing.JTextField txtSpinachPie;
    private javax.swing.JTextField txtSpringRoles;
    private javax.swing.JTextField txtTiers;
    private javax.swing.JTextField txtTofuAndRiceBowl;
    private javax.swing.JTextField txtTofuSalad;
    private javax.swing.JTextField txtTortillaChips;
    private javax.swing.JTextField txtVeggiePizza;
    private javax.swing.JTextField txtWhiteBeanDip;
    private javax.swing.JPanel workAreaPanel;
    // End of variables declaration//GEN-END:variables
}
