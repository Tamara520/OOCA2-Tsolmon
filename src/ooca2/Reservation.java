package ooca2;

import ooca2.exceptions.OverbookingException;

/**
 * Reservation
 * -----------
 * Represents a reservation with capacity control.
 *
 * Demonstrates:
 *  - Encapsulation (private fields + getters)
 *  - Business rule enforcement
 *  - Throwing a custom checked exception
 */
public class Reservation {

    private final int capacity;   // Maximum allowed seats
    private int booked;           // Currently booked seats

    public Reservation(int capacity, int booked) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        if (booked < 0 || booked > capacity) {
            throw new IllegalArgumentException("Invalid initial booked value.");
        }
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
     * Adds seats to the reservation.
     *
     * @param number number of seats to add
     * @throws OverbookingException if the request is invalid or exceeds capacity
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
     * Applies a seat change based on delta.
     * delta > 0 → increase, delta < 0 → decrease
     */
    public void applySeatChange(int delta) throws OverbookingException {
        int newBooked = booked + delta;

        if (newBooked < 0) {
            newBooked = 0;
        }

        if (newBooked > capacity) {
            throw new OverbookingException(
                "Cannot apply seat change (delta=" + delta + "). Capacity=" + capacity +
                ", currently booked=" + booked
            );
        }

        booked = newBooked; // ✅ ACTUAL update
    }
}
