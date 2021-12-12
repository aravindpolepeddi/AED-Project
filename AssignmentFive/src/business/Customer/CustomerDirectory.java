/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import java.util.ArrayList;

/**
 *
 * @author deepv
 */
public class CustomerDirectory {

    private ArrayList<Customer> customers;

    public CustomerDirectory() {
        customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Customer addCustomer() {
        Customer customer = new Customer();
        customers.add(customer);
        return customer;
    }

    public Customer findCustomer(String userName) {
        Customer customer = customers.stream().filter(x -> x.getUserName().equals(userName)).findAny().orElse(null);
        return customer;
    }

    public Customer findCustomerByTicketId(int ticketId) {
        for (Customer customer : customers) {
            if (customer.getTicket() != null) {
                if (customer.getTicket().getId() == ticketId) {
                    return customer;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

}
