/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooca2.exceptions;

public class ReservationNotFoundException extends Exception {

    public ReservationNotFoundException() {
        super("Reservation not found.");
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }
}

