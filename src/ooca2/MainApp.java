package ooca2;

import ooca2.exceptions.OverbookingException;
import ooca2.exceptions.ReservationNotFoundException;

/**
 * MainApp
 * -------
 * Entry point: demonstrates try-catch-finally + Action interface usage.
 */
public class MainApp {

    public static void main(String[] args) {

        System.out.println("=== Application Started ===");

        try {
            // 1) Create reservation
            Reservation reservation = new Reservation(10, 0);
            System.out.println("Reservation created: capacity=" + reservation.getCapacity()
                    + ", booked=" + reservation.getBooked());

            // 2) Create booking linked to reservation
            Booking booking = new Booking(1, "Tsolmon", 8, reservation);
            System.out.println("Booking created: " + booking);

            // 3) Confirm booking (polymorphism)
            Action confirm = new ConfirmAction(booking);
            confirm.execute();

            // 4) Modify booking to 6 seats
            Action modify = new ModifyAction(reservation, 6);
            modify.execute();

            // 5) Cancel 2 seats
            Action cancel = new CancelAction(reservation, 2);
            cancel.execute();

            System.out.println("=== Demo Completed Successfully ===");

        } catch (ReservationNotFoundException e) {
            System.out.println("Reservation error: " + e.getMessage());

        } catch (OverbookingException e) {
            System.out.println("Overbooking error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());

        } finally {
            System.out.println("=== Application Finished Safely ===");
        }
    }
}
