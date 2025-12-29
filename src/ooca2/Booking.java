package ooca2;

import ooca2.exceptions.OverbookingException;

/**
 * Booking
 * -------
 * Represents a booking request/record in the system.
 *
 * Demonstrates:
 *  - Encapsulation (private fields + getters/setters)
 *  - Input validation (defensive programming)
 *  - Throwing a custom checked exception when business rules are broken
 */
public class Booking {

    private int bookingId;
    private String customerName;
    private int seatsRequested;

    // Optional: link to a Reservation object (capacity rules)
    private Reservation reservation;

    /**
     * Creates a booking without linking to a reservation.
     */
    public Booking(int bookingId, String customerName, int seatsRequested) {
        setBookingId(bookingId);
        setCustomerName(customerName);
        setSeatsRequested(seatsRequested);
    }

    /**
     * Creates a booking linked to a Reservation object.
     */
    public Booking(int bookingId, String customerName, int seatsRequested, Reservation reservation) {
        setBookingId(bookingId);
        setCustomerName(customerName);
        setSeatsRequested(seatsRequested);
        setReservation(reservation);
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatsRequested() {
        return seatsRequested;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setBookingId(int bookingId) {
        if (bookingId <= 0) {
            throw new IllegalArgumentException("Booking ID must be a positive number.");
        }
        this.bookingId = bookingId;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.customerName = customerName.trim();
    }

    public void setSeatsRequested(int seatsRequested) {
        if (seatsRequested <= 0) {
            throw new IllegalArgumentException("Seats requested must be greater than 0.");
        }
        this.seatsRequested = seatsRequested;
    }

    public void setReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation cannot be null.");
        }
        this.reservation = reservation;
    }

    /**
     * Applies this booking to the linked Reservation capacity rules.
     */
    public void applyToReservation() throws OverbookingException {
        if (reservation == null) {
            throw new OverbookingException("No reservation linked. Cannot apply booking.");
        }
        reservation.addBooking(seatsRequested);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", seatsRequested=" + seatsRequested +
                ", reservationLinked=" + (reservation != null) +
                '}';
    }
}
