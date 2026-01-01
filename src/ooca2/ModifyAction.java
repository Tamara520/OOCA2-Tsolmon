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

        if (reservation == null) {
            throw new ReservationNotFoundException(
                    "Cannot modify reservation because it does not exist."
            );
        }

        if (newSeatCount <= 0) {
            throw new OverbookingException(
                    "New seat count must be greater than 0."
            );
        }

        int currentBooked = reservation.getBooked();
        int delta = newSeatCount - currentBooked;

        // Central business rule check happens here:
        reservation.applySeatChange(delta);

        if (delta > 0) {
            System.out.println("Booking increased from " + currentBooked + " to " + newSeatCount);
        } else if (delta < 0) {
            System.out.println("Booking reduced from " + currentBooked + " to " + newSeatCount);
        } else {
            System.out.println("No changes made to the reservation.");
        }

        System.out.println("Reservation modification completed. Current booked seats: "
                + reservation.getBooked());
    }
}
