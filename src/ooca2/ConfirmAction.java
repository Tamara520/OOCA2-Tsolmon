package ooca2;

import ooca2.exceptions.OverbookingException;
import ooca2.exceptions.ReservationNotFoundException;

/**
 * ConfirmAction
 * -------------
 * Handles the confirmation of a booking.
 *
 * Demonstrates:
 *  - Action-based class design (Single Responsibility Principle)
 *  - Validation before confirming a booking
 *  - Use of custom checked exceptions
 *  - Interface usage (implements Action)
 */
public class ConfirmAction implements Action {

    private final Booking booking;

    public ConfirmAction(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void execute() throws ReservationNotFoundException, OverbookingException {

        // Validate booking object
        if (booking == null) {
            throw new ReservationNotFoundException("Booking cannot be null.");
        }

        // Validate linked reservation
        Reservation reservation = booking.getReservation();
        if (reservation == null) {
            throw new ReservationNotFoundException("No reservation linked to this booking.");
        }

        // Apply booking using existing reservation business rules
        reservation.addBooking(booking.getSeatsRequested());

        // Confirmation message (for console evidence)
        System.out.println(
                "Booking confirmed successfully. " +
                "Seats booked: " + booking.getSeatsRequested() +
                ", Total booked now: " + reservation.getBooked()
        );
    }
}
