package ooca2;

public class ooca2_Tsolmon {

    public static void main(String[] args) {

        System.out.println("=== OOCA2 Assignment Demo Started ===");

        try {
            // Create reservation
            Reservation reservation = new Reservation(10, 0);
            System.out.println("Reservation created: capacity=" + reservation.getCapacity()
                    + ", booked=" + reservation.getBooked());

            // Create booking (linked to reservation)
            Booking booking = new Booking(1, "Tsolmon", 8, reservation);
            System.out.println("Booking created: " + booking);

            // Confirm
            Action confirm = new ConfirmAction(booking);
            confirm.execute();

            // Modify booked seats to 6
            Action modify = new ModifyAction(reservation, 6);
            modify.execute();

            // Cancel 2 seats
            Action cancel = new CancelAction(reservation, 2);
            cancel.execute();

            System.out.println("=== OOCA2 Assignment Demo Finished Safely ===");

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            System.out.println("=== OOCA2 Assignment Demo Finished Safely ===");
        }
    }
}
