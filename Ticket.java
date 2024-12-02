import java.util.Date;

public class Ticket extends Reservation implements Discountable {

    double price; // price of the ticket
    boolean available; // available or not


    public Ticket(Date reservationDate, double price, boolean available) {
        super(reservationDate);
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Ticket { price=" + price + "€" + ", available=" + available + " }";
    }

    @Override
    public double CalculatePrice() { // will return the price of the ticket
        return price;
    }

    @Override
    public boolean reserve(Customer c) { // method to "gérer les réservations d'un certain client"
        if (!available) {
            System.out.println("Ticket is not available for " + c.getName() + " on " + getReservationDate());
            return false;
        }
        available = false;
        System.out.println("Ticket reserved successfully for " + c.getName() + " on " + getReservationDate());
        return true;

    }

    @Override
    public double applyDiscount(double percentage) { // reduce the price of the ticket by a given percentage
        // me donne le prix réduit
        double finalPrice = (int) (price*(1-(percentage / 100)));
        System.out.println("Percentage discount : " + percentage + "%");
        //System.out.println("The final price : " + finalPrice + "€");
        this.price = finalPrice; // Met à jour le champ `price` de l'objet
        return finalPrice;
    }

    public void CheckDiscount(double percentage, double maxDiscount) throws InvalidDiscountException { // method to applies the reduction but not go more than the maxDiscount available

        if (percentage > maxDiscount) { //pretends that maxDiscount = 100
            throw new InvalidDiscountException("Le pourcentage de réduction est invalide : " + percentage);
        } else if (percentage < 0) {
            throw new InvalidDiscountException("Le pourcentage de réduction est invalide : " + percentage);
        }
        available = true;
    }

    //I need this method to not have error but I don't need it
    @Override
    public double calculateFinalPrice(double basePrice) {
        return 0;
    }

}
