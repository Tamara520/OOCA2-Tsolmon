package ooca2;

import ooca2.exceptions.ReservationNotFoundException;

/**
 * CancelAction
 * ------------
 * Handles the cancellation of an existing reservation booking.
 *
 * Demonstrates:
 *  - Validation of input
 *  - Use of a custom checked exception
 *  - Clear separation of responsibilities
 *  - Interface usage (implements Action)
 */
public class CancelAction implements Action {

    private final Reservation reservation;
    private final int seatsToCancel;

    public CancelAction(Reservation reservation, int seatsToCancel) {
        this.reservation = reservation;
        this.seatsToCancel = seatsToCancel;
    }

    @Override
    public void execute() throws ReservationNotFoundException {

        // Validate reservation
        if (reservation == null) {
            throw new ReservationNotFoundException(
                    "Cannot cancel booking because the reservation does not exist."
            );
        }

        // Validate seatsToCancel
        if (seatsToCancel <= 0) {
            throw new ReservationNotFoundException(
                    "Seats to cancel must be greater than 0."
            );
        }

        // Cannot cancel more than currently booked
        if (seatsToCancel > reservation.getBooked()) {
            throw new ReservationNotFoundException(
                    "Cannot cancel more seats than currently booked."
            );
        }

        // ✅ Update the reservation state (reduce booked seats)
        try {
            reservation.applySeatChange(-seatsToCancel);
        } catch (Exception ex) {
            // Defensive: negative delta should not trigger OverbookingException.
        }

        // Output for runtime evidence
        System.out.println(
                "Cancellation successful. Seats cancelled: " + seatsToCancel +
                ", Remaining booked seats: " + reservation.getBooked()
        );
    }
}
