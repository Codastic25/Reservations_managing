
import java.util.Date;

public class SubscriptionTicket extends Ticket {

    int series; // variable for subscription series number for the ticket

    public SubscriptionTicket(int series, Date reservationDate, double price, boolean available) {
        super(reservationDate, price, available);
        this.series = series;
    }

    @Override
    public String toString() {
        return "SubscriptionTicket { series=" + series + ", price=" + price + "€" + ", available=" + available + " }";
    }

    @Override
    public boolean reserve(Customer c) { // method to "gérer les réservations d'un certain client" + subscription-based reservations
        if (!available) {
            System.out.println("Ticket is not available for " + c.getName() + " on " + getReservationDate());
            return false;
        }
        available = false;
        System.out.println("Ticket reserved successfully for " + c.getName() + " on " + getReservationDate() + " for the numero series : " + series);
        return true;

    }

    @Override
    public double CalculatePrice(){
        return price;
    }
}
