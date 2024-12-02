import java.util.ArrayList;

public class TicketManager {

    int count; // nombre de réservations actuelles
    ArrayList<Reservation> reservations;
    ArrayList<Reservation> reservations_available;


    public TicketManager(int count) {
        this.count = count;
        this.reservations = new ArrayList<>(10);//Max place = 10 objects
        this.reservations_available = new ArrayList<>();
    }

    public void addReservation(Reservation r) throws ArrayFullException {

        if (reservations.size() > 10) { // 10 for the example in the TP
            throw new ArrayFullException("There is no possible reservations because the array is full, sorry guys...");
        }
        else {
            reservations.add(r);// j'ajoute un objet reservation à la liste des reservations à chaque fois que j'utilise cette méthode
            count++;
        }
    }

    public void listAvailableReservations(){ //methode pour parcourir la liste des réservations et garder que les réservations disponibles
        for (Reservation r : reservations) {
            Ticket ticket = (Ticket) r;
            if (ticket.available) {// I'm trying to use the available in Ticket to add in my new list only the available tickets
                reservations_available.add(r);
            }
        }

        for (Reservation r : reservations_available) {
            Ticket ticket = (Ticket) r;
        }
    }

    public double calculateTotalIncome(){
        double summation = 0.0;
        for (Reservation r : reservations) {
            Ticket ticket = (Ticket) r;
            summation = summation + ticket.price; //my summation variable will return the total price of all tickets in the list
        }

        return summation;
    }
}
