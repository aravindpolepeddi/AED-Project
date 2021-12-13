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
import business.Order.Order;
import business.Restaurant.Menu;
import business.hrservices.CleaningServices;
import business.hrservices.CleaningServicesDirectory;
import business.hrservices.EmergencyServices;
import business.hrservices.SecurityServices;
import business.hrservices.TechnicalServices;
import business.hrservices.EmergencyServicesDirectory;
import business.hrservices.SecurityServicesDirectory;
import business.hrservices.Staff;
import business.hrservices.TechnicalServicesDirectory;
import business.suites.Suites;
import business.suites.SuitesDirectory;
import business.useraccount.UserAccount;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class SuiteRolePanel extends javax.swing.JPanel {
    
    Suites suites;
    SuitesDirectory suitesDirectory;
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
     * Creates new form SuiteRolePanel
     */
    public SuiteRolePanel(JPanel userProcessContainer, UserAccount account, Business business) {
        initComponents();
        txtInstructions.setVisible(false);
        btnSubmit.setVisible(false);
        
        ImageIcon icon1 = new ImageIcon(".\\src\\images\\menu.png");
        Image image1 = icon1.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        btnMenu.setIcon(new ImageIcon(image1));
        
        this.networkString = account.getNetwork();
        
        if (business.getNetworkList() == null) {
            this.network = new HashMap<String, Enterprise>();
        } else {
            this.network = business.getNetworkList();
        }
        
        this.enterprise = business.findEnterpriseByNetwork(account.getNetwork());
        
        staffMembers = new ArrayList<>();
        
        if (enterprise.getSuitesDirectory() == null) {
            this.suitesDirectory = new SuitesDirectory();
        } else {
            this.suitesDirectory = enterprise.getSuitesDirectory();
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
        
        suites = suitesDirectory.findSuiteByManagerName(account.getName());
        lblRestaurantName.setText(suites.getRestaurantName() == null ? account.getName() + "'s Dashboard" : suites.getRestaurantName());
        if (suites.getCost() != 0) {
            txtCost.setText(String.valueOf(suites.getCost()));
        }
        populateOrders();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        NavigationJPanel = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        btnMenu1 = new javax.swing.JButton();
        btnMenu2 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        workAreaPanel = new javax.swing.JPanel();
        lblRestaurantName = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        pnlFeedbackTable = new javax.swing.JPanel();
        btnDetails = new javax.swing.JButton();
        txtCost = new javax.swing.JTextField();
        btnPricePerTable = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
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
        SeatingPanel = new javax.swing.JPanel();
        lblHeader4 = new javax.swing.JLabel();
        btnBack6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdT1C1 = new javax.swing.JRadioButton();
        rdT1C2 = new javax.swing.JRadioButton();
        rdT1C3 = new javax.swing.JRadioButton();
        rdT1C4 = new javax.swing.JRadioButton();
        rdT1C5 = new javax.swing.JRadioButton();
        rdT1C6 = new javax.swing.JRadioButton();
        rdT1C7 = new javax.swing.JRadioButton();
        rdT1C8 = new javax.swing.JRadioButton();
        rdT2C1 = new javax.swing.JRadioButton();
        rdT2C2 = new javax.swing.JRadioButton();
        rdT2C5 = new javax.swing.JRadioButton();
        rdT2C6 = new javax.swing.JRadioButton();
        rdT2C3 = new javax.swing.JRadioButton();
        rdT2C4 = new javax.swing.JRadioButton();
        rdT2C7 = new javax.swing.JRadioButton();
        rdT2C8 = new javax.swing.JRadioButton();
        rdT3C1 = new javax.swing.JRadioButton();
        rdT3C2 = new javax.swing.JRadioButton();
        rdT4C1 = new javax.swing.JRadioButton();
        rdT4C2 = new javax.swing.JRadioButton();
        rdT5C1 = new javax.swing.JRadioButton();
        rdT5C2 = new javax.swing.JRadioButton();
        rdT6C1 = new javax.swing.JRadioButton();
        rdT6C2 = new javax.swing.JRadioButton();
        rdT7C1 = new javax.swing.JRadioButton();
        rdT7C2 = new javax.swing.JRadioButton();
        rdT3C5 = new javax.swing.JRadioButton();
        rdT3C6 = new javax.swing.JRadioButton();
        rdT4C5 = new javax.swing.JRadioButton();
        rdT4C6 = new javax.swing.JRadioButton();
        rdT5C5 = new javax.swing.JRadioButton();
        rdT5C6 = new javax.swing.JRadioButton();
        rdT6C5 = new javax.swing.JRadioButton();
        rdT6C6 = new javax.swing.JRadioButton();
        rdT7C5 = new javax.swing.JRadioButton();
        rdT7C6 = new javax.swing.JRadioButton();
        rdT3C3 = new javax.swing.JRadioButton();
        rdT3C4 = new javax.swing.JRadioButton();
        rdT4C3 = new javax.swing.JRadioButton();
        rdT4C4 = new javax.swing.JRadioButton();
        rdT5C3 = new javax.swing.JRadioButton();
        rdT5C4 = new javax.swing.JRadioButton();
        rdT6C3 = new javax.swing.JRadioButton();
        rdT6C4 = new javax.swing.JRadioButton();
        rdT7C3 = new javax.swing.JRadioButton();
        rdT7C4 = new javax.swing.JRadioButton();
        rdT3C7 = new javax.swing.JRadioButton();
        rdT3C8 = new javax.swing.JRadioButton();
        rdT4C8 = new javax.swing.JRadioButton();
        rdT4C7 = new javax.swing.JRadioButton();
        rdT5C7 = new javax.swing.JRadioButton();
        rdT5C8 = new javax.swing.JRadioButton();
        rdT6C8 = new javax.swing.JRadioButton();
        rdT6C7 = new javax.swing.JRadioButton();
        rdT7C8 = new javax.swing.JRadioButton();
        rdT7C7 = new javax.swing.JRadioButton();
        btnSaveSeats = new javax.swing.JButton();
        ServicesPanel = new javax.swing.JPanel();
        lblHeader1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblServices = new javax.swing.JTable();
        btnDetails1 = new javax.swing.JButton();
        btnDetails2 = new javax.swing.JButton();
        btnDetails3 = new javax.swing.JButton();
        btnDetails4 = new javax.swing.JButton();
        txtInstructions = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        ViewServiceDetails = new javax.swing.JPanel();
        btnBack8 = new javax.swing.JButton();
        lblStaffMemberName = new javax.swing.JLabel();
        lblProfileImageView = new javax.swing.JLabel();
        lblFullName1 = new javax.swing.JLabel();
        txtFullName1 = new javax.swing.JTextField();
        lblPhoneNumber1 = new javax.swing.JLabel();
        txtPhoneNumber1 = new javax.swing.JTextField();
        lblEmail2 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        AddInstructionsPanel = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtFeedback = new javax.swing.JTextField();
        lblFeedback = new javax.swing.JLabel();
        btnSubmitFeedback = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTextPane1);

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

        btnMenu1.setBackground(new java.awt.Color(206, 217, 217));
        btnMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu1.setForeground(new java.awt.Color(0, 51, 51));
        btnMenu1.setText("SEATING");
        btnMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenu1MouseExited(evt);
            }
        });
        btnMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu1ActionPerformed(evt);
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
                    .addComponent(btnMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NavigationJPanelLayout.setVerticalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationJPanelLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "CUSTOMER", "BILL AMOUNT", "EVENT"
            }
        ));
        tblOrders.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblOrders.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane3.setViewportView(tblOrders);

        pnlFeedbackTable.setBackground(new java.awt.Color(240, 255, 255));

        javax.swing.GroupLayout pnlFeedbackTableLayout = new javax.swing.GroupLayout(pnlFeedbackTable);
        pnlFeedbackTable.setLayout(pnlFeedbackTableLayout);
        pnlFeedbackTableLayout.setHorizontalGroup(
            pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        pnlFeedbackTableLayout.setVerticalGroup(
            pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );

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

        btnPricePerTable.setBackground(new java.awt.Color(255, 102, 0));
        btnPricePerTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPricePerTable.setForeground(new java.awt.Color(255, 255, 0));
        btnPricePerTable.setText("Add Price per table");
        btnPricePerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPricePerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPricePerTableActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/suiteFood1.gif"))); // NOI18N

        javax.swing.GroupLayout workAreaPanelLayout = new javax.swing.GroupLayout(workAreaPanel);
        workAreaPanel.setLayout(workAreaPanelLayout);
        workAreaPanelLayout.setHorizontalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(workAreaPanelLayout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(pnlFeedbackTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRestaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(workAreaPanelLayout.createSequentialGroup()
                            .addComponent(btnDetails)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnPricePerTable))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workAreaPanelLayout.setVerticalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblRestaurantName)
                .addGap(43, 43, 43)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPricePerTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFeedbackTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
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
                .addContainerGap(327, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
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
        lblOrderedAt.setText("EVENT");

        lblOrderedByValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrderedByValue.setForeground(new java.awt.Color(0, 153, 51));
        lblOrderedByValue.setText("<Customer Name>");

        lblOrderedAtValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrderedAtValue.setForeground(new java.awt.Color(0, 153, 51));
        lblOrderedAtValue.setText("<EventName>");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
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
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jLayeredPane1.add(OrderDetails, "card5");

        SeatingPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader4.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader4.setText("Seating");

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

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("T3");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("T1");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("T4");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("T2");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("T5");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("T7");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("T6");
        jLabel7.setOpaque(true);

        rdT1C1.setText("C1");

        rdT1C2.setText("C2");

        rdT1C3.setText("C3");

        rdT1C4.setText("C4");

        rdT1C5.setText("C5");

        rdT1C6.setText("C6");

        rdT1C7.setText("C7");

        rdT1C8.setText("C8");

        rdT2C1.setText("C1");

        rdT2C2.setText("C2");

        rdT2C5.setText("C5");

        rdT2C6.setText("C6");

        rdT2C3.setText("C3");

        rdT2C4.setText("C4");

        rdT2C7.setText("C7");

        rdT2C8.setText("C8");

        rdT3C1.setText("C1");

        rdT3C2.setText("C2");

        rdT4C1.setText("C1");

        rdT4C2.setText("C2");

        rdT5C1.setText("C1");

        rdT5C2.setText("C2");
        rdT5C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdT5C2ActionPerformed(evt);
            }
        });

        rdT6C1.setText("C1");

        rdT6C2.setText("C2");

        rdT7C1.setText("C1");

        rdT7C2.setText("C2");

        rdT3C5.setText("C5");

        rdT3C6.setText("C6");

        rdT4C5.setText("C5");

        rdT4C6.setText("C6");

        rdT5C5.setText("C5");

        rdT5C6.setText("C6");

        rdT6C5.setText("C5");

        rdT6C6.setText("C6");

        rdT7C5.setText("C5");

        rdT7C6.setText("C6");

        rdT3C3.setText("C3");

        rdT3C4.setText("C4");

        rdT4C3.setText("C3");

        rdT4C4.setText("C4");

        rdT5C3.setText("C3");

        rdT5C4.setText("C4");

        rdT6C3.setText("C3");

        rdT6C4.setText("C4");

        rdT7C3.setText("C3");

        rdT7C4.setText("C4");

        rdT3C7.setText("C7");

        rdT3C8.setText("C8");

        rdT4C8.setText("C8");

        rdT4C7.setText("C7");

        rdT5C7.setText("C7");

        rdT5C8.setText("C8");

        rdT6C8.setText("C8");

        rdT6C7.setText("C7");

        rdT7C8.setText("C8");

        rdT7C7.setText("C7");

        btnSaveSeats.setBackground(new java.awt.Color(215, 254, 211));
        btnSaveSeats.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSaveSeats.setForeground(new java.awt.Color(72, 151, 64));
        btnSaveSeats.setText("SAVE");
        btnSaveSeats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveSeatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveSeatsMouseExited(evt);
            }
        });
        btnSaveSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSeatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeatingPanelLayout = new javax.swing.GroupLayout(SeatingPanel);
        SeatingPanel.setLayout(SeatingPanelLayout);
        SeatingPanelLayout.setHorizontalGroup(
            SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeatingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdT1C1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdT1C2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT1C3)
                                .addGap(18, 18, 18)
                                .addComponent(rdT1C4))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT1C7)
                                .addGap(18, 18, 18)
                                .addComponent(rdT1C8))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdT1C5)
                                    .addComponent(rdT1C6))))
                        .addGap(18, 18, 18)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdT2C1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdT2C2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdT2C5)
                                            .addComponent(rdT2C6))
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(rdT3C3)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdT3C4))
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(rdT3C2)
                                                    .addComponent(rdT3C1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(rdT3C7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(rdT3C8))
                                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(6, 6, 6)
                                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(rdT3C5)
                                                            .addComponent(rdT3C6)))))))
                                    .addComponent(lblHeader4)))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdT2C7)
                                .addGap(18, 18, 18)
                                .addComponent(rdT2C8))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT2C3)
                                .addGap(18, 18, 18)
                                .addComponent(rdT2C4)))
                        .addGap(305, 305, 305)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack6)
                            .addComponent(btnSaveSeats))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdT4C1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdT4C2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT4C7)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT4C8))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT4C6)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT5C2))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT4C5)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT5C1))))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT4C3)
                                .addGap(18, 18, 18)
                                .addComponent(rdT4C4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdT5C7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdT5C8))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT5C3)
                                .addGap(18, 18, 18)
                                .addComponent(rdT5C4))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdT5C5)
                                    .addComponent(rdT5C6))))
                        .addGap(27, 27, 27)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdT6C1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdT6C2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT6C3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT6C4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdT6C5)
                                    .addComponent(rdT6C6)))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdT6C7)
                                .addGap(18, 18, 18)
                                .addComponent(rdT6C8)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(SeatingPanelLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdT7C1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdT7C2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT7C3)
                                .addGap(18, 18, 18)
                                .addComponent(rdT7C4))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdT7C5)
                            .addComponent(rdT7C6)))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addComponent(rdT7C7)
                        .addGap(18, 18, 18)
                        .addComponent(rdT7C8)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SeatingPanelLayout.setVerticalGroup(
            SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeatingPanelLayout.createSequentialGroup()
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnBack6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveSeats)
                        .addGap(175, 175, 175))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblHeader4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT2C3)
                                            .addComponent(rdT2C4))
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(rdT2C1)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdT2C2))
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(rdT2C5)
                                                .addGap(27, 27, 27)
                                                .addComponent(rdT2C6)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT2C7)
                                            .addComponent(rdT2C8)))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(rdT1C3)
                                                    .addComponent(rdT1C4))
                                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                        .addComponent(rdT1C5)
                                                        .addGap(27, 27, 27)
                                                        .addComponent(rdT1C6))))
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(rdT1C1)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdT1C2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT1C7)
                                            .addComponent(rdT1C8))))
                                .addGap(22, 22, 22))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT3C5)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT3C6)
                                        .addGap(50, 50, 50))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdT3C3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rdT3C4))
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdT3C1)
                                                .addGap(25, 25, 25)
                                                .addComponent(rdT3C2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT3C7)
                                            .addComponent(rdT3C8))))))))
                .addGap(19, 19, 19)
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT4C3)
                                            .addComponent(rdT4C4)
                                            .addComponent(rdT5C3)
                                            .addComponent(rdT5C4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT4C5)
                                            .addComponent(rdT5C1))
                                        .addGap(27, 27, 27)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT4C6)
                                            .addComponent(rdT5C2))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdT4C7)
                                        .addComponent(rdT4C8))
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdT5C7)
                                        .addComponent(rdT5C8))))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(rdT4C1)
                                .addGap(18, 18, 18)
                                .addComponent(rdT4C2)))
                        .addGap(56, 56, 56)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdT7C3)
                                    .addComponent(rdT7C4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT7C7)
                                            .addComponent(rdT7C8)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT7C1)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT7C2)
                                        .addGap(44, 44, 44))))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(rdT7C5)
                                .addGap(27, 27, 27)
                                .addComponent(rdT7C6)
                                .addGap(40, 40, 40))))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(rdT5C5)
                        .addGap(18, 18, 18)
                        .addComponent(rdT5C6))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(rdT6C1)
                        .addGap(18, 18, 18)
                        .addComponent(rdT6C2))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(rdT6C5)
                        .addGap(27, 27, 27)
                        .addComponent(rdT6C6))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdT6C3)
                            .addComponent(rdT6C4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdT6C7)
                            .addComponent(rdT6C8))))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jLayeredPane1.add(SeatingPanel, "card7");

        ServicesPanel.setBackground(new java.awt.Color(240, 255, 255));

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
        jScrollPane6.setViewportView(tblServices);

        btnDetails1.setBackground(new java.awt.Color(255, 255, 255));
        btnDetails1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetails1.setForeground(new java.awt.Color(0, 153, 51));
        btnDetails1.setText("VIEW SERVICE PERSONEL");
        btnDetails1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetails1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetails1MouseExited(evt);
            }
        });
        btnDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails1ActionPerformed(evt);
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

        javax.swing.GroupLayout ServicesPanelLayout = new javax.swing.GroupLayout(ServicesPanel);
        ServicesPanel.setLayout(ServicesPanelLayout);
        ServicesPanelLayout.setHorizontalGroup(
            ServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack1)
                .addGap(50, 50, 50))
            .addGroup(ServicesPanelLayout.createSequentialGroup()
                .addGroup(ServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ServicesPanelLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(lblHeader1))
                    .addGroup(ServicesPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(ServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit)
                            .addGroup(ServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ServicesPanelLayout.createSequentialGroup()
                                    .addComponent(btnDetails1)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDetails2)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDetails4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDetails3))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        ServicesPanelLayout.setVerticalGroup(
            ServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicesPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnBack1)
                .addGap(3, 3, 3)
                .addComponent(lblHeader1)
                .addGap(42, 42, 42)
                .addGroup(ServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails1)
                    .addComponent(btnDetails2)
                    .addComponent(btnDetails3)
                    .addComponent(btnDetails4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addContainerGap(353, Short.MAX_VALUE))
        );

        jLayeredPane1.add(ServicesPanel, "card7");

        ViewServiceDetails.setBackground(new java.awt.Color(240, 255, 255));

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

        lblStaffMemberName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStaffMemberName.setForeground(new java.awt.Color(0, 153, 153));
        lblStaffMemberName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStaffMemberName.setText("<<Staff Member Name>>");

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
                .addContainerGap(304, Short.MAX_VALUE))
        );

        ViewServiceDetailsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEmail1, txtFullName1, txtPhoneNumber1});

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
                .addContainerGap(336, Short.MAX_VALUE))
        );

        jLayeredPane1.add(ViewServiceDetails, "card8");

        AddInstructionsPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblHeading.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(0, 153, 153));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("INSTRUCTIONS");

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("BACK");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtFeedback.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblFeedback.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFeedback.setForeground(new java.awt.Color(0, 51, 51));
        lblFeedback.setText("INSTRUCTIONS : ");

        btnSubmitFeedback.setBackground(new java.awt.Color(215, 254, 211));
        btnSubmitFeedback.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSubmitFeedback.setForeground(new java.awt.Color(72, 151, 64));
        btnSubmitFeedback.setText("SUBMIT FEEDBACK");
        btnSubmitFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmitFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddInstructionsPanelLayout = new javax.swing.GroupLayout(AddInstructionsPanel);
        AddInstructionsPanel.setLayout(AddInstructionsPanelLayout);
        AddInstructionsPanelLayout.setHorizontalGroup(
            AddInstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddInstructionsPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(AddInstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFeedback)
                    .addGroup(AddInstructionsPanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnSubmitFeedback)))
                .addContainerGap(395, Short.MAX_VALUE))
            .addGroup(AddInstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddInstructionsPanelLayout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2)
                    .addContainerGap(365, Short.MAX_VALUE)))
        );
        AddInstructionsPanelLayout.setVerticalGroup(
            AddInstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddInstructionsPanelLayout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(lblFeedback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnSubmitFeedback)
                .addGap(139, 139, 139))
            .addGroup(AddInstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddInstructionsPanelLayout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(AddInstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addContainerGap(700, Short.MAX_VALUE)))
        );

        jLayeredPane1.add(AddInstructionsPanel, "card9");

        jSplitPane1.setRightComponent(jLayeredPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseEntered

    }//GEN-LAST:event_btnMenuMouseEntered

    private void btnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseExited

    }//GEN-LAST:event_btnMenuMouseExited

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        switchPanels(MenuPanel1);
        populateMenuFields();
    }//GEN-LAST:event_btnMenuActionPerformed

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
            suites.setMenu(menu);
            JOptionPane.showMessageDialog(null, "Menu saved successfully.");
            switchPanels(workAreaPanel);
        }
    }//GEN-LAST:event_btnBack4ActionPerformed
    
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
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBack5ActionPerformed

    private void btnMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu1MouseEntered

    private void btnMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu1MouseExited

    private void btnMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu1ActionPerformed
        switchPanels(SeatingPanel);
        populateSeats();
    }//GEN-LAST:event_btnMenu1ActionPerformed

    private void btnBack6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack6MouseEntered

    private void btnBack6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack6MouseExited

    private void btnBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack6ActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBack6ActionPerformed

    private void rdT5C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdT5C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdT5C2ActionPerformed

    private void btnMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu2MouseEntered

    private void btnMenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu2MouseExited

    private void btnMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu2ActionPerformed
        switchPanels(ServicesPanel);
        populateStaff();
    }//GEN-LAST:event_btnMenu2ActionPerformed

    private void btnSaveSeatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveSeatsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveSeatsMouseEntered

    private void btnSaveSeatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveSeatsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveSeatsMouseExited

    private void btnSaveSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSeatsActionPerformed
        Map<String, List<String>> seatsMap = new HashMap<>();
        List<String> seatsListForT1 = new ArrayList<String>();
        
        if (rdT1C1.isSelected()) {
            seatsListForT1.add("C1");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C2.isSelected()) {
            seatsListForT1.add("C2");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C3.isSelected()) {
            seatsListForT1.add("C3");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C4.isSelected()) {
            seatsListForT1.add("C4");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C5.isSelected()) {
            seatsListForT1.add("C5");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C6.isSelected()) {
            seatsListForT1.add("C6");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C7.isSelected()) {
            seatsListForT1.add("C7");
            seatsMap.put("T1", seatsListForT1);
        }
        
        if (rdT1C8.isSelected()) {
            seatsListForT1.add("C8");
            seatsMap.put("T1", seatsListForT1);
        }
        
        List<String> seatsListForT2 = new ArrayList<String>();
        if (rdT2C1.isSelected()) {
            seatsListForT2.add("C1");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C2.isSelected()) {
            seatsListForT2.add("C2");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C3.isSelected()) {
            seatsListForT2.add("C3");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C4.isSelected()) {
            seatsListForT2.add("C4");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C5.isSelected()) {
            seatsListForT2.add("C5");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C6.isSelected()) {
            seatsListForT2.add("C6");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C7.isSelected()) {
            seatsListForT2.add("C7");
            seatsMap.put("T2", seatsListForT2);
        }
        
        if (rdT2C8.isSelected()) {
            seatsListForT2.add("C8");
            seatsMap.put("T2", seatsListForT2);
        }
        
        List<String> seatsListForT3 = new ArrayList<String>();
        if (rdT3C1.isSelected()) {
            seatsListForT3.add("C1");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C2.isSelected()) {
            seatsListForT3.add("C2");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C3.isSelected()) {
            seatsListForT3.add("C3");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C4.isSelected()) {
            seatsListForT3.add("C4");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C5.isSelected()) {
            seatsListForT3.add("C5");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C6.isSelected()) {
            seatsListForT3.add("C6");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C7.isSelected()) {
            seatsListForT3.add("C7");
            seatsMap.put("T3", seatsListForT3);
        }
        
        if (rdT3C8.isSelected()) {
            seatsListForT3.add("C8");
            seatsMap.put("T3", seatsListForT3);
        }
        
        List<String> seatsListForT4 = new ArrayList<String>();
        if (rdT4C1.isSelected()) {
            seatsListForT4.add("C1");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C2.isSelected()) {
            seatsListForT4.add("C2");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C3.isSelected()) {
            seatsListForT4.add("C3");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C4.isSelected()) {
            seatsListForT4.add("C4");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C5.isSelected()) {
            seatsListForT4.add("C5");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C6.isSelected()) {
            seatsListForT4.add("C6");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C7.isSelected()) {
            seatsListForT4.add("C7");
            seatsMap.put("T4", seatsListForT4);
        }
        
        if (rdT4C8.isSelected()) {
            seatsListForT4.add("C8");
            seatsMap.put("T4", seatsListForT4);
        }
        
        List<String> seatsListForT5 = new ArrayList<String>();
        if (rdT5C1.isSelected()) {
            seatsListForT5.add("C1");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C2.isSelected()) {
            seatsListForT5.add("C2");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C3.isSelected()) {
            seatsListForT5.add("C3");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C4.isSelected()) {
            seatsListForT5.add("C4");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C5.isSelected()) {
            seatsListForT5.add("C5");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C6.isSelected()) {
            seatsListForT5.add("C6");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C7.isSelected()) {
            seatsListForT5.add("C7");
            seatsMap.put("T5", seatsListForT5);
        }
        
        if (rdT5C8.isSelected()) {
            seatsListForT5.add("C8");
            seatsMap.put("T5", seatsListForT5);
        }
        
        List<String> seatsListForT6 = new ArrayList<String>();
        if (rdT6C1.isSelected()) {
            seatsListForT5.add("C1");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C2.isSelected()) {
            seatsListForT6.add("C2");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C3.isSelected()) {
            seatsListForT6.add("C3");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C4.isSelected()) {
            seatsListForT6.add("C4");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C5.isSelected()) {
            seatsListForT6.add("C5");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C6.isSelected()) {
            seatsListForT6.add("C6");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C7.isSelected()) {
            seatsListForT6.add("C7");
            seatsMap.put("T6", seatsListForT6);
        }
        
        if (rdT6C8.isSelected()) {
            seatsListForT6.add("C8");
            seatsMap.put("T6", seatsListForT6);
        }
        
        List<String> seatsListForT7 = new ArrayList<String>();
        if (rdT7C1.isSelected()) {
            seatsListForT7.add("C1");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C2.isSelected()) {
            seatsListForT7.add("C2");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C3.isSelected()) {
            seatsListForT7.add("C3");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C4.isSelected()) {
            seatsListForT7.add("C4");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C5.isSelected()) {
            seatsListForT7.add("C5");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C6.isSelected()) {
            seatsListForT7.add("C6");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C7.isSelected()) {
            seatsListForT7.add("C7");
            seatsMap.put("T7", seatsListForT7);
        }
        
        if (rdT7C8.isSelected()) {
            seatsListForT7.add("C8");
            seatsMap.put("T7", seatsListForT7);
        }
        
        JOptionPane.showMessageDialog(null, "Seating saved successfully.");
        switchPanels(workAreaPanel);
        suites.setSeats(seatsMap);
        restRadioButtons();
    }//GEN-LAST:event_btnSaveSeatsActionPerformed

    private void btnBack1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1MouseEntered

    private void btnBack1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1MouseExited

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnDetails1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails1MouseEntered

    }//GEN-LAST:event_btnDetails1MouseEntered

    private void btnDetails1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetails1MouseExited

    }//GEN-LAST:event_btnDetails1MouseExited

    private void btnDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails1ActionPerformed
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
    }//GEN-LAST:event_btnDetails1ActionPerformed

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

    private void btnBack8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack8MouseEntered

    private void btnBack8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack8MouseExited

    private void btnBack8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack8ActionPerformed
        switchPanels(ServicesPanel);
    }//GEN-LAST:event_btnBack8ActionPerformed

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switchPanels(workAreaPanel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSubmitFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitFeedbackActionPerformed

    }//GEN-LAST:event_btnSubmitFeedbackActionPerformed

    private void btnPricePerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPricePerTableActionPerformed
        
        if (txtCost.getText() == null || txtCost.getText().isEmpty() || txtCost.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Enter a valid cost!");
        } else {
            suites.setCost(Integer.parseInt(txtCost.getText()));
            JOptionPane.showMessageDialog(this, "Price per table added successfully");
        }
    }//GEN-LAST:event_btnPricePerTableActionPerformed

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
        if (suites.getMenu() != null) {
            if (suites.getMenu().getApetizers() != null && !suites.getMenu().getApetizers().isEmpty()) {
                populateAppetizerFields(suites.getMenu().getApetizers());
            }
            
            if (suites.getMenu().getMains() != null && !suites.getMenu().getMains().isEmpty()) {
                populateMainsFields(suites.getMenu().getMains());
            }
            
            if (suites.getMenu().getDessert() != null && !suites.getMenu().getDessert().isEmpty()) {
                populateDessertsFields(suites.getMenu().getDessert());
            }
            
            if (suites.getMenu().getBeverages() != null && !suites.getMenu().getBeverages().isEmpty()) {
                populateBeveragesFields(suites.getMenu().getBeverages());
            }
        }
    }
    
    private void populateSeats() {
        if (suites.getSeats() != null && !suites.getSeats().isEmpty()) {
            for (Map.Entry<String, List<String>> seatsMap : suites.getSeats().entrySet()) {
                if (seatsMap.getKey().equals("T1")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT1C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT1C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT1C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT1C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT1C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT1C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT1C7.setSelected(true);
                        }
                    }
                }
                
                if (seatsMap.getKey().equals("T2")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT2C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT2C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT2C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT2C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT2C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT2C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT2C7.setSelected(true);
                        }
                    }
                }
                
                if (seatsMap.getKey().equals("T3")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT3C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT3C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT3C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT3C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT3C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT3C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT3C7.setSelected(true);
                        }
                    }
                }
                
                if (seatsMap.getKey().equals("T4")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT4C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT4C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT4C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT4C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT4C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT4C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT4C7.setSelected(true);
                        }
                    }
                }
                
                if (seatsMap.getKey().equals("T5")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT5C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT5C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT5C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT5C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT5C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT5C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT5C7.setSelected(true);
                        }
                    }
                }
                
                if (seatsMap.getKey().equals("T6")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT6C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT6C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT6C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT6C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT6C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT6C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT6C7.setSelected(true);
                        }
                    }
                }
                if (seatsMap.getKey().equals("T7")) {
                    for (String chair : seatsMap.getValue()) {
                        if (chair.equals("C1")) {
                            rdT7C1.setSelected(true);
                        }
                        
                        if (chair.equals("C2")) {
                            rdT7C2.setSelected(true);
                        }
                        
                        if (chair.equals("C3")) {
                            rdT7C3.setSelected(true);
                        }
                        
                        if (chair.equals("C4")) {
                            rdT7C4.setSelected(true);
                        }
                        
                        if (chair.equals("C5")) {
                            rdT7C5.setSelected(true);
                        }
                        
                        if (chair.equals("C6")) {
                            rdT7C6.setSelected(true);
                        }
                        
                        if (chair.equals("C7")) {
                            rdT7C7.setSelected(true);
                        }
                    }
                }
            }
        }
    }
    
    private void restRadioButtons() {
        rdT1C1.setSelected(false);
        rdT1C2.setSelected(false);
        rdT1C3.setSelected(false);
        rdT1C4.setSelected(false);
        rdT1C5.setSelected(false);
        rdT1C6.setSelected(false);
        rdT1C7.setSelected(false);
        rdT1C8.setSelected(false);
        
        rdT2C1.setSelected(false);
        rdT2C2.setSelected(false);
        rdT2C3.setSelected(false);
        rdT2C4.setSelected(false);
        rdT2C5.setSelected(false);
        rdT2C6.setSelected(false);
        rdT2C7.setSelected(false);
        rdT2C8.setSelected(false);
        
        rdT3C1.setSelected(false);
        rdT3C2.setSelected(false);
        rdT3C3.setSelected(false);
        rdT3C4.setSelected(false);
        rdT3C5.setSelected(false);
        rdT3C6.setSelected(false);
        rdT3C7.setSelected(false);
        rdT3C8.setSelected(false);
        
        rdT4C1.setSelected(false);
        rdT4C2.setSelected(false);
        rdT4C3.setSelected(false);
        rdT4C4.setSelected(false);
        rdT4C5.setSelected(false);
        rdT4C6.setSelected(false);
        rdT4C7.setSelected(false);
        rdT4C8.setSelected(false);
        
        rdT5C1.setSelected(false);
        rdT5C2.setSelected(false);
        rdT5C3.setSelected(false);
        rdT5C4.setSelected(false);
        rdT5C5.setSelected(false);
        rdT5C6.setSelected(false);
        rdT5C7.setSelected(false);
        rdT5C8.setSelected(false);
        
        rdT6C1.setSelected(false);
        rdT6C2.setSelected(false);
        rdT6C3.setSelected(false);
        rdT6C4.setSelected(false);
        rdT6C5.setSelected(false);
        rdT6C6.setSelected(false);
        rdT6C7.setSelected(false);
        rdT6C8.setSelected(false);
        
        rdT7C1.setSelected(false);
        rdT7C2.setSelected(false);
        rdT7C3.setSelected(false);
        rdT7C4.setSelected(false);
        rdT7C5.setSelected(false);
        rdT7C6.setSelected(false);
        rdT7C7.setSelected(false);
        rdT7C8.setSelected(false);
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
            if (ticket.getSuiteName() != null && ticket.getSuiteName().equals(suites.getRestaurantName())) {
                Object[] row = new Object[4];
                row[0] = ticket;
                row[1] = ticket.getCustomerName();
                row[2] = "$ " + String.valueOf(ticket.getFoodCost() + ticket.getReservationCost());
                row[3] = ticket.getEventName();
                
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
    private javax.swing.JPanel AddInstructionsPanel;
    private javax.swing.JPanel EditDetailsPanel;
    private javax.swing.JPanel MenuPanel1;
    private javax.swing.JPanel NavigationJPanel;
    private javax.swing.JPanel OrderDetails;
    private javax.swing.JPanel SeatingPanel;
    private javax.swing.JPanel ServicesPanel;
    private javax.swing.JPanel ViewServiceDetails;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnBack4;
    private javax.swing.JButton btnBack5;
    private javax.swing.JButton btnBack6;
    private javax.swing.JButton btnBack8;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnDetails1;
    private javax.swing.JButton btnDetails2;
    private javax.swing.JButton btnDetails3;
    private javax.swing.JButton btnDetails4;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMenu1;
    private javax.swing.JButton btnMenu2;
    private javax.swing.JButton btnPricePerTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveSeats;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitFeedback;
    private javax.swing.JCheckBox chkAll;
    private javax.swing.JCheckBox chkNonVeg;
    private javax.swing.JCheckBox chkVeg;
    private javax.swing.JCheckBox chkVegan;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextPane jTextPane1;
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
    private javax.swing.JLabel lblFeedback;
    private javax.swing.JLabel lblFullName1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblHeader1;
    private javax.swing.JLabel lblHeader2;
    private javax.swing.JLabel lblHeader3;
    private javax.swing.JLabel lblHeader4;
    private javax.swing.JLabel lblHeading;
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
    private javax.swing.JRadioButton rdT1C1;
    private javax.swing.JRadioButton rdT1C2;
    private javax.swing.JRadioButton rdT1C3;
    private javax.swing.JRadioButton rdT1C4;
    private javax.swing.JRadioButton rdT1C5;
    private javax.swing.JRadioButton rdT1C6;
    private javax.swing.JRadioButton rdT1C7;
    private javax.swing.JRadioButton rdT1C8;
    private javax.swing.JRadioButton rdT2C1;
    private javax.swing.JRadioButton rdT2C2;
    private javax.swing.JRadioButton rdT2C3;
    private javax.swing.JRadioButton rdT2C4;
    private javax.swing.JRadioButton rdT2C5;
    private javax.swing.JRadioButton rdT2C6;
    private javax.swing.JRadioButton rdT2C7;
    private javax.swing.JRadioButton rdT2C8;
    private javax.swing.JRadioButton rdT3C1;
    private javax.swing.JRadioButton rdT3C2;
    private javax.swing.JRadioButton rdT3C3;
    private javax.swing.JRadioButton rdT3C4;
    private javax.swing.JRadioButton rdT3C5;
    private javax.swing.JRadioButton rdT3C6;
    private javax.swing.JRadioButton rdT3C7;
    private javax.swing.JRadioButton rdT3C8;
    private javax.swing.JRadioButton rdT4C1;
    private javax.swing.JRadioButton rdT4C2;
    private javax.swing.JRadioButton rdT4C3;
    private javax.swing.JRadioButton rdT4C4;
    private javax.swing.JRadioButton rdT4C5;
    private javax.swing.JRadioButton rdT4C6;
    private javax.swing.JRadioButton rdT4C7;
    private javax.swing.JRadioButton rdT4C8;
    private javax.swing.JRadioButton rdT5C1;
    private javax.swing.JRadioButton rdT5C2;
    private javax.swing.JRadioButton rdT5C3;
    private javax.swing.JRadioButton rdT5C4;
    private javax.swing.JRadioButton rdT5C5;
    private javax.swing.JRadioButton rdT5C6;
    private javax.swing.JRadioButton rdT5C7;
    private javax.swing.JRadioButton rdT5C8;
    private javax.swing.JRadioButton rdT6C1;
    private javax.swing.JRadioButton rdT6C2;
    private javax.swing.JRadioButton rdT6C3;
    private javax.swing.JRadioButton rdT6C4;
    private javax.swing.JRadioButton rdT6C5;
    private javax.swing.JRadioButton rdT6C6;
    private javax.swing.JRadioButton rdT6C7;
    private javax.swing.JRadioButton rdT6C8;
    private javax.swing.JRadioButton rdT7C1;
    private javax.swing.JRadioButton rdT7C2;
    private javax.swing.JRadioButton rdT7C3;
    private javax.swing.JRadioButton rdT7C4;
    private javax.swing.JRadioButton rdT7C5;
    private javax.swing.JRadioButton rdT7C6;
    private javax.swing.JRadioButton rdT7C7;
    private javax.swing.JRadioButton rdT7C8;
    private javax.swing.JRadioButton rdTofuAndRiceBowl1;
    private javax.swing.JRadioButton rdTofuSalad1;
    private javax.swing.JRadioButton rdTortillaChips1;
    private javax.swing.JRadioButton rdVeggiePizza1;
    private javax.swing.JRadioButton rdWhiteBeanDip1;
    private javax.swing.JTable tblFoodList;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblServices;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBlackForestCake;
    private javax.swing.JTextField txtCheeseBurger;
    private javax.swing.JTextField txtChocolateMousse;
    private javax.swing.JTextField txtCocaCola;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtCrispyTofu;
    private javax.swing.JTextField txtCuisine;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtFalafelBowl;
    private javax.swing.JTextField txtFeedback;
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
    private javax.swing.JTextField txtTofuAndRiceBowl;
    private javax.swing.JTextField txtTofuSalad;
    private javax.swing.JTextField txtTortillaChips;
    private javax.swing.JTextField txtVeggiePizza;
    private javax.swing.JTextField txtWhiteBeanDip;
    private javax.swing.JPanel workAreaPanel;
    // End of variables declaration//GEN-END:variables
}
