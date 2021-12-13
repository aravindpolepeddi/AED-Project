/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.CustomerRole;

import business.Business;
import business.Customer.Customer;
import business.Customer.CustomerDirectory;
import business.Customer.Ticket;
import business.Customer.TicketDirectory;
import business.Enterprise;
import business.Enterprises.EnterpriseDirectory;
import business.FlagClass;
import business.SendMail;
import business.event.Event;
import business.event.EventDirectory;
import business.merchandise.merchandise;
import business.merchandise.merchandiseShop;
import business.merchandise.merchandiseShopDirectory;
import business.premium.Premium;
import business.premium.PremiumDirectory;
import business.suites.Suites;
import business.suites.SuitesDirectory;
import business.ticketing.CarBooking;
import business.ticketing.PickandDropDirectory;
import business.useraccount.UserAccount;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import ui.MainScreen;

/**
 *
 * @author Sanyuktha
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {

    EventDirectory eventDirectory;
    Event event;
    CustomerDirectory customerDirectory;
    Customer customer;
    Ticket ticket;
    SuitesDirectory suitedDirectory;
    String suiteName;
    PremiumDirectory premiumDirectory;
    String premiumName;
    int totalCost;
    int reservationCost;
    ArrayList<String> foodItems;
    TicketDirectory ticketDirectory;
    Business business;
    FlagClass flags;
    Map<String, Enterprise> network;
    EnterpriseDirectory enterpriseDirectory;
    Enterprise enterprise;
    String networkString;
    merchandiseShopDirectory merchDirectory;
    PickandDropDirectory pdDirectory;
    Logger logger = Logger.getLogger(CustomerWorkAreaJPanel.class);

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    public CustomerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Business business) {
        initComponents();

        BasicConfigurator.configure();
        logger.info("Logged in as Customer.");

        ImageIcon icon1 = new ImageIcon(".\\src\\images\\profile.png");
        Image image1 = icon1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        btnEditDetails.setIcon(new ImageIcon(image1));

        ImageIcon icon2 = new ImageIcon(".\\src\\images\\register.png");
        Image image2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        btnMenu.setIcon(new ImageIcon(image2));

        ImageIcon icon3 = new ImageIcon(".\\src\\images\\bookings.png");
        Image image3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jButton2.setIcon(new ImageIcon(image3));

        ImageIcon icon4 = new ImageIcon(".\\src\\images\\store.png");
        Image image4 = icon4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jButton7.setIcon(new ImageIcon(image4));

        ImageIcon icon5 = new ImageIcon(".\\src\\images\\pickdrop.png");
        Image image5 = icon5.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jButton12.setIcon(new ImageIcon(image5));

        this.networkString = account.getNetwork();

        if (business.getNetworkList() == null) {
            this.network = new HashMap<String, Enterprise>();
        } else {
            this.network = business.getNetworkList();
        }

        this.enterprise = business.findEnterpriseByNetwork(account.getNetwork());
        disableRadioButtons();

        this.ticket = new Ticket();
        this.totalCost = 0;
        this.reservationCost = 0;
        this.foodItems = new ArrayList<>();
        this.business = business;
        this.flags = new FlagClass();
        restRadioButtons();
        cmbTiers.setVisible(false);

        if (business.getEventDirectory() == null) {
            this.eventDirectory = new EventDirectory();
        } else {
            this.eventDirectory = business.getEventDirectory();
        }

        if (enterprise.getCustomerDirectory() == null) {
            this.customerDirectory = new CustomerDirectory();
        } else {
            this.customerDirectory = enterprise.getCustomerDirectory();
        }

        if (enterprise.getSuitesDirectory() == null) {
            this.suitedDirectory = new SuitesDirectory();
        } else {
            this.suitedDirectory = enterprise.getSuitesDirectory();
        }

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

        if (enterprise.getMerchandiseShopDirectory() == null) {
            this.merchDirectory = new merchandiseShopDirectory();
        } else {
            this.merchDirectory = enterprise.getMerchandiseShopDirectory();
        }

        if (enterprise.getPdDirectory() == null) {
            this.pdDirectory = new PickandDropDirectory();
        } else {
            this.pdDirectory = enterprise.getPdDirectory();
        }

        customer = customerDirectory.findCustomer(account.getUsername());

        if (customer != null) {
            txtName1.setText(customer.getFullName());
            txtUsername.setText(customer.getUserName());
            txtMobileNo.setText(customer.getPhoneNumber());
            txtAddress1.setText(customer.getAddress());
            populateBooking();
        }

        JTableHeader tableHeader = tblEvents.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) tableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader tableHeader1 = tblFoodBev1.getTableHeader();
        tableHeader1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) tableHeader1.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader tableHeader2 = tblBookings.getTableHeader();
        tableHeader2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) tableHeader1.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTableHeader tableHeader3 = tblMerchandise.getTableHeader();
        tableHeader3.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) tableHeader3.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
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
        jTextArea1 = new javax.swing.JTextArea();
        jSplitPane1 = new javax.swing.JSplitPane();
        NavigationJPanel = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        btnEditDetails = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        customerProfilePanel = new javax.swing.JPanel();
        pnlFeedbackTable = new javax.swing.JPanel();
        txtMobileNo = new javax.swing.JTextField();
        txtAddress1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        viewBookings = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBookings = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        selecSeatType = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        parkingDetails = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPickupLocation = new javax.swing.JTextField();
        chkReturntrip = new javax.swing.JCheckBox();
        btnSubmit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPickup = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        orderFood = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        securityService = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        merchandize = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblMerchandise = new javax.swing.JTable();
        btnBuy = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        techService = new javax.swing.JPanel();
        registerEvent = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        bookEventDetails = new javax.swing.JPanel();
        lblEventName = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtTicketCount = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        lstSeatType1 = new javax.swing.JList<>();
        btnSelectSeatType1 = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        tblFoodBev1 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        btnBookTicket = new javax.swing.JButton();
        btnConfirmSeats = new javax.swing.JButton();
        btnConfirmSeats1 = new javax.swing.JButton();
        btnTier = new javax.swing.JButton();
        cmbTiers = new javax.swing.JComboBox<>();
        OrderPanel = new javax.swing.JPanel();
        lblHeader1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        lblApetizers1 = new javax.swing.JLabel();
        lblAptVeg1 = new javax.swing.JLabel();
        lblAptNonVeg1 = new javax.swing.JLabel();
        lblAptVegan1 = new javax.swing.JLabel();
        rdOnionRings1 = new javax.swing.JRadioButton();
        rdSpinachPie1 = new javax.swing.JRadioButton();
        rdSpringRoles1 = new javax.swing.JRadioButton();
        rdMeatBalls1 = new javax.swing.JRadioButton();
        rdSausageDip1 = new javax.swing.JRadioButton();
        rdFriedShrimp1 = new javax.swing.JRadioButton();
        rdWhiteBeanDip1 = new javax.swing.JRadioButton();
        rdTortillaChips1 = new javax.swing.JRadioButton();
        rdCrispyTofu1 = new javax.swing.JRadioButton();
        lblMains1 = new javax.swing.JLabel();
        lblMainsVeg1 = new javax.swing.JLabel();
        rdCheeseBurger1 = new javax.swing.JRadioButton();
        rdFriedRice1 = new javax.swing.JRadioButton();
        rdVeggiePizza1 = new javax.swing.JRadioButton();
        rdHamBurger1 = new javax.swing.JRadioButton();
        rdFishNChips1 = new javax.swing.JRadioButton();
        rdPrawnFriedRice1 = new javax.swing.JRadioButton();
        rdTofuSalad1 = new javax.swing.JRadioButton();
        rdFalafelBowl1 = new javax.swing.JRadioButton();
        rdTofuAndRiceBowl1 = new javax.swing.JRadioButton();
        lblMainsNonVeg1 = new javax.swing.JLabel();
        lblAptVegan2 = new javax.swing.JLabel();
        lblDesserts1 = new javax.swing.JLabel();
        rdBlackForestCake1 = new javax.swing.JRadioButton();
        rdPineappleSwissRole1 = new javax.swing.JRadioButton();
        rdChocolateMousse1 = new javax.swing.JRadioButton();
        lbBeverages1 = new javax.swing.JLabel();
        rdCocaCola1 = new javax.swing.JRadioButton();
        rdFreshLimesalted1 = new javax.swing.JRadioButton();
        rdPepsi1 = new javax.swing.JRadioButton();
        lblOnionRingsPrice = new javax.swing.JLabel();
        lblSpinachPiePrice = new javax.swing.JLabel();
        lblSpringRolesPrice = new javax.swing.JLabel();
        lblMeatBallsPrice = new javax.swing.JLabel();
        lblsausageDipPrice = new javax.swing.JLabel();
        lblFriedShrimpPrice = new javax.swing.JLabel();
        lblWhiteBeanDipPrice = new javax.swing.JLabel();
        lblTortillaChipsPrice = new javax.swing.JLabel();
        lblCrispyTofuPrice = new javax.swing.JLabel();
        lblCheeseBurgerPrice = new javax.swing.JLabel();
        lblFriedRicePrice = new javax.swing.JLabel();
        lblVeggiePrice = new javax.swing.JLabel();
        lblHamburgerPrice = new javax.swing.JLabel();
        lblFishNChipsPrice = new javax.swing.JLabel();
        lblPrawnFriedRicePrice = new javax.swing.JLabel();
        lblTofuSaladPrice = new javax.swing.JLabel();
        lblFalafelBowlPrice = new javax.swing.JLabel();
        lblTofuRiceBowlPrice = new javax.swing.JLabel();
        lblBlackForestCakePrice = new javax.swing.JLabel();
        lblPineappleSwissRolePrice = new javax.swing.JLabel();
        lblChocolateMoussePrice = new javax.swing.JLabel();
        lblCocaColaPrice = new javax.swing.JLabel();
        lblFreshLimeSaltedPrice = new javax.swing.JLabel();
        lblPepsiPrice = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();
        SeatingPanel = new javax.swing.JPanel();
        lblHeader4 = new javax.swing.JLabel();
        btnBack6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
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
        btnBookSeats = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        NavigationJPanel.setBackground(new java.awt.Color(0, 51, 51));

        btnMenu.setBackground(new java.awt.Color(206, 217, 217));
        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(0, 51, 51));
        btnMenu.setText("REGISTER");
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

        btnEditDetails.setBackground(new java.awt.Color(206, 217, 217));
        btnEditDetails.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditDetails.setForeground(new java.awt.Color(0, 51, 51));
        btnEditDetails.setText("VIEW PROFILE");
        btnEditDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditDetailsMouseExited(evt);
            }
        });
        btnEditDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDetailsActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(206, 217, 217));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 51));
        jButton2.setText("BOOKINGS");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(206, 217, 217));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 51));
        jButton7.setText("STORE");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(206, 217, 217));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 51, 51));
        jButton12.setText("PICK & DROP");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationJPanelLayout = new javax.swing.GroupLayout(NavigationJPanel);
        NavigationJPanel.setLayout(NavigationJPanelLayout);
        NavigationJPanelLayout.setHorizontalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(NavigationJPanelLayout.createSequentialGroup()
                        .addGroup(NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        NavigationJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditDetails, btnMenu, jButton2, jButton7});

        NavigationJPanelLayout.setVerticalGroup(
            NavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnEditDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );

        NavigationJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEditDetails, btnMenu, jButton12, jButton2, jButton7});

        jSplitPane1.setLeftComponent(NavigationJPanel);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        customerProfilePanel.setBackground(new java.awt.Color(240, 255, 255));

        pnlFeedbackTable.setBackground(new java.awt.Color(240, 255, 255));

        javax.swing.GroupLayout pnlFeedbackTableLayout = new javax.swing.GroupLayout(pnlFeedbackTable);
        pnlFeedbackTable.setLayout(pnlFeedbackTableLayout);
        pnlFeedbackTableLayout.setHorizontalGroup(
            pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        pnlFeedbackTableLayout.setVerticalGroup(
            pnlFeedbackTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        txtMobileNo.setEditable(false);
        txtMobileNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtAddress1.setEditable(false);
        txtAddress1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("YOUR PROFILE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("NAME : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("USERNAME : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("MOBILE NO. : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("ADDRESS : ");

        txtName1.setEditable(false);
        txtName1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName1ActionPerformed(evt);
            }
        });

        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewprofile.gif"))); // NOI18N

        javax.swing.GroupLayout customerProfilePanelLayout = new javax.swing.GroupLayout(customerProfilePanel);
        customerProfilePanel.setLayout(customerProfilePanelLayout);
        customerProfilePanelLayout.setHorizontalGroup(
            customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerProfilePanelLayout.createSequentialGroup()
                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerProfilePanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFeedbackTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerProfilePanelLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerProfilePanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customerProfilePanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customerProfilePanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(customerProfilePanelLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerProfilePanelLayout.setVerticalGroup(
            customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerProfilePanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(customerProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerProfilePanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(pnlFeedbackTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerProfilePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jLayeredPane1.add(customerProfilePanel, "card2");

        viewBookings.setBackground(new java.awt.Color(240, 255, 255));

        jPanel1.setBackground(new java.awt.Color(240, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("VIEW YOUR BOOKINGS");

        tblBookings.setBackground(new java.awt.Color(255, 255, 255));
        tblBookings.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BOOKING ID", "EVENT NAME", "NO. OF TICKETS", "SEAT TYPE", "TOTAL COST"
            }
        ));
        tblBookings.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblBookings.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane5.setViewportView(tblBookings);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/booking.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout viewBookingsLayout = new javax.swing.GroupLayout(viewBookings);
        viewBookings.setLayout(viewBookingsLayout);
        viewBookingsLayout.setHorizontalGroup(
            viewBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        viewBookingsLayout.setVerticalGroup(
            viewBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLayeredPane1.add(viewBookings, "card5");

        jLabel17.setText("SELECT SEAT TYPE");

        jLabel18.setText("SEAT TYPE");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "CONCESSION TYPE", "PREMIUM TYPE", "SUIT TYPE", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList2);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sr no", "SEAT NO", "PRICE"
            }
        ));
        jScrollPane10.setViewportView(jTable6);

        jButton11.setText("jButton11");

        javax.swing.GroupLayout selecSeatTypeLayout = new javax.swing.GroupLayout(selecSeatType);
        selecSeatType.setLayout(selecSeatTypeLayout);
        selecSeatTypeLayout.setHorizontalGroup(
            selecSeatTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selecSeatTypeLayout.createSequentialGroup()
                .addGroup(selecSeatTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selecSeatTypeLayout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel13))
                    .addGroup(selecSeatTypeLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel17))
                    .addGroup(selecSeatTypeLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel18)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selecSeatTypeLayout.createSequentialGroup()
                .addGap(0, 577, Short.MAX_VALUE)
                .addGroup(selecSeatTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selecSeatTypeLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selecSeatTypeLayout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(300, 300, 300))))
        );
        selecSeatTypeLayout.setVerticalGroup(
            selecSeatTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selecSeatTypeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(47, 47, 47)
                .addGroup(selecSeatTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton11)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jLayeredPane1.add(selecSeatType, "card7");

        parkingDetails.setBackground(new java.awt.Color(240, 255, 255));

        jButton8.setBackground(new java.awt.Color(204, 255, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 0));
        jButton8.setText("BOOK");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Pickup location : ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Return trip ? ");

        txtPickupLocation.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnSubmit.setBackground(new java.awt.Color(0, 204, 204));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(0, 51, 51));
        btnSubmit.setText("REQUEST RIDE");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        tblPickup.setBackground(new java.awt.Color(255, 255, 255));
        tblPickup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPickup.setForeground(new java.awt.Color(0, 51, 51));
        tblPickup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Pickup Point", "Car Number", "Two Way", "Status", "Price"
            }
        ));
        tblPickup.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblPickup.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane3.setViewportView(tblPickup);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 153));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("PICK & DROP!");

        jLabel24.setText("jLabel24");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pickdrop.gif"))); // NOI18N

        javax.swing.GroupLayout parkingDetailsLayout = new javax.swing.GroupLayout(parkingDetails);
        parkingDetails.setLayout(parkingDetailsLayout);
        parkingDetailsLayout.setHorizontalGroup(
            parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parkingDetailsLayout.createSequentialGroup()
                .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parkingDetailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(parkingDetailsLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(parkingDetailsLayout.createSequentialGroup()
                                .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkReturntrip)
                                    .addComponent(txtPickupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(parkingDetailsLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jButton8)))
                .addContainerGap(546, Short.MAX_VALUE))
        );
        parkingDetailsLayout.setVerticalGroup(
            parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parkingDetailsLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(parkingDetailsLayout.createSequentialGroup()
                        .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPickupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(parkingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(chkReturntrip))
                        .addGap(90, 90, 90)
                        .addComponent(btnSubmit))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPane1.add(parkingDetails, "card5");

        orderFood.setBackground(new java.awt.Color(240, 255, 255));

        jLabel15.setText("ORDER FOOD");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sr No", "Event Name", "Date", "Title 4", "Number of tickets"
            }
        ));
        jScrollPane7.setViewportView(jTable3);

        jLabel16.setText("PLEASE SELECT THE EVENT TO ORDER FOOD FOR");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable5);

        jLabel19.setText("SELECT RESTAURANT");

        jLabel20.setText("SELECT FROM MENU");

        jButton9.setText("ORDER NOW");

        jButton10.setText("VIEW  ORDER HISTORY");

        javax.swing.GroupLayout orderFoodLayout = new javax.swing.GroupLayout(orderFood);
        orderFood.setLayout(orderFoodLayout);
        orderFoodLayout.setHorizontalGroup(
            orderFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderFoodLayout.createSequentialGroup()
                .addGroup(orderFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderFoodLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(orderFoodLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addGroup(orderFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(orderFoodLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(orderFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9)))
                    .addGroup(orderFoodLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jButton9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(orderFoodLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 539, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(104, 104, 104))
        );
        orderFoodLayout.setVerticalGroup(
            orderFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderFoodLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(orderFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton9)
                .addGap(159, 159, 159))
        );

        jLayeredPane1.add(orderFood, "card6");

        jLabel25.setText("PLEASE SELECT THE EVENT TO ORDER SECURITY SERVICE FOR");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(jTable9);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(jTable10);

        jLabel26.setText("SELECT SECURITY TYPE");

        jLabel27.setText("SELECT FROM MENU");

        jButton13.setText("VIEW  SECURITY HISTORY");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sr No", "Event Name", "Date", "Title 4", "Number of tickets"
            }
        ));
        jScrollPane16.setViewportView(jTable11);

        javax.swing.GroupLayout securityServiceLayout = new javax.swing.GroupLayout(securityService);
        securityService.setLayout(securityServiceLayout);
        securityServiceLayout.setHorizontalGroup(
            securityServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityServiceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addGap(88, 88, 88))
            .addGroup(securityServiceLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(securityServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(securityServiceLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(securityServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane14)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(securityServiceLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel25)))
                .addGap(142, 142, 142))
            .addGroup(securityServiceLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        securityServiceLayout.setVerticalGroup(
            securityServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityServiceLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );

        jLayeredPane1.add(securityService, "card8");

        merchandize.setBackground(new java.awt.Color(240, 255, 255));

        jButton15.setText("BUY NOW");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 153));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("DIEGO MERCH");

        tblMerchandise.setBackground(new java.awt.Color(255, 255, 255));
        tblMerchandise.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblMerchandise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ITEM NAME", "COST"
            }
        ));
        tblMerchandise.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblMerchandise.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane22.setViewportView(tblMerchandise);

        btnBuy.setBackground(new java.awt.Color(204, 255, 204));
        btnBuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(0, 102, 102));
        btnBuy.setText("BUY!");
        btnBuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/store111.gif"))); // NOI18N

        javax.swing.GroupLayout merchandizeLayout = new javax.swing.GroupLayout(merchandize);
        merchandize.setLayout(merchandizeLayout);
        merchandizeLayout.setHorizontalGroup(
            merchandizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, merchandizeLayout.createSequentialGroup()
                .addGap(0, 758, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addGap(298, 298, 298))
            .addGroup(merchandizeLayout.createSequentialGroup()
                .addGroup(merchandizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(merchandizeLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(merchandizeLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(merchandizeLayout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnBuy))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        merchandizeLayout.setVerticalGroup(
            merchandizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(merchandizeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel30)
                .addGap(72, 72, 72)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addGap(55, 55, 55))
        );

        jLayeredPane1.add(merchandize, "card9");

        javax.swing.GroupLayout techServiceLayout = new javax.swing.GroupLayout(techService);
        techService.setLayout(techServiceLayout);
        techServiceLayout.setHorizontalGroup(
            techServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        techServiceLayout.setVerticalGroup(
            techServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        jLayeredPane1.add(techService, "card10");

        registerEvent.setBackground(new java.awt.Color(240, 255, 255));

        jScrollPane20.setBackground(new java.awt.Color(240, 255, 255));

        jPanel2.setBackground(new java.awt.Color(240, 255, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 153, 153));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("EVENTS AT DIEGO STADIUM");

        tblEvents.setBackground(new java.awt.Color(255, 255, 255));
        tblEvents.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Event Name", "Date", "Type of Event", "Available Seats"
            }
        ));
        tblEvents.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblEvents.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane21.setViewportView(tblEvents);
        if (tblEvents.getColumnModel().getColumnCount() > 0) {
            tblEvents.getColumnModel().getColumn(2).setHeaderValue("Type of Event");
            tblEvents.getColumnModel().getColumn(3).setHeaderValue("Available Seats");
        }

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("PICK AN EVENT");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eventPage.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel29)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jScrollPane20.setViewportView(jPanel2);

        javax.swing.GroupLayout registerEventLayout = new javax.swing.GroupLayout(registerEvent);
        registerEvent.setLayout(registerEventLayout);
        registerEventLayout.setHorizontalGroup(
            registerEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20)
        );
        registerEventLayout.setVerticalGroup(
            registerEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20)
        );

        jLayeredPane1.add(registerEvent, "card11");

        bookEventDetails.setBackground(new java.awt.Color(240, 255, 255));

        lblEventName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEventName.setForeground(new java.awt.Color(0, 153, 153));
        lblEventName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEventName.setText("<<EVENT NAME>>");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 51));
        jLabel38.setText("How many tickets would you like ?");

        txtTicketCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTicketCountActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 51, 51));
        jLabel39.setText("Book the type of seats you prefer");

        lstSeatType1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lstSeatType1.setForeground(new java.awt.Color(0, 51, 51));
        lstSeatType1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "PREMIUM TYPE", "SUITE TYPE", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstSeatType1.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jScrollPane24.setViewportView(lstSeatType1);

        btnSelectSeatType1.setBackground(new java.awt.Color(204, 255, 204));
        btnSelectSeatType1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectSeatType1.setForeground(new java.awt.Color(0, 51, 51));
        btnSelectSeatType1.setText("SELECT");
        btnSelectSeatType1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelectSeatType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectSeatType1ActionPerformed(evt);
            }
        });

        tblFoodBev1.setBackground(new java.awt.Color(255, 255, 255));
        tblFoodBev1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblFoodBev1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NAME", "COST PER TABLE"
            }
        ));
        tblFoodBev1.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblFoodBev1.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane25.setViewportView(tblFoodBev1);

        jButton18.setBackground(new java.awt.Color(0, 0, 0));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("View Menu");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(0, 0, 0));
        jButton19.setText("Reserve Seats");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        btnBookTicket.setBackground(new java.awt.Color(255, 255, 255));
        btnBookTicket.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBookTicket.setForeground(new java.awt.Color(0, 153, 153));
        btnBookTicket.setText("BOOK");
        btnBookTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookTicketActionPerformed(evt);
            }
        });

        btnConfirmSeats.setBackground(new java.awt.Color(204, 255, 204));
        btnConfirmSeats.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmSeats.setForeground(new java.awt.Color(0, 51, 51));
        btnConfirmSeats.setText("SELECT");
        btnConfirmSeats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmSeatsActionPerformed(evt);
            }
        });

        btnConfirmSeats1.setBackground(new java.awt.Color(255, 204, 204));
        btnConfirmSeats1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmSeats1.setForeground(new java.awt.Color(255, 0, 51));
        btnConfirmSeats1.setText("BACK");
        btnConfirmSeats1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmSeats1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmSeats1ActionPerformed(evt);
            }
        });

        btnTier.setBackground(new java.awt.Color(255, 255, 255));
        btnTier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTier.setForeground(new java.awt.Color(0, 0, 0));
        btnTier.setText("Pick Tier");
        btnTier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookEventDetailsLayout = new javax.swing.GroupLayout(bookEventDetails);
        bookEventDetails.setLayout(bookEventDetailsLayout);
        bookEventDetailsLayout.setHorizontalGroup(
            bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookEventDetailsLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel39)
                        .addGroup(bookEventDetailsLayout.createSequentialGroup()
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSelectSeatType1)))
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bookEventDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTicketCount, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConfirmSeats)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
                .addComponent(btnConfirmSeats1)
                .addGap(101, 101, 101))
            .addGroup(bookEventDetailsLayout.createSequentialGroup()
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(btnBookTicket))
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bookEventDetailsLayout.createSequentialGroup()
                                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTiers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bookEventDetailsLayout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTier, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bookEventDetailsLayout.setVerticalGroup(
            bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookEventDetailsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmSeats1)
                    .addComponent(lblEventName))
                .addGap(53, 53, 53)
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTicketCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(btnConfirmSeats))
                .addGap(63, 63, 63)
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnSelectSeatType1)))
                .addGap(87, 87, 87)
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(btnTier))
                .addGroup(bookEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookEventDetailsLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(cmbTiers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(btnBookTicket)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        jLayeredPane1.add(bookEventDetails, "card11");

        OrderPanel.setBackground(new java.awt.Color(240, 255, 255));

        lblHeader1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader1.setForeground(new java.awt.Color(0, 153, 153));
        lblHeader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader1.setText("<Place your order at xyz>");

        btnBack1.setBackground(new java.awt.Color(255, 204, 204));
        btnBack1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 0, 51));
        btnBack1.setText("BACK");
        btnBack1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(240, 255, 255));

        lblApetizers1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApetizers1.setForeground(new java.awt.Color(0, 204, 204));
        lblApetizers1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApetizers1.setText("APPETIZERS");

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

        rdFalafelBowl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFalafelBowl1.setForeground(new java.awt.Color(0, 0, 0));
        rdFalafelBowl1.setText("Falafel Bowl");

        rdTofuAndRiceBowl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdTofuAndRiceBowl1.setForeground(new java.awt.Color(0, 0, 0));
        rdTofuAndRiceBowl1.setText("Tofu & Rice platter");

        lblMainsNonVeg1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMainsNonVeg1.setForeground(new java.awt.Color(0, 102, 102));
        lblMainsNonVeg1.setText("NON-VEG");

        lblAptVegan2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAptVegan2.setForeground(new java.awt.Color(0, 102, 102));
        lblAptVegan2.setText("VEGAN");

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

        lblOnionRingsPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOnionRingsPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblOnionRingsPrice.setText("- NA -");

        lblSpinachPiePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSpinachPiePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblSpinachPiePrice.setText("- NA -");

        lblSpringRolesPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSpringRolesPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblSpringRolesPrice.setText("- NA -");

        lblMeatBallsPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMeatBallsPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblMeatBallsPrice.setText("- NA -");

        lblsausageDipPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblsausageDipPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblsausageDipPrice.setText("- NA -");

        lblFriedShrimpPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFriedShrimpPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblFriedShrimpPrice.setText("- NA -");

        lblWhiteBeanDipPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblWhiteBeanDipPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblWhiteBeanDipPrice.setText("- NA -");

        lblTortillaChipsPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTortillaChipsPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblTortillaChipsPrice.setText("- NA -");

        lblCrispyTofuPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCrispyTofuPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblCrispyTofuPrice.setText("- NA -");

        lblCheeseBurgerPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCheeseBurgerPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblCheeseBurgerPrice.setText("- NA -");

        lblFriedRicePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFriedRicePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblFriedRicePrice.setText("- NA -");

        lblVeggiePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblVeggiePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblVeggiePrice.setText("- NA -");

        lblHamburgerPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHamburgerPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblHamburgerPrice.setText("- NA -");

        lblFishNChipsPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFishNChipsPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblFishNChipsPrice.setText("- NA -");

        lblPrawnFriedRicePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrawnFriedRicePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblPrawnFriedRicePrice.setText("- NA -");

        lblTofuSaladPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTofuSaladPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblTofuSaladPrice.setText("- NA -");

        lblFalafelBowlPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFalafelBowlPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblFalafelBowlPrice.setText("- NA -");

        lblTofuRiceBowlPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTofuRiceBowlPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblTofuRiceBowlPrice.setText("- NA -");

        lblBlackForestCakePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBlackForestCakePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblBlackForestCakePrice.setText("- NA -");

        lblPineappleSwissRolePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPineappleSwissRolePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblPineappleSwissRolePrice.setText("- NA -");

        lblChocolateMoussePrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblChocolateMoussePrice.setForeground(new java.awt.Color(0, 102, 102));
        lblChocolateMoussePrice.setText("- NA -");

        lblCocaColaPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCocaColaPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblCocaColaPrice.setText("- NA -");

        lblFreshLimeSaltedPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFreshLimeSaltedPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblFreshLimeSaltedPrice.setText("- NA -");

        lblPepsiPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPepsiPrice.setForeground(new java.awt.Color(0, 102, 102));
        lblPepsiPrice.setText("- NA -");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdOnionRings1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblOnionRingsPrice))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdSpinachPie1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblSpinachPiePrice))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdSpringRoles1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblSpringRolesPrice)))
                                            .addGap(81, 81, 81)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdMeatBalls1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblMeatBallsPrice))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdSausageDip1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblsausageDipPrice))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdFriedShrimp1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblFriedShrimpPrice)))
                                            .addGap(63, 63, 63))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(lblMainsNonVeg1)
                                            .addGap(131, 131, 131)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdWhiteBeanDip1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblWhiteBeanDipPrice))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdCrispyTofu1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblCrispyTofuPrice))
                                        .addComponent(lblAptVegan2)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdTortillaChips1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblTortillaChipsPrice))))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addComponent(lblMainsVeg1)
                                            .addGap(151, 151, 151)
                                            .addComponent(lblMains1))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdCheeseBurger1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblCheeseBurgerPrice))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdFriedRice1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblFriedRicePrice))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdVeggiePizza1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblVeggiePrice)))
                                    .addGap(111, 111, 111)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdTofuSalad1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblTofuSaladPrice))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdFalafelBowl1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblFalafelBowlPrice))))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdTofuAndRiceBowl1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblTofuRiceBowlPrice))))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdBlackForestCake1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblBlackForestCakePrice))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdPineappleSwissRole1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblPineappleSwissRolePrice))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdChocolateMousse1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblChocolateMoussePrice)))
                                    .addGap(59, 59, 59)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(lbBeverages1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdPepsi1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblPepsiPrice))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdCocaCola1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblCocaColaPrice))
                                                .addComponent(rdFreshLimesalted1))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblFreshLimeSaltedPrice)
                                            .addGap(3, 3, 3)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdPrawnFriedRice1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPrawnFriedRicePrice))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdHamBurger1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblHamburgerPrice))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdFishNChips1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFishNChipsPrice))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblApetizers1)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblAptVeg1)
                                        .addGap(188, 188, 188)
                                        .addComponent(lblAptNonVeg1)))
                                .addGap(140, 140, 140)
                                .addComponent(lblAptVegan1))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblDesserts1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblApetizers1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAptVeg1)
                    .addComponent(lblAptNonVeg1)
                    .addComponent(lblAptVegan1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdOnionRings1)
                            .addComponent(lblOnionRingsPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdSpinachPie1)
                            .addComponent(lblSpinachPiePrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdSpringRoles1)
                            .addComponent(lblSpringRolesPrice)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdMeatBalls1)
                            .addComponent(lblMeatBallsPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdSausageDip1)
                            .addComponent(lblsausageDipPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFriedShrimp1)
                            .addComponent(lblFriedShrimpPrice)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdWhiteBeanDip1)
                            .addComponent(lblWhiteBeanDipPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdTortillaChips1)
                            .addComponent(lblTortillaChipsPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdCrispyTofu1)
                            .addComponent(lblCrispyTofuPrice))))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblMains1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMainsVeg1)
                            .addComponent(lblMainsNonVeg1)
                            .addComponent(lblAptVegan2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdCheeseBurger1)
                                    .addComponent(lblCheeseBurgerPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdFriedRice1)
                                    .addComponent(lblFriedRicePrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdVeggiePizza1)
                                    .addComponent(lblVeggiePrice)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdHamBurger1)
                                    .addComponent(lblHamburgerPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdFishNChips1)
                                    .addComponent(lblFishNChipsPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdPrawnFriedRice1)
                                    .addComponent(lblPrawnFriedRicePrice)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdTofuSalad1)
                                    .addComponent(lblTofuSaladPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdFalafelBowl1)
                                    .addComponent(lblFalafelBowlPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdTofuAndRiceBowl1)
                                    .addComponent(lblTofuRiceBowlPrice))))
                        .addGap(36, 36, 36)
                        .addComponent(lblDesserts1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdBlackForestCake1)
                            .addComponent(lblBlackForestCakePrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdPineappleSwissRole1)
                            .addComponent(lblPineappleSwissRolePrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdChocolateMousse1)
                            .addComponent(lblChocolateMoussePrice)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbBeverages1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdCocaCola1)
                            .addComponent(lblCocaColaPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdFreshLimesalted1)
                            .addComponent(lblFreshLimeSaltedPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdPepsi1)
                            .addComponent(lblPepsiPrice))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jScrollPane11.setViewportView(jPanel4);

        btnOrder.setBackground(new java.awt.Color(215, 254, 211));
        btnOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(72, 151, 64));
        btnOrder.setText("ORDER!");
        btnOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OrderPanelLayout = new javax.swing.GroupLayout(OrderPanel);
        OrderPanel.setLayout(OrderPanelLayout);
        OrderPanelLayout.setHorizontalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderPanelLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(lblHeader1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnBack1)
                    .addComponent(btnOrder))
                .addGap(50, 50, 50))
        );
        OrderPanelLayout.setVerticalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnBack1)
                .addGap(12, 12, 12)
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader1)
                    .addComponent(btnOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(OrderPanel, "card4");

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

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("T1");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("T4");
        jLabel9.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(0, 102, 102));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("T2");
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(0, 102, 102));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("T5");
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(0, 102, 102));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("T7");
        jLabel23.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(0, 102, 102));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("T6");
        jLabel32.setOpaque(true);

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

        btnBookSeats.setBackground(new java.awt.Color(215, 254, 211));
        btnBookSeats.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBookSeats.setForeground(new java.awt.Color(72, 151, 64));
        btnBookSeats.setText("BOOK");
        btnBookSeats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookSeatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookSeatsMouseExited(evt);
            }
        });
        btnBookSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookSeatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeatingPanelLayout = new javax.swing.GroupLayout(SeatingPanel);
        SeatingPanel.setLayout(SeatingPanelLayout);
        SeatingPanelLayout.setHorizontalGroup(
            SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeatingPanelLayout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdT1C1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdT1C2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdT4C1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdT4C2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdT1C5)
                                    .addComponent(rdT1C6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdT2C1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdT2C2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addComponent(rdT4C7)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdT4C8))
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdT4C5)
                                            .addComponent(rdT4C6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdT5C1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rdT5C2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT1C3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT1C4))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT1C7)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT1C8))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT4C3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT4C4)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createSequentialGroup()
                                    .addComponent(lblHeader4)
                                    .addGap(213, 213, 213)
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnBack6)
                                        .addComponent(btnBookSeats))
                                    .addGap(46, 46, 46))
                                .addGroup(SeatingPanelLayout.createSequentialGroup()
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(SeatingPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdT5C5)
                                                .addComponent(rdT5C6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdT6C1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(rdT6C2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(SeatingPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdT2C5)
                                                .addComponent(rdT2C6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdT3C1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(rdT3C2, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(SeatingPanelLayout.createSequentialGroup()
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                    .addComponent(rdT3C3)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rdT3C4)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdT3C5)
                                                .addComponent(rdT3C6)))
                                        .addGroup(SeatingPanelLayout.createSequentialGroup()
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                        .addComponent(rdT3C7)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rdT3C8))
                                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                        .addComponent(rdT6C3)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rdT6C4))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdT6C5)
                                                .addComponent(rdT6C6)))
                                        .addGroup(SeatingPanelLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(rdT6C7)
                                            .addGap(18, 18, 18)
                                            .addComponent(rdT6C8)))
                                    .addContainerGap()))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT5C3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT5C4))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(rdT2C7)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT2C8))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT2C3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT2C4))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT5C7)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT5C8)))
                                .addGap(319, 319, 319))))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
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
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdT7C5)
                                    .addComponent(rdT7C6)))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addComponent(rdT7C7)
                                .addGap(18, 18, 18)
                                .addComponent(rdT7C8)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        SeatingPanelLayout.setVerticalGroup(
            SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeatingPanelLayout.createSequentialGroup()
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lblHeader4)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT1C3)
                                            .addComponent(rdT1C4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rdT2C3)
                                                .addComponent(rdT2C4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createSequentialGroup()
                                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(rdT3C3)
                                                    .addComponent(rdT3C4))
                                                .addGap(8, 8, 8))))))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnBack6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBookSeats)
                                .addGap(86, 86, 86)))
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(SeatingPanelLayout.createSequentialGroup()
                                    .addComponent(rdT2C1)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdT2C2))
                                .addGroup(SeatingPanelLayout.createSequentialGroup()
                                    .addComponent(rdT1C5)
                                    .addGap(27, 27, 27)
                                    .addComponent(rdT1C6)))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT3C1)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT3C2))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT2C5)
                                        .addGap(27, 27, 27)
                                        .addComponent(rdT2C6))))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(rdT3C5)
                                .addGap(27, 27, 27)
                                .addComponent(rdT3C6))))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(rdT1C1)
                        .addGap(18, 18, 18)
                        .addComponent(rdT1C2)))
                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT4C3)
                                            .addComponent(rdT4C4)))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT3C7)
                                            .addComponent(rdT3C8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT5C3)
                                            .addComponent(rdT5C4)
                                            .addComponent(rdT6C3)
                                            .addComponent(rdT6C4))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT4C5)
                                        .addGap(27, 27, 27)
                                        .addComponent(rdT4C6))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addComponent(rdT5C1)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdT5C2)))))
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdT4C7)
                                        .addComponent(rdT4C8))
                                    .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdT5C7)
                                        .addComponent(rdT5C8))))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdT6C7)
                                    .addComponent(rdT6C8))))
                        .addGap(73, 210, Short.MAX_VALUE))
                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdT1C7)
                                .addComponent(rdT1C8))
                            .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdT2C7)
                                .addComponent(rdT2C8)))
                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(rdT4C1)
                                .addGap(18, 18, 18)
                                .addComponent(rdT4C2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addComponent(rdT5C5)
                                                .addGap(27, 27, 27)
                                                .addComponent(rdT5C6))
                                            .addGroup(SeatingPanelLayout.createSequentialGroup()
                                                .addComponent(rdT6C1)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdT6C2))))
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(rdT6C5)
                                        .addGap(27, 27, 27)
                                        .addComponent(rdT6C6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SeatingPanelLayout.createSequentialGroup()
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdT7C3)
                                            .addComponent(rdT7C4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SeatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeatingPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addGap(40, 40, 40)))
                                .addGap(50, 50, 50))))))
        );

        jLayeredPane1.add(SeatingPanel, "card7");

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
        btnMenu.setBackground(new Color(112, 143, 143));
    }//GEN-LAST:event_btnMenuMouseEntered

    private void btnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseExited
        btnMenu.setBackground(new Color(206, 217, 217));
    }//GEN-LAST:event_btnMenuMouseExited

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        BasicConfigurator.configure();
        logger.info("Registering for an event");
        switchPanels(registerEvent);
        populateEventTable();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnEditDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditDetailsMouseEntered
        btnEditDetails.setBackground(new Color(112, 143, 143));
    }//GEN-LAST:event_btnEditDetailsMouseEntered

    private void btnEditDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditDetailsMouseExited
        btnEditDetails.setBackground(new Color(206, 217, 217));
    }//GEN-LAST:event_btnEditDetailsMouseExited

    private void btnEditDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDetailsActionPerformed
        switchPanels(registerEvent);
    }//GEN-LAST:event_btnEditDetailsActionPerformed

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BasicConfigurator.configure();
        logger.info("Viewing all previous bookings");
        switchPanels(viewBookings);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int selectedRowIndex = tblPickup.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a booking!");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblPickup.getModel();
            CarBooking booking = (CarBooking) model.getValueAt(selectedRowIndex, 0);

            if (!booking.getStatus().equals("On the Way")) {
                JOptionPane.showMessageDialog(this, "Booking not yet approved!");
                return;
            } else {
                logger.info("Logged in as Customer.");
                switchPanels(bookEventDetails);

                if (customer.getPickDropCost() == 0) {
                    customer.setPickDropCost(booking.getPrice());
                } else {
                    customer.setPickDropCost(customer.getPickDropCost() + booking.getPrice());
                }

                JOptionPane.showMessageDialog(this, "Ride booked successfully!");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (merchDirectory != null && merchDirectory.getMerchandiseShopList() != null && !merchDirectory.getMerchandiseShopList().isEmpty()) {
            populateMerchandise();
        }
        BasicConfigurator.configure();
        logger.info("Visting the merchandise store");
        switchPanels(merchandize);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtTicketCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTicketCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTicketCountActionPerformed

    private void btnSelectSeatType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectSeatType1ActionPerformed
        populateFoodBev();
        if (lstSeatType1.getSelectedValue().equals("SUITE TYPE")) {
            btnTier.setEnabled(false);
            if (!jButton19.isEnabled()) {
                jButton19.setEnabled(true);
            }
        } else if (lstSeatType1.getSelectedValue().equals("PREMIUM TYPE")) {
            jButton19.setEnabled(false);
            if (!btnTier.isEnabled()) {
                btnTier.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSelectSeatType1ActionPerformed

    private void btnConfirmSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmSeatsActionPerformed
        flags.setTicketCount(Integer.parseInt(txtTicketCount.getText()));
        JOptionPane.showMessageDialog(this, "Ticket count updated!");
    }//GEN-LAST:event_btnConfirmSeatsActionPerformed

    private void btnConfirmSeats1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmSeats1ActionPerformed
        switchPanels(registerEvent);
    }//GEN-LAST:event_btnConfirmSeats1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRowIndex = tblEvents.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select an event!");
            return;
        } else {
            switchPanels(bookEventDetails);
            DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
            Event currentEvent = (Event) model.getValueAt(selectedRowIndex, 0);
            lblEventName.setText(currentEvent.getEventName());
            flags.setEventName(currentEvent.getEventName());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int selectedRowIndex = tblFoodBev1.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Restaurant");
            return;
        } else {
            switchPanels(OrderPanel);
            DefaultTableModel model = (DefaultTableModel) tblFoodBev1.getModel();
            if (lstSeatType1.getSelectedValue().equals("SUITE TYPE")) {
                Suites selectedSuites = (Suites) model.getValueAt(selectedRowIndex, 0);
                lblHeader1.setText("Place your order at " + selectedSuites.getRestaurantName() + "!");
                suiteName = selectedSuites.getRestaurantName();
                flags.setSuiteName(suiteName);

                if (selectedSuites.getMenu() != null) {
                    if (selectedSuites.getMenu().getApetizers() != null && !selectedSuites.getMenu().getApetizers().isEmpty()) {
                        enableAppetizerRadioButtons(selectedSuites);
                    }

                    if (selectedSuites.getMenu().getMains() != null && !selectedSuites.getMenu().getMains().isEmpty()) {
                        enableMainsRadioButtons(selectedSuites);
                    }

                    if (selectedSuites.getMenu().getDessert() != null && !selectedSuites.getMenu().getDessert().isEmpty()) {
                        enableDessertRadioButtons(selectedSuites);
                    }

                    if (selectedSuites.getMenu().getBeverages() != null && !selectedSuites.getMenu().getBeverages().isEmpty()) {
                        enableBeverageRadioButtons(selectedSuites);
                    }
                }
            } else {
                Premium selectedPremium = (Premium) model.getValueAt(selectedRowIndex, 0);
                lblHeader1.setText("Place your order at " + selectedPremium.getRestaurantName() + "!");
                suiteName = selectedPremium.getRestaurantName();
                flags.setSuiteName(suiteName);

                if (selectedPremium.getMenu() != null) {
                    if (selectedPremium.getMenu().getApetizers() != null && !selectedPremium.getMenu().getApetizers().isEmpty()) {
                        enableAppetizerRadioButtonsPremium(selectedPremium);
                    }

                    if (selectedPremium.getMenu().getMains() != null && !selectedPremium.getMenu().getMains().isEmpty()) {
                        enableMainsRadioButtonsPremium(selectedPremium);
                    }

                    if (selectedPremium.getMenu().getDessert() != null && !selectedPremium.getMenu().getDessert().isEmpty()) {
                        enableDessertRadioButtonsPremium(selectedPremium);
                    }

                    if (selectedPremium.getMenu().getBeverages() != null && !selectedPremium.getMenu().getBeverages().isEmpty()) {
                        enableBeverageRadioButtonsPremium(selectedPremium);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    /**
     * Enable Appetizer buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableAppetizerRadioButtons(Suites selectedRestaurant) {
        for (Map.Entry<String, Integer> appetizerMap : selectedRestaurant.getMenu().getApetizers().entrySet()) {
            if (appetizerMap.getKey().equals("Onion Rings")) {
                rdOnionRings1.setEnabled(true);
                lblOnionRingsPrice.setText("- " + appetizerMap.getValue() + "$");
                lblOnionRingsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Spinach Pie")) {
                rdSpinachPie1.setEnabled(true);
                lblSpinachPiePrice.setText("- " + appetizerMap.getValue() + "$");
                lblSpinachPiePrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Spring Roles")) {
                rdSpringRoles1.setEnabled(true);
                lblSpringRolesPrice.setText("- " + appetizerMap.getValue() + "$");
                lblSpringRolesPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Meat Balls")) {
                rdMeatBalls1.setEnabled(true);
                lblMeatBallsPrice.setText("- " + appetizerMap.getValue() + "$");
                lblMeatBallsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Sausage Dip")) {
                rdSausageDip1.setEnabled(true);
                lblsausageDipPrice.setText("- " + appetizerMap.getValue() + "$");
                lblsausageDipPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Fried Shrimp")) {
                rdFriedShrimp1.setEnabled(true);
                lblFriedShrimpPrice.setText("- " + appetizerMap.getValue() + "$");
                lblFriedShrimpPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("White Bean Dip")) {
                rdWhiteBeanDip1.setEnabled(true);
                lblWhiteBeanDipPrice.setText("- " + appetizerMap.getValue() + "$");
                lblWhiteBeanDipPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Tortilla Chips")) {
                rdTortillaChips1.setEnabled(true);
                lblTortillaChipsPrice.setText("- " + appetizerMap.getValue() + "$");
                lblTortillaChipsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Crispy Tofu")) {
                rdCrispyTofu1.setEnabled(true);
                lblCrispyTofuPrice.setText("- " + appetizerMap.getValue() + "$");
                lblCrispyTofuPrice.setForeground(Color.decode("#fc7703"));
            }
        }
    }

    /**
     * Enable Mains buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableMainsRadioButtons(Suites selectedRestaurant) {
        for (Map.Entry<String, Integer> mainsrMap : selectedRestaurant.getMenu().getMains().entrySet()) {
            if (mainsrMap.getKey().equals("Cheese Burger")) {
                rdCheeseBurger1.setEnabled(true);
                lblCheeseBurgerPrice.setText("- " + mainsrMap.getValue() + "$");
                lblCheeseBurgerPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Fried Rice")) {
                rdFriedRice1.setEnabled(true);
                lblFriedRicePrice.setText("- " + mainsrMap.getValue() + "$");
                lblFriedRicePrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Veggie Pizza")) {
                rdVeggiePizza1.setEnabled(true);
                lblVeggiePrice.setText("- " + mainsrMap.getValue() + "$");
                lblVeggiePrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Ham Burger")) {
                rdHamBurger1.setEnabled(true);
                lblHamburgerPrice.setText("- " + mainsrMap.getValue() + "$");
                lblHamburgerPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Fish N' Chips")) {
                rdFishNChips1.setEnabled(true);
                lblFishNChipsPrice.setText("- " + mainsrMap.getValue() + "$");
                lblFishNChipsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Prawn Fried Rice")) {
                rdPrawnFriedRice1.setEnabled(true);
                lblPrawnFriedRicePrice.setText("- " + mainsrMap.getValue() + "$");
                lblPrawnFriedRicePrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Tofu Salad")) {
                rdTofuSalad1.setEnabled(true);
                lblTofuSaladPrice.setText("- " + mainsrMap.getValue() + "$");
                lblTofuSaladPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Falafel Bowl")) {
                rdFalafelBowl1.setEnabled(true);
                lblFalafelBowlPrice.setText("- " + mainsrMap.getValue() + "$");
                lblFalafelBowlPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Tofu & Rice Platter")) {
                rdTofuAndRiceBowl1.setEnabled(true);
                lblTofuRiceBowlPrice.setText("- " + mainsrMap.getValue() + "$");
                lblTofuRiceBowlPrice.setForeground(Color.decode("#fc7703"));
            }
        }
    }

    /**
     * Enable Dessert buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableDessertRadioButtons(Suites selectedRestaurant) {
        for (Map.Entry<String, Integer> dessertMap : selectedRestaurant.getMenu().getDessert().entrySet()) {
            if (dessertMap.getKey().equals("Black Forest Cake")) {
                rdBlackForestCake1.setEnabled(true);
                lblBlackForestCakePrice.setText("- " + dessertMap.getValue() + "$");
                lblBlackForestCakePrice.setForeground(Color.decode("#fc7703"));
            }

            if (dessertMap.getKey().equals("Pineapple Swiss Role")) {
                rdPineappleSwissRole1.setEnabled(true);
                lblPineappleSwissRolePrice.setText("- " + dessertMap.getValue() + "$");
                lblPineappleSwissRolePrice.setForeground(Color.decode("#fc7703"));
            }

            if (dessertMap.getKey().equals("Chocolate Mousse")) {
                rdChocolateMousse1.setEnabled(true);
                lblChocolateMoussePrice.setText("- " + dessertMap.getValue() + "$");
                lblChocolateMoussePrice.setForeground(Color.decode("#fc7703"));
//                totalCost = totalCost + dessertMap.getValue();
            }
        }
    }

    /**
     * Enable Beverage buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableBeverageRadioButtons(Suites selectedRestaurant) {
        for (Map.Entry<String, Integer> beverageMap : selectedRestaurant.getMenu().getBeverages().entrySet()) {
            if (beverageMap.getKey().equals("CocaCola")) {
                rdCocaCola1.setEnabled(true);
                lblCocaColaPrice.setText("- " + beverageMap.getValue() + "$");
                lblCocaColaPrice.setForeground(Color.decode("#fc7703"));
            }

            if (beverageMap.getKey().equals("Fresh Lime Salted")) {
                rdFreshLimesalted1.setEnabled(true);
                lblFreshLimeSaltedPrice.setText("- " + beverageMap.getValue() + "$");
                lblFreshLimeSaltedPrice.setForeground(Color.decode("#fc7703"));
            }

            if (beverageMap.getKey().equals("Pepsi")) {
                rdPepsi1.setEnabled(true);
                lblPepsiPrice.setText("- " + beverageMap.getValue() + "$");
                lblPepsiPrice.setForeground(Color.decode("#fc7703"));
            }
        }
    }

    /**
     * Enable Appetizer buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableAppetizerRadioButtonsPremium(Premium selectedRestaurant) {
        for (Map.Entry<String, Integer> appetizerMap : selectedRestaurant.getMenu().getApetizers().entrySet()) {
            if (appetizerMap.getKey().equals("Onion Rings")) {
                rdOnionRings1.setEnabled(true);
                lblOnionRingsPrice.setText("- " + appetizerMap.getValue() + "$");
                lblOnionRingsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Spinach Pie")) {
                rdSpinachPie1.setEnabled(true);
                lblSpinachPiePrice.setText("- " + appetizerMap.getValue() + "$");
                lblSpinachPiePrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Spring Roles")) {
                rdSpringRoles1.setEnabled(true);
                lblSpringRolesPrice.setText("- " + appetizerMap.getValue() + "$");
                lblSpringRolesPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Meat Balls")) {
                rdMeatBalls1.setEnabled(true);
                lblMeatBallsPrice.setText("- " + appetizerMap.getValue() + "$");
                lblMeatBallsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Sausage Dip")) {
                rdSausageDip1.setEnabled(true);
                lblsausageDipPrice.setText("- " + appetizerMap.getValue() + "$");
                lblsausageDipPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Fried Shrimp")) {
                rdFriedShrimp1.setEnabled(true);
                lblFriedShrimpPrice.setText("- " + appetizerMap.getValue() + "$");
                lblFriedShrimpPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("White Bean Dip")) {
                rdWhiteBeanDip1.setEnabled(true);
                lblWhiteBeanDipPrice.setText("- " + appetizerMap.getValue() + "$");
                lblWhiteBeanDipPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Tortilla Chips")) {
                rdTortillaChips1.setEnabled(true);
                lblTortillaChipsPrice.setText("- " + appetizerMap.getValue() + "$");
                lblTortillaChipsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (appetizerMap.getKey().equals("Crispy Tofu")) {
                rdCrispyTofu1.setEnabled(true);
                lblCrispyTofuPrice.setText("- " + appetizerMap.getValue() + "$");
                lblCrispyTofuPrice.setForeground(Color.decode("#fc7703"));
            }
        }
    }

    /**
     * Enable Mains buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableMainsRadioButtonsPremium(Premium selectedRestaurant) {
        for (Map.Entry<String, Integer> mainsrMap : selectedRestaurant.getMenu().getMains().entrySet()) {
            if (mainsrMap.getKey().equals("Cheese Burger")) {
                rdCheeseBurger1.setEnabled(true);
                lblCheeseBurgerPrice.setText("- " + mainsrMap.getValue() + "$");
                lblCheeseBurgerPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Fried Rice")) {
                rdFriedRice1.setEnabled(true);
                lblFriedRicePrice.setText("- " + mainsrMap.getValue() + "$");
                lblFriedRicePrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Veggie Pizza")) {
                rdVeggiePizza1.setEnabled(true);
                lblVeggiePrice.setText("- " + mainsrMap.getValue() + "$");
                lblVeggiePrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Ham Burger")) {
                rdHamBurger1.setEnabled(true);
                lblHamburgerPrice.setText("- " + mainsrMap.getValue() + "$");
                lblHamburgerPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Fish N' Chips")) {
                rdFishNChips1.setEnabled(true);
                lblFishNChipsPrice.setText("- " + mainsrMap.getValue() + "$");
                lblFishNChipsPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Prawn Fried Rice")) {
                rdPrawnFriedRice1.setEnabled(true);
                lblPrawnFriedRicePrice.setText("- " + mainsrMap.getValue() + "$");
                lblPrawnFriedRicePrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Tofu Salad")) {
                rdTofuSalad1.setEnabled(true);
                lblTofuSaladPrice.setText("- " + mainsrMap.getValue() + "$");
                lblTofuSaladPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Falafel Bowl")) {
                rdFalafelBowl1.setEnabled(true);
                lblFalafelBowlPrice.setText("- " + mainsrMap.getValue() + "$");
                lblFalafelBowlPrice.setForeground(Color.decode("#fc7703"));
            }

            if (mainsrMap.getKey().equals("Tofu & Rice Platter")) {
                rdTofuAndRiceBowl1.setEnabled(true);
                lblTofuRiceBowlPrice.setText("- " + mainsrMap.getValue() + "$");
                lblTofuRiceBowlPrice.setForeground(Color.decode("#fc7703"));
            }
        }
    }

    /**
     * Enable Dessert buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableDessertRadioButtonsPremium(Premium selectedRestaurant) {
        for (Map.Entry<String, Integer> dessertMap : selectedRestaurant.getMenu().getDessert().entrySet()) {
            if (dessertMap.getKey().equals("Black Forest Cake")) {
                rdBlackForestCake1.setEnabled(true);
                lblBlackForestCakePrice.setText("- " + dessertMap.getValue() + "$");
                lblBlackForestCakePrice.setForeground(Color.decode("#fc7703"));
            }

            if (dessertMap.getKey().equals("Pineapple Swiss Role")) {
                rdPineappleSwissRole1.setEnabled(true);
                lblPineappleSwissRolePrice.setText("- " + dessertMap.getValue() + "$");
                lblPineappleSwissRolePrice.setForeground(Color.decode("#fc7703"));
            }

            if (dessertMap.getKey().equals("Chocolate Mousse")) {
                rdChocolateMousse1.setEnabled(true);
                lblChocolateMoussePrice.setText("- " + dessertMap.getValue() + "$");
                lblChocolateMoussePrice.setForeground(Color.decode("#fc7703"));
//                totalCost = totalCost + dessertMap.getValue();
            }
        }
    }

    /**
     * Enable Beverage buttons based on what is available
     *
     * @param selectedRestaurant
     */
    private void enableBeverageRadioButtonsPremium(Premium selectedRestaurant) {
        for (Map.Entry<String, Integer> beverageMap : selectedRestaurant.getMenu().getBeverages().entrySet()) {
            if (beverageMap.getKey().equals("CocaCola")) {
                rdCocaCola1.setEnabled(true);
                lblCocaColaPrice.setText("- " + beverageMap.getValue() + "$");
                lblCocaColaPrice.setForeground(Color.decode("#fc7703"));
            }

            if (beverageMap.getKey().equals("Fresh Lime Salted")) {
                rdFreshLimesalted1.setEnabled(true);
                lblFreshLimeSaltedPrice.setText("- " + beverageMap.getValue() + "$");
                lblFreshLimeSaltedPrice.setForeground(Color.decode("#fc7703"));
            }

            if (beverageMap.getKey().equals("Pepsi")) {
                rdPepsi1.setEnabled(true);
                lblPepsiPrice.setText("- " + beverageMap.getValue() + "$");
                lblPepsiPrice.setForeground(Color.decode("#fc7703"));
            }
        }
    }


    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        BasicConfigurator.configure();
        logger.info("Booking an event");
        switchPanels(bookEventDetails);
        lblOnionRingsPrice.setText("- NA -");
        lblOnionRingsPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdOnionRings1.setEnabled(false);

        lblSpinachPiePrice.setText("- NA -");
        lblSpinachPiePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdSpinachPie1.setEnabled(false);

        lblSpringRolesPrice.setText("- NA -");
        lblSpringRolesPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdSpringRoles1.setEnabled(false);

        lblMeatBallsPrice.setText("- NA -");
        lblMeatBallsPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdMeatBalls1.setEnabled(false);

        lblsausageDipPrice.setText("- NA -");
        lblsausageDipPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdSausageDip1.setEnabled(false);

        lblFriedShrimpPrice.setText("- NA -");
        lblFriedShrimpPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdFriedShrimp1.setEnabled(false);

        lblWhiteBeanDipPrice.setText("- NA -");
        lblWhiteBeanDipPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdWhiteBeanDip1.setEnabled(false);

        lblTortillaChipsPrice.setText("- NA -");
        lblTortillaChipsPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdTortillaChips1.setEnabled(false);

        lblCrispyTofuPrice.setText("- NA -");
        lblCrispyTofuPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdCrispyTofu1.setEnabled(false);

        lblCheeseBurgerPrice.setText("- NA -");
        lblCheeseBurgerPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdCheeseBurger1.setEnabled(false);

        lblFriedRicePrice.setText("- NA -");
        lblFriedRicePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdFriedRice1.setEnabled(false);

        lblVeggiePrice.setText("- NA -");
        lblVeggiePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdVeggiePizza1.setEnabled(false);

        lblHamburgerPrice.setText("- NA -");
        lblHamburgerPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdHamBurger1.setEnabled(false);

        lblFishNChipsPrice.setText("- NA -");
        lblFishNChipsPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdFishNChips1.setEnabled(false);

        lblPrawnFriedRicePrice.setText("- NA -");
        lblPrawnFriedRicePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdPrawnFriedRice1.setEnabled(false);

        lblTofuSaladPrice.setText("- NA -");
        lblTofuSaladPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdTofuSalad1.setEnabled(false);

        lblFalafelBowlPrice.setText("- NA -");
        lblFalafelBowlPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdFalafelBowl1.setEnabled(false);

        lblTofuRiceBowlPrice.setText("- NA -");
        lblTofuRiceBowlPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdTofuAndRiceBowl1.setEnabled(false);

        lblBlackForestCakePrice.setText("- NA -");
        lblBlackForestCakePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdBlackForestCake1.setEnabled(false);

        lblPineappleSwissRolePrice.setText("- NA -");
        lblPineappleSwissRolePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdPineappleSwissRole1.setEnabled(false);

        lblChocolateMoussePrice.setText("- NA -");
        lblChocolateMoussePrice.setForeground(new java.awt.Color(0, 102, 102));
        rdChocolateMousse1.setEnabled(false);

        lblCocaColaPrice.setText("- NA -");
        lblCocaColaPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdCocaCola1.setEnabled(false);

        lblFreshLimeSaltedPrice.setText("- NA -");
        lblFreshLimeSaltedPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdFreshLimesalted1.setEnabled(false);

        lblPepsiPrice.setText("- NA -");
        lblPepsiPrice.setForeground(new java.awt.Color(0, 102, 102));
        rdPepsi1.setEnabled(false);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void rdOnionRings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdOnionRings1ActionPerformed

    }//GEN-LAST:event_rdOnionRings1ActionPerformed

    private void rdCheeseBurger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCheeseBurger1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdCheeseBurger1ActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        finalizeOrder(ticket);
        JOptionPane.showMessageDialog(null, "Order placed successfully!");
        switchPanels(bookEventDetails);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        int selectedRowIndex = tblFoodBev1.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a place to eat");
            return;
        } else {
            BasicConfigurator.configure();
            logger.info("Booking reservations");
            switchPanels(SeatingPanel);
            DefaultTableModel model = (DefaultTableModel) tblFoodBev1.getModel();
            Suites selectedSuite = (Suites) model.getValueAt(selectedRowIndex, 0);
            flags.setReservationCost(selectedSuite.getCost());
            flags.setSuites(selectedSuite);
            if (selectedSuite.getSeats() != null && !selectedSuite.getSeats().isEmpty()) {
                enableSeats(selectedSuite);
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void btnBack6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack6MouseEntered

    private void btnBack6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack6MouseExited

    private void btnBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack6ActionPerformed
        switchPanels(bookEventDetails);
    }//GEN-LAST:event_btnBack6ActionPerformed

    private void rdT5C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdT5C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdT5C2ActionPerformed

    private void btnBookSeatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookSeatsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookSeatsMouseEntered

    private void btnBookSeatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookSeatsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookSeatsMouseExited

    private void btnBookSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookSeatsActionPerformed
        Map<String, List<String>> seatsMap = new HashMap<>();
        List<String> seatsListForT1 = new ArrayList<String>();
        int seatCount = 0;

        if (rdT1C1.isSelected()) {
            seatsListForT1.add("C1");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C2.isSelected()) {
            seatsListForT1.add("C2");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C3.isSelected()) {
            seatsListForT1.add("C3");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C4.isSelected()) {
            seatsListForT1.add("C4");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C5.isSelected()) {
            seatsListForT1.add("C5");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C6.isSelected()) {
            seatsListForT1.add("C6");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C7.isSelected()) {
            seatsListForT1.add("C7");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        if (rdT1C8.isSelected()) {
            seatsListForT1.add("C8");
            seatsMap.put("T1", seatsListForT1);
            seatCount++;
        }

        List<String> seatsListForT2 = new ArrayList<String>();
        if (rdT2C1.isSelected()) {
            seatsListForT2.add("C1");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C2.isSelected()) {
            seatsListForT2.add("C2");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C3.isSelected()) {
            seatsListForT2.add("C3");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C4.isSelected()) {
            seatsListForT2.add("C4");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C5.isSelected()) {
            seatsListForT2.add("C5");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C6.isSelected()) {
            seatsListForT2.add("C6");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C7.isSelected()) {
            seatsListForT2.add("C7");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        if (rdT2C8.isSelected()) {
            seatsListForT2.add("C8");
            seatsMap.put("T2", seatsListForT2);
            seatCount++;
        }

        List<String> seatsListForT3 = new ArrayList<String>();
        if (rdT3C1.isSelected()) {
            seatsListForT3.add("C1");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C2.isSelected()) {
            seatsListForT3.add("C2");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C3.isSelected()) {
            seatsListForT3.add("C3");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C4.isSelected()) {
            seatsListForT3.add("C4");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C5.isSelected()) {
            seatsListForT3.add("C5");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C6.isSelected()) {
            seatsListForT3.add("C6");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C7.isSelected()) {
            seatsListForT3.add("C7");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        if (rdT3C8.isSelected()) {
            seatsListForT3.add("C8");
            seatsMap.put("T3", seatsListForT3);
            seatCount++;
        }

        List<String> seatsListForT4 = new ArrayList<String>();
        if (rdT4C1.isSelected()) {
            seatsListForT4.add("C1");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C2.isSelected()) {
            seatsListForT4.add("C2");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C3.isSelected()) {
            seatsListForT4.add("C3");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C4.isSelected()) {
            seatsListForT4.add("C4");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C5.isSelected()) {
            seatsListForT4.add("C5");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C6.isSelected()) {
            seatsListForT4.add("C6");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C7.isSelected()) {
            seatsListForT4.add("C7");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        if (rdT4C8.isSelected()) {
            seatsListForT4.add("C8");
            seatsMap.put("T4", seatsListForT4);
            seatCount++;
        }

        List<String> seatsListForT5 = new ArrayList<String>();
        if (rdT5C1.isSelected()) {
            seatsListForT5.add("C1");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        if (rdT5C2.isSelected()) {
            seatsListForT5.add("C2");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        if (rdT5C3.isSelected()) {
            seatsListForT5.add("C3");
            seatsMap.put("T5", seatsListForT5);
        }

        if (rdT5C4.isSelected()) {
            seatsListForT5.add("C4");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        if (rdT5C5.isSelected()) {
            seatsListForT5.add("C5");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        if (rdT5C6.isSelected()) {
            seatsListForT5.add("C6");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        if (rdT5C7.isSelected()) {
            seatsListForT5.add("C7");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        if (rdT5C8.isSelected()) {
            seatsListForT5.add("C8");
            seatsMap.put("T5", seatsListForT5);
            seatCount++;
        }

        List<String> seatsListForT6 = new ArrayList<String>();
        if (rdT6C1.isSelected()) {
            seatsListForT5.add("C1");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C2.isSelected()) {
            seatsListForT6.add("C2");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C3.isSelected()) {
            seatsListForT6.add("C3");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C4.isSelected()) {
            seatsListForT6.add("C4");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C5.isSelected()) {
            seatsListForT6.add("C5");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C6.isSelected()) {
            seatsListForT6.add("C6");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C7.isSelected()) {
            seatsListForT6.add("C7");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        if (rdT6C8.isSelected()) {
            seatsListForT6.add("C8");
            seatsMap.put("T6", seatsListForT6);
            seatCount++;
        }

        List<String> seatsListForT7 = new ArrayList<String>();
        if (rdT7C1.isSelected()) {
            seatsListForT7.add("C1");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C2.isSelected()) {
            seatsListForT7.add("C2");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C3.isSelected()) {
            seatsListForT7.add("C3");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C4.isSelected()) {
            seatsListForT7.add("C4");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C5.isSelected()) {
            seatsListForT7.add("C5");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C6.isSelected()) {
            seatsListForT7.add("C6");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C7.isSelected()) {
            seatsListForT7.add("C7");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

        if (rdT7C8.isSelected()) {
            seatsListForT7.add("C8");
            seatsMap.put("T7", seatsListForT7);
            seatCount++;
        }

//        for (Map.Entry<String, List<String>> seatsMapCost : flags.getSuites().getSeats().entrySet()) {
//            for (String seats : seatsMapCost.getValue()) {
//                seatCount++;
//            }
//        }
        reservationCost = flags.getReservationCost() * seatCount;
        flags.setReservationCost(reservationCost);
        JOptionPane.showMessageDialog(null, "Seating saved successfully.");
        flags.setSeatsMap(seatsMap);
        switchPanels(bookEventDetails);
    }//GEN-LAST:event_btnBookSeatsActionPerformed

    private void btnBookTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookTicketActionPerformed
        Ticket ticket = ticketDirectory.addTicket();

        Random randomNum = new Random();
        int randomOrderId = randomNum.nextInt(65536 - 32768);
        ticket.setId(randomOrderId);
        ticket.setEventName(flags.getEventName());

        if (lstSeatType1.getSelectedValue().equals("SUITE TYPE")) {
            ticket.setSeatType("SUITE");
        } else if (lstSeatType1.getSelectedValue().equals("PREMIUM TYPE")) {
            ticket.setSeatType("PREMIUM");
            ticket.setTier(cmbTiers.getSelectedItem().toString());
        }
        ticket.setCustomerName(customer.getFullName());

        ticket.setFoodCost(flags.getFoodCost());
        ticket.setFoodItems(flags.getFoodItems());
        ticket.setSeats(flags.getSeatsMap());
        ticket.setCount(flags.getTicketCount());
        ticket.setSuiteName(flags.getSuiteName());
        ticket.setReservationCost(flags.getReservationCost());

        customer.setTicket(ticket);
        enterprise.setTicketDirectory(ticketDirectory);
        network.put(networkString, enterprise);
        business.setNetworkList(network);
        populateBooking();
        switchPanels(viewBookings);
        SendMail sendMail = new SendMail();
        sendMail.sendMail(customer.getEmail(), String.valueOf(ticket.getId()), ticket.getEventName(), ticket, customer);
    }//GEN-LAST:event_btnBookTicketActionPerformed

    private void btnTierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTierActionPerformed
        int selectedRowIndex = tblFoodBev1.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Restaurant");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblFoodBev1.getModel();
            Premium selectedPremium = (Premium) model.getValueAt(selectedRowIndex, 0);
            cmbTiers.removeAllItems();
            for (String tiers : selectedPremium.getTiers()) {
                cmbTiers.addItem(tiers);
            }
            cmbTiers.setVisible(true);
        }
    }//GEN-LAST:event_btnTierActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        int selectedRowIndex = tblMerchandise.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select an item");
            return;
        } else {
            DefaultTableModel model = (DefaultTableModel) tblMerchandise.getModel();
            merchandise selectedMerch = (merchandise) model.getValueAt(selectedRowIndex, 0);
            if (customer.getMerchCost() == 0) {
                customer.setMerchCost(selectedMerch.getPrice());
            } else {
                customer.setMerchCost(customer.getMerchCost() + selectedMerch.getPrice());
            }
            JOptionPane.showMessageDialog(this, "Item purchased successfully!");
            switchPanels(customerProfilePanel);
        }
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        CarBooking bookingReq = pdDirectory.addCarBooking();
        bookingReq.setCustomerName(customer.getFullName());
        bookingReq.setPickupPoint(txtPickupLocation.getText());
        bookingReq.setStatus("REQUESTED");

        if (chkReturntrip.isSelected()) {
            bookingReq.setTwoWay(true);
        } else {
            bookingReq.setTwoWay(false);
        }
        enterprise.setPdDirectory(pdDirectory);
        network.put(networkString, enterprise);
        business.setNetworkList(network);
        JOptionPane.showMessageDialog(this, "Booking req sent successfully!");
        populatePickAndDrop();

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void disableRadioButtons() {
        rdOnionRings1.setEnabled(false);
        rdSpinachPie1.setEnabled(false);
        rdSpringRoles1.setEnabled(false);
        rdMeatBalls1.setEnabled(false);
        rdSausageDip1.setEnabled(false);
        rdFriedShrimp1.setEnabled(false);
        rdWhiteBeanDip1.setEnabled(false);
        rdTortillaChips1.setEnabled(false);
        rdCrispyTofu1.setEnabled(false);

        rdCheeseBurger1.setEnabled(false);
        rdFriedRice1.setEnabled(false);
        rdVeggiePizza1.setEnabled(false);
        rdHamBurger1.setEnabled(false);
        rdFishNChips1.setEnabled(false);
        rdPrawnFriedRice1.setEnabled(false);
        rdTofuSalad1.setEnabled(false);
        rdFalafelBowl1.setEnabled(false);
        rdTofuAndRiceBowl1.setEnabled(false);

        rdBlackForestCake1.setEnabled(false);
        rdPineappleSwissRole1.setEnabled(false);
        rdChocolateMousse1.setEnabled(false);

        rdCocaCola1.setEnabled(false);
        rdFreshLimesalted1.setEnabled(false);
        rdPepsi1.setEnabled(false);
    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        switchPanels(parkingDetails);
        populatePickAndDrop();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void switchPanels(Component component) {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(component);
        jLayeredPane1.revalidate();
        jLayeredPane1.repaint();
    }

    private void populateEventTable() {
        DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
        model.setRowCount(0);

        if (eventDirectory.getEventList() != null && !eventDirectory.getEventList().isEmpty()) {
            for (Event event : eventDirectory.getEventList()) {
                if (event.getNetwork().equals(networkString)) {
                    Object[] row = new Object[4];
                    row[0] = event;
                    row[1] = event.getEndDate();
                    row[2] = event.getEventType();
                    row[3] = event.getCapacity();
                    model.addRow(row);
                }
            }
        }
    }

    private void populateMerchandise() {
        DefaultTableModel model = (DefaultTableModel) tblMerchandise.getModel();
        model.setRowCount(0);

        for (merchandiseShop shop : merchDirectory.getMerchandiseShopList()) {
            if (shop != null && shop.getMerchandiseMenu() != null && !shop.getMerchandiseMenu().isEmpty()) {
                for (merchandise merch : shop.getMerchandiseMenu()) {
                    Object[] row = new Object[2];
                    row[0] = merch;
                    row[1] = "$ " + String.valueOf(merch.getPrice());
                    model.addRow(row);
                }
            }
        }
    }

    private void populatePickAndDrop() {
        DefaultTableModel model = (DefaultTableModel) tblPickup.getModel();
        model.setRowCount(0);

        for (CarBooking booking : pdDirectory.getCarBookingList()) {
            Object[] row = new Object[5];
            row[0] = booking;
            row[1] = booking.getCarNumber();
            row[2] = booking.getTwoWay();
            row[3] = booking.getStatus();
            row[4] = booking.getPrice();
            model.addRow(row);
        }
    }

    private void populateFoodBev() {
        DefaultTableModel model = (DefaultTableModel) tblFoodBev1.getModel();
        model.setRowCount(0);

        if (lstSeatType1.getSelectedValue().equals("SUITE TYPE")) {
            for (Suites suite : suitedDirectory.getSuitesList()) {
                Object[] row = new Object[2];
                row[0] = suite;
                row[1] = suite.getCost();
                model.addRow(row);
            }
        } else {
            for (Premium premium : premiumDirectory.getPremiumList()) {
                Object[] row = new Object[2];
                row[0] = premium;
                row[1] = "";
                model.addRow(row);
            }
        }
    }

    private void populateBooking() {
        DefaultTableModel model = (DefaultTableModel) tblBookings.getModel();
        model.setRowCount(0);

        for (Ticket ticket : ticketDirectory.getTicketList()) {
            if (ticket.getCustomerName() != null && ticket.getCustomerName().equals(customer.getFullName())) {
                Object[] row = new Object[6];
                row[0] = ticket;
                row[1] = ticket.getEventName();
                row[2] = ticket.getCount();
                row[3] = ticket.getSeatType();
                row[4] = "$ " + String.valueOf(ticket.getFoodCost() + ticket.getReservationCost());
                model.addRow(row);
            }
        }
    }

    private void enableSeats(Suites suite) {
        for (Map.Entry<String, List<String>> seatsMap : suite.getSeats().entrySet()) {
            if (seatsMap.getKey().equals("T1")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT1C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT1C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT1C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT1C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT1C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT1C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT1C7.setEnabled(true);
                    }
                }
            }
            if (seatsMap.getKey().equals("T2")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT2C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT2C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT2C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT2C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT2C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT2C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT2C7.setEnabled(true);
                    }
                }
            }

            if (seatsMap.getKey().equals("T3")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT3C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT3C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT3C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT3C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT3C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT3C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT3C7.setEnabled(true);
                    }
                }
            }

            if (seatsMap.getKey().equals("T4")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT4C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT4C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT4C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT4C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT4C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT4C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT4C7.setEnabled(true);
                    }
                }
            }

            if (seatsMap.getKey().equals("T5")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT5C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT5C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT5C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT5C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT5C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT5C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT5C7.setEnabled(true);
                    }
                }
            }

            if (seatsMap.getKey().equals("T6")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT6C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT6C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT6C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT6C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT6C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT6C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT6C7.setEnabled(true);
                    }
                }
            }

            if (seatsMap.getKey().equals("T7")) {
                for (String chair : seatsMap.getValue()) {
                    if (chair.equals("C1")) {
                        rdT7C1.setEnabled(true);
                    }

                    if (chair.equals("C2")) {
                        rdT7C2.setEnabled(true);
                    }

                    if (chair.equals("C3")) {
                        rdT7C3.setEnabled(true);
                    }

                    if (chair.equals("C4")) {
                        rdT7C4.setEnabled(true);
                    }

                    if (chair.equals("C5")) {
                        rdT7C5.setEnabled(true);
                    }

                    if (chair.equals("C6")) {
                        rdT7C6.setEnabled(true);
                    }

                    if (chair.equals("C7")) {
                        rdT7C7.setEnabled(true);
                    }
                }
            }

        }
    }

    private void restRadioButtons() {
        rdT1C1.setEnabled(false);
        rdT1C2.setEnabled(false);
        rdT1C3.setEnabled(false);
        rdT1C4.setEnabled(false);
        rdT1C5.setEnabled(false);
        rdT1C6.setEnabled(false);
        rdT1C7.setEnabled(false);
        rdT1C8.setEnabled(false);

        rdT2C1.setEnabled(false);
        rdT2C2.setEnabled(false);
        rdT2C3.setEnabled(false);
        rdT2C4.setEnabled(false);
        rdT2C5.setEnabled(false);
        rdT2C6.setEnabled(false);
        rdT2C7.setEnabled(false);
        rdT2C8.setEnabled(false);

        rdT3C1.setEnabled(false);
        rdT3C2.setEnabled(false);
        rdT3C3.setEnabled(false);
        rdT3C4.setEnabled(false);
        rdT3C5.setEnabled(false);
        rdT3C6.setEnabled(false);
        rdT3C7.setEnabled(false);
        rdT3C8.setEnabled(false);

        rdT4C1.setEnabled(false);
        rdT4C2.setEnabled(false);
        rdT4C3.setEnabled(false);
        rdT4C4.setEnabled(false);
        rdT4C5.setEnabled(false);
        rdT4C6.setEnabled(false);
        rdT4C7.setEnabled(false);
        rdT4C8.setEnabled(false);

        rdT5C1.setEnabled(false);
        rdT5C2.setEnabled(false);
        rdT5C3.setEnabled(false);
        rdT5C4.setEnabled(false);
        rdT5C5.setEnabled(false);
        rdT5C6.setEnabled(false);
        rdT5C7.setEnabled(false);
        rdT5C8.setEnabled(false);

        rdT6C1.setEnabled(false);
        rdT6C2.setEnabled(false);
        rdT6C3.setEnabled(false);
        rdT6C4.setEnabled(false);
        rdT6C5.setEnabled(false);
        rdT6C6.setEnabled(false);
        rdT6C7.setEnabled(false);
        rdT6C8.setEnabled(false);

        rdT7C1.setEnabled(false);
        rdT7C2.setEnabled(false);
        rdT7C3.setEnabled(false);
        rdT7C4.setEnabled(false);
        rdT7C5.setEnabled(false);
        rdT7C6.setEnabled(false);
        rdT7C7.setEnabled(false);
        rdT7C8.setEnabled(false);
    }

    private void finalizeOrder(Ticket ticket) {
        if (rdOnionRings1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblOnionRingsPrice.getText().substring(2, lblOnionRingsPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdOnionRings1.getText());
        }

        if (rdSpinachPie1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblSpinachPiePrice.getText().substring(2, lblSpinachPiePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdSpinachPie1.getText());
        }

        if (rdSpringRoles1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblSpringRolesPrice.getText().substring(2, lblSpringRolesPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdSpringRoles1.getText());
        }

        if (rdMeatBalls1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblMeatBallsPrice.getText().substring(2, lblMeatBallsPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdMeatBalls1.getText());
        }

        if (rdSausageDip1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblsausageDipPrice.getText().substring(2, lblsausageDipPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdSausageDip1.getText());
        }

        if (rdFriedShrimp1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblFriedShrimpPrice.getText().substring(2, lblFriedShrimpPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdFriedShrimp1.getText());
        }

        if (rdWhiteBeanDip1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblWhiteBeanDipPrice.getText().substring(2, lblWhiteBeanDipPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdWhiteBeanDip1.getText());
        }

        if (rdTortillaChips1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblTortillaChipsPrice.getText().substring(2, lblTortillaChipsPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdTortillaChips1.getText());
        }

        if (rdCrispyTofu1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblCrispyTofuPrice.getText().substring(2, lblCrispyTofuPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdCrispyTofu1.getText());
        }

        if (rdCheeseBurger1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblCheeseBurgerPrice.getText().substring(2, lblCheeseBurgerPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdCheeseBurger1.getText());
        }
        if (rdFriedRice1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblFriedRicePrice.getText().substring(2, lblFriedRicePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdFriedRice1.getText());
        }
        if (rdVeggiePizza1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblVeggiePrice.getText().substring(2, lblVeggiePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdCrispyTofu1.getText());
        }
        if (rdHamBurger1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblHamburgerPrice.getText().substring(2, lblHamburgerPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdHamBurger1.getText());
        }
        if (rdFishNChips1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblFishNChipsPrice.getText().substring(2, lblFishNChipsPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdFishNChips1.getText());
        }
        if (rdPrawnFriedRice1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblPrawnFriedRicePrice.getText().substring(2, lblPrawnFriedRicePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdPrawnFriedRice1.getText());
        }
        if (rdTofuSalad1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblTofuSaladPrice.getText().substring(2, lblTofuSaladPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdTofuSalad1.getText());
        }
        if (rdFalafelBowl1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblFalafelBowlPrice.getText().substring(2, lblFalafelBowlPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdFalafelBowl1.getText());
        }
        if (rdTofuAndRiceBowl1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblTofuRiceBowlPrice.getText().substring(2, lblTofuRiceBowlPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdTofuAndRiceBowl1.getText());
        }

        if (rdBlackForestCake1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblBlackForestCakePrice.getText().substring(2, lblBlackForestCakePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdBlackForestCake1.getText());
        }

        if (rdPineappleSwissRole1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblPineappleSwissRolePrice.getText().substring(2, lblPineappleSwissRolePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdPineappleSwissRole1.getText());
        }

        if (rdChocolateMousse1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblChocolateMoussePrice.getText().substring(2, lblChocolateMoussePrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdChocolateMousse1.getText());
        }

        if (rdCocaCola1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblCocaColaPrice.getText().substring(2, lblCocaColaPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdCocaCola1.getText());
        }

        if (rdFreshLimesalted1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblFreshLimeSaltedPrice.getText().substring(2, lblFreshLimeSaltedPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdFreshLimesalted1.getText());
        }

        if (rdPepsi1.isSelected()) {
            totalCost = totalCost + Integer.parseInt(lblPepsiPrice.getText().substring(2, lblPepsiPrice.getText().indexOf("$")));
            ticket.setFoodCost(totalCost);
            foodItems.add(rdPepsi1.getText());
        }

        flags.setFoodCost(totalCost);
        flags.setFoodItems(foodItems);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NavigationJPanel;
    private javax.swing.JPanel OrderPanel;
    private javax.swing.JPanel SeatingPanel;
    private javax.swing.JPanel bookEventDetails;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack6;
    private javax.swing.JButton btnBookSeats;
    private javax.swing.JButton btnBookTicket;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnConfirmSeats;
    private javax.swing.JButton btnConfirmSeats1;
    private javax.swing.JButton btnEditDetails;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnSelectSeatType1;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnTier;
    private javax.swing.JCheckBox chkReturntrip;
    private javax.swing.JComboBox<String> cmbTiers;
    private javax.swing.JPanel customerProfilePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbBeverages1;
    private javax.swing.JLabel lblApetizers1;
    private javax.swing.JLabel lblAptNonVeg1;
    private javax.swing.JLabel lblAptVeg1;
    private javax.swing.JLabel lblAptVegan1;
    private javax.swing.JLabel lblAptVegan2;
    private javax.swing.JLabel lblBlackForestCakePrice;
    private javax.swing.JLabel lblCheeseBurgerPrice;
    private javax.swing.JLabel lblChocolateMoussePrice;
    private javax.swing.JLabel lblCocaColaPrice;
    private javax.swing.JLabel lblCrispyTofuPrice;
    private javax.swing.JLabel lblDesserts1;
    private javax.swing.JLabel lblEventName;
    private javax.swing.JLabel lblFalafelBowlPrice;
    private javax.swing.JLabel lblFishNChipsPrice;
    private javax.swing.JLabel lblFreshLimeSaltedPrice;
    private javax.swing.JLabel lblFriedRicePrice;
    private javax.swing.JLabel lblFriedShrimpPrice;
    private javax.swing.JLabel lblHamburgerPrice;
    private javax.swing.JLabel lblHeader1;
    private javax.swing.JLabel lblHeader4;
    private javax.swing.JLabel lblMains1;
    private javax.swing.JLabel lblMainsNonVeg1;
    private javax.swing.JLabel lblMainsVeg1;
    private javax.swing.JLabel lblMeatBallsPrice;
    private javax.swing.JLabel lblOnionRingsPrice;
    private javax.swing.JLabel lblPepsiPrice;
    private javax.swing.JLabel lblPineappleSwissRolePrice;
    private javax.swing.JLabel lblPrawnFriedRicePrice;
    private javax.swing.JLabel lblSpinachPiePrice;
    private javax.swing.JLabel lblSpringRolesPrice;
    private javax.swing.JLabel lblTofuRiceBowlPrice;
    private javax.swing.JLabel lblTofuSaladPrice;
    private javax.swing.JLabel lblTortillaChipsPrice;
    private javax.swing.JLabel lblVeggiePrice;
    private javax.swing.JLabel lblWhiteBeanDipPrice;
    private javax.swing.JLabel lblsausageDipPrice;
    private javax.swing.JList<String> lstSeatType1;
    private javax.swing.JPanel merchandize;
    private javax.swing.JPanel orderFood;
    private javax.swing.JPanel parkingDetails;
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
    private javax.swing.JPanel registerEvent;
    private javax.swing.JPanel securityService;
    private javax.swing.JPanel selecSeatType;
    private javax.swing.JTable tblBookings;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblFoodBev1;
    private javax.swing.JTable tblMerchandise;
    private javax.swing.JTable tblPickup;
    private javax.swing.JPanel techService;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtPickupLocation;
    private javax.swing.JTextField txtTicketCount;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPanel viewBookings;
    // End of variables declaration//GEN-END:variables
}
