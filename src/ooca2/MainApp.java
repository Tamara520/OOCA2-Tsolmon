package ooca2;

import ooca2.exceptions.InvalidUserCategoryException;
import ooca2.exceptions.OverbookingException;

/**
 * MainApp
 * -------
 * Entry point for Figure 5 – Successful Booking Output
 */
public class MainApp {

    public static void main(String[] args) {

        System.out.println("=== Application Started ===");

        try {
            // Create user
            User user = new User("Tsolmon", UserCategory.STANDARD);
            System.out.println("User created: " + user.getName() + " (" + user.getCategory() + ")");

            // Create reservation (capacity = 10, booked = 8)
            Reservation reservation = new Reservation(10, 8);
            System.out.println(
                "Reservation created: capacity=" +
                reservation.getCapacity() +
                ", booked=" +
                reservation.getBooked()
            );

        reservation.addBooking(5); // 8 + 5 = 13 → OVERBOOKING
        
        
            System.out.println("Booking successful.");

        } catch (InvalidUserCategoryException e) {
            System.out.println("User Error: " + e.getMessage());

        } catch (OverbookingException e) {
            System.out.println("Booking Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());

        } finally {
            System.out.println("=== Application Finished Safely ===");
        }

        System.out.println("Program did not crash.");
    }
}
