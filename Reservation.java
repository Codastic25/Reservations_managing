import java.util.Date; // found on internet to get a date type variable

abstract class Reservation {

    Date reservationDate; //variable that must looking like a Date

    public Reservation(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public abstract double CalculatePrice();

    public abstract boolean reserve(Customer c); // method for "gérer les réservations"

    public Date getReservationDate() { // method that will return the date of the reservation
        return reservationDate;
    }

}


