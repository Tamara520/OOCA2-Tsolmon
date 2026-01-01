package ooca2;

import ooca2.exceptions.OverbookingException;

/**
 * Reservation
 * -----------
 * Central business rules for capacity + booked seats.
 */
public class Reservation {

    private final int capacity;
    private int booked;

    public Reservation(int capacity, int booked) {
        this.capacity = capacity;
        this.booked = booked;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBooked() {
        return booked;
    }

    /**
     * Adds seats/items to the booking.
     */
    public void addBooking(int number) throws OverbookingException {
        if (number <= 0) {
            throw new OverbookingException("Booking amount must be greater than 0.");
        }
        if (booked + number > capacity) {
            throw new OverbookingException(
                "Booking rejected: requested=" + number +
                ", currentBooked=" + booked +
                ", capacity=" + capacity
            );
        }
        booked += number;
    }

    /**
     * Applies a seat change (delta can be positive or negative).
     * Positive delta increases bookings; negative delta reduces bookings.
     * Business rule: booked must stay within 0..capacity.
     */
    public void applySeatChange(int delta) throws OverbookingException {

        int newBooked = booked + delta;

        if (newBooked < 0) {
            throw new OverbookingException("Booking cannot be reduced below 0.");
        }

        if (newBooked > capacity) {
            throw new OverbookingException(
                "Booking rejected: requestedChange=" + delta +
                ", currentBooked=" + booked +
                ", capacity=" + capacity
            );
        }

        booked = newBooked;
    }
}
