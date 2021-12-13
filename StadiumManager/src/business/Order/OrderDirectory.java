/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Order;

import business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author deepv
 */
public class OrderDirectory {

    ArrayList<Order> orders;

    public OrderDirectory() {
        this.orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Order addOrder() {
        Order order = new Order();
        orders.add(order);
        return order;
    }

    public Order findOrder(int id) {
        Order order = orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        return order;
    }

    public void removeSelectedRestaurantOrders(String restaurantName) {
        for (Order order : orders) {
            if (order.getRestaurantName().equals(restaurantName)) {
                int index = orders.indexOf(order);
                orders.remove(order);
            }
        }
    }

    public Order findOrderByDeliveryStaffName(String staffMemberName) {
        Order order = new Order();
        for (Order order2 : orders) {
            if (order2.getDeliveryStaffName() != null && !order2.getDeliveryStaffName().isBlank() && !order2.getDeliveryStaffName().isEmpty()) {
                if (order2.getDeliveryStaffName().equals(staffMemberName)) {
                    order = order2;
                    break;
                }
            }
        }

        return order;
    }

    public void updateRestaurantNameInOrders(String oldRestaurantName, String newRestaurantName) {
        int i = 0;
        for (Order orderIteration : orders) {
            if (orderIteration.getRestaurantName().equals(oldRestaurantName)) {
                orderIteration.setRestaurantName(newRestaurantName);
                orders.set(i, orderIteration);
            }
            i++;
        }
    }

    public void removeSelectedDeliveryStaffOrders(String deliveryStaff) {
        int index = 0;
        for (Order order : orders) {
            if (order.getDeliveryStaffName() != null && order.getDeliveryStaffName().equals(deliveryStaff)) {
                order.setDeliveryStaffName(null);
                order.setStatus("PENDING");
                orders.set(index, order);
            }
        }
    }

    public void updateSelectedDeliveryStaffOrders(String oldDeliveryStaff, String newDeliveryStaff) {
        int index = 0;
        for (Order order : orders) {
            if (order.getDeliveryStaffName() != null && order.getDeliveryStaffName().equals(oldDeliveryStaff)) {
                order.setDeliveryStaffName(newDeliveryStaff);
                orders.set(index, order);
            }
        }
    }

    public void removeSelectedCustomerOrders(String customerName) {
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                int index = orders.indexOf(order);
                orders.remove(order);
            }
        }
    }

    public void updateSelectedCustomerOrders(String oldCustomerName, String newCustomerName) {
        int index = 0;
        for (Order order : orders) {
            if (order.getCustomerName() != null && order.getCustomerName().equals(oldCustomerName)) {
                order.setCustomerName(newCustomerName);
                orders.set(index, order);
            }
        }
    }

    public void removeOrderByOrderId(int id) {
        Order order = orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        orders.remove(order);
    }

    public ArrayList<Order> ordersofARestaurantWithSomeRating(String restaurantName) {
        ArrayList<Order> restaurantOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getRestaurantName().equals(restaurantName) && order.getOrderRating() != 0) {
                restaurantOrders.add(order);
            }
        }
        return restaurantOrders;
    }

    public Order findOrderByCustomerName(String customerName) {
        Order order = new Order();
        for (Order order2 : orders) {
            if (order2.getCustomerName() != null && !order2.getCustomerName().isBlank() && !order2.getCustomerName().isEmpty()) {
                if (order2.getCustomerName().equals(customerName)) {
                    order = order2;
                    break;
                }
            }
        }

        return order;
    }

}
