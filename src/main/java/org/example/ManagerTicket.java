package org.example;

import java.util.Arrays;

public class ManagerTicket {
    protected RepositoryTicket repositoryTicket;

    public ManagerTicket(RepositoryTicket repositoryTicket) {
        this.repositoryTicket = repositoryTicket;
    }

    public void add(Ticket ticket) {
        repositoryTicket.addTicket(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repositoryTicket.getTickets()) {
            if (ticket.getFrom() == from) {
                if (ticket.getTo() == to) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
        }
        TicketPriceComparator priceComparator = new TicketPriceComparator();
        Arrays.sort(result, priceComparator);
        return result;
    }
}
