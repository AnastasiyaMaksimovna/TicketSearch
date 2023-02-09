package org.example;

public class RepositoryTicket {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void deleteTicket(int id) {
        if (this.findById(id) == null) {
            NotFoundException e = new NotFoundException(
                    "ID не найден:" + id
            );
            throw e;
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId() != id) {
                tmp[copyToIndex] = tickets[i];
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

}
