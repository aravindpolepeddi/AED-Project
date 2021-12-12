///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package business.role;
//
//import business.Business;
//import business.Customer.CustomerDirectory;
//import business.Order.Order;
//import business.Order.OrderDirectory;
//import business.Restaurant.RestaurantDirectory;
//import business.useraccount.UserAccount;
//import javax.swing.JPanel;
//import ui.CustomerRole.CustomerAreaJPanel;
//import ui.RestaurantRole.RestaurantAreaJPanel;
//
///**
// *
// * @author deepv
// */
//public class RestaurantRole extends Role {
//
//    public RestaurantRole() {
//        this.type = RoleType.RestaurantAdmin;
//    }
//
//    
//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business business) {
//        return new RestaurantAreaJPanel(userProcessContainer, account, business);
//    }
//}
