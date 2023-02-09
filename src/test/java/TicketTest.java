import org.example.ManagerTicket;
import org.example.NotFoundException;
import org.example.RepositoryTicket;
import org.example.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    @Test
    public void priceMinTicket() {
        Ticket ticket = new Ticket(1299);
        Ticket ticket2 = new Ticket(2199);

        int expected = -1;
        int actual = ticket.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void priceMaxTicket() {
        Ticket ticket = new Ticket(3299);
        Ticket ticket2 = new Ticket(2199);

        int expected = 1;
        int actual = ticket.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void priceEquallyTicket() {
        Ticket ticket = new Ticket(2199);
        Ticket ticket2 = new Ticket(2199);

        int expected = 0;
        int actual = ticket.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void addTicketTest() {
        RepositoryTicket repo = new RepositoryTicket();
        Ticket ticket = new Ticket(1000);
        Ticket ticket2 = new Ticket(2199);

        repo.addTicket(ticket);

        Ticket[] expected = {ticket};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void deleteTicketTest() {
        RepositoryTicket repo = new RepositoryTicket();
        Ticket ticket = new Ticket(111, 1000);
        Ticket ticket2 = new Ticket(333, 2199);
        Ticket ticket3 = new Ticket(555, 1500);

        repo.addTicket(ticket);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.deleteTicket(555);

        Ticket[] expected = {ticket, ticket2};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteTicketZeroTest() {
        RepositoryTicket repo = new RepositoryTicket();
        Ticket ticket = new Ticket(111, 1000);
        Ticket ticket2 = new Ticket(333, 2199);
        Ticket ticket3 = new Ticket(555, 1500);

        repo.addTicket(ticket);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.deleteTicket(777);
        });
    }

    @Test
    public void findByIdTest() {
        RepositoryTicket repo = new RepositoryTicket();
        Ticket ticket = new Ticket(111, 1000);
        Ticket ticket2 = new Ticket(333, 2199);
        repo.addTicket(ticket);
        repo.addTicket(ticket2);

        Ticket expected = ticket2;
        Ticket actual = repo.findById(333);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest() {
        RepositoryTicket repositoryTicket = new RepositoryTicket();
        ManagerTicket repo = new ManagerTicket(repositoryTicket);

        Ticket ticket = new Ticket("SVO", "KZN", 13560);
        Ticket ticket2 = new Ticket("VKO", "KZN", 14845);
        Ticket ticket3 = new Ticket("SVO", "KZN", 15560);

        repo.add(ticket);
        repo.add(ticket2);
        repo.add(ticket3);

        repo.findAll("SVO", "KZN");

        Ticket[] expected = {ticket, ticket3};
        Ticket[] actual = repo.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }
}
