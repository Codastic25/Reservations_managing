import java.util.Date;
import java.util.Random;

public class MainTest {


    public static void main(String[] args) throws ArrayFullException, InvalidDiscountException {

        TicketManager ticketManager = new TicketManager(0); // the ticket manager count from 0
        Date date = new Date();// Mon objet date
        Random random = new Random();

        System.out.println("ALL RESERVATIONS ");
        System.out.println("Here are the tickets : \n");

        for (int i = 1; i < 7; i++) { // my 6 tickets objects
            Ticket ticket = new Ticket(date,20,true);//cost 20 euros, date, available
            ticketManager.addReservation(ticket);
            System.out.println("Ticket " + i + "{ price=" + ticket.price + "€ " + " available : " + ticket.available +  " }");
        }

        System.out.println("\n");

        //My 3 random unavailable tickets among the 6
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(ticketManager.reservations.size());
            Ticket randomTicket = (Ticket) ticketManager.reservations.get(randomIndex);
            randomTicket.available = false;
            System.out.println("Ticket " + randomIndex + " is now unavailable: ");
        }

        //Upload of my tickets
        System.out.println("\nUpload :");
        for (Reservation r : ticketManager.reservations) {
            Ticket ticket = (Ticket) r;
            System.out.println("{ price=" + ticket.price + "€, available=" + ticket.available + " }");
        }

        System.out.println("\n");

        System.out.println("Here are the SubscriptionTickets : \n");
        for (int i = 0; i < 4; i++) {
            SubscriptionTicket subscriptionTicket = new SubscriptionTicket(1234 + i, date, 20, true); // my 4 subscriptionTicket objects
            ticketManager.addReservation(subscriptionTicket);

            //System.out.println(subscriptionTicket.toString());--> probleme affichage
            //System.out.println(subscriptionTicket.toString());
        }

        // Apply discount to all SubscriptionTickets

        for (Reservation r : ticketManager.reservations) {
            if (r instanceof SubscriptionTicket) {
                SubscriptionTicket subTicket = (SubscriptionTicket) r;
                double originalPrice = subTicket.price;
                subTicket.applyDiscount(20.0); 
                System.out.println("SubscriptionTicket { original price=" + originalPrice + "€, " + "discounted price=" + subTicket.price + "€ }");
            }
        }

        System.out.println("\n");
        System.out.println("There are " + ticketManager.count + " reservations added to the list \n");


        //my 11th reservation --> error
        //System.out.println("Adding an 11th ticket...");
        Ticket extraticket = new Ticket(date,20,true);//cost 20 euros, date, available
        //ticketManager.addReservation(extraticket);


        //applying the discount
        /*
        Ticket ticketneo = new Ticket(new Date(), 50.0, true);
        System.out.println("Example ticket with discount with price : " + ticketneo.price + "€" + " available : " + ticketneo.available);
        ticketneo.applyDiscount(20.0);//will return 40 in this example
        System.out.println("\n");
         */

        /*
        //It works, the error message is thrown when percentage is invalid
        Ticket ticket = new Ticket(new Date(), 50.0, true);
        ticket.CheckDiscount(-20.0, 100);
         */

        // Créer un ticket non disponible
        Ticket unavailableTicket = new Ticket(date, 50.0, false);

        //faut créer un customer avec ses paramètres
        Customer c = new Customer("Aurian", "06 52 97 18 47", "Regular");
        //It works, the ticket is unavailable
        //unavailableTicket.reserve(c);

        //Here is the total money of all the tickets
        double totalMoney = ticketManager.calculateTotalIncome();
        System.out.println("Total income : " + totalMoney + " € \n"); //because totalMoney = 6*20 + 4*25

        //Here is the list of all available reservations;
        System.out.println("List of all available reservations : ");
        ticketManager.listAvailableReservations(); // The 6 tickets + the 4 subscription tickets
        System.out.println(ticketManager.reservations_available);

    }
}
