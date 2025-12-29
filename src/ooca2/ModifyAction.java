package ooca2;

import ooca2.exceptions.OverbookingException;
import ooca2.exceptions.ReservationNotFoundException;

/**
 * ModifyAction
 * ------------
 * Handles modification of an existing reservation.
 *
 * Demonstrates:
 *  - Action-based class design (Single Responsibility Principle)
 *  - Validation before modification
 *  - Use of custom checked exceptions
 *  - Interface usage (implements Action)
 */
public class ModifyAction implements Action {

    private final Reservation reservation;
    private final int newSeatCount;

    public ModifyAction(Reservation reservation, int newSeatCount) {
        this.reservation = reservation;
        this.newSeatCount = newSeatCount;
    }

    @Override
    public void execute() throws ReservationNotFoundException, OverbookingException {

        // Validate reservation
        if (reservation == null) {
            throw new ReservationNotFoundException(
                    "Cannot modify reservation because it does not exist."
            );
        }

        // Validate new seat count
        if (newSeatCount <= 0) {
            throw new OverbookingException(
                    "New seat count must be greater than 0."
            );
        }

        // Calculate difference between new and current bookings
        int currentBooked = reservation.getBooked();
        int delta = newSeatCount - currentBooked;

        // Apply change using central business rule
        reservation.applySeatChange(delta);

        // Output for runtime evidence
        if (delta > 0) {
            System.out.println(
                    "Booking increased from " + currentBooked +
                    " to " + newSeatCount
            );
        } else if (delta < 0) {
            System.out.println(
                    "Booking reduced from " + currentBooked +
                    " to " + newSeatCount
            );
        } else {
            System.out.println("No changes made to the reservation.");
        }

        System.out.println(
                "Reservation modification completed. Current booked seats: "
                        + reservation.getBooked()
        );
    }
}
