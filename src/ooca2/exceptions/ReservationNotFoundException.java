/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package ooca2.exceptions;

/**
 * Thrown when an operation is attempted on a non-existent reservation.
 */
public class ReservationNotFoundException extends Exception {

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
