/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deepv
 */
public class TicketDirectory {

    private List<Ticket> ticketList;

    public TicketDirectory() {
        ticketList = new ArrayList<>();
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Ticket addTicket() {
        Ticket ticket = new Ticket();
        ticketList.add(ticket);
        return ticket;
    }

    public Ticket findTicketById(int id) {
        Ticket ticket = ticketList.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        return ticket;
    }

}
