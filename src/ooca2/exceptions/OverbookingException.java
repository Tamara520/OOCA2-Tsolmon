/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooca2.exceptions;

/**
 * OverbookingException
 * --------------------
 * Custom checked exception thrown when a booking exceeds capacity
 * or when an invalid booking amount is provided.
 */
public class OverbookingException extends Exception {

    public OverbookingException() {
        super("Overbooking is not allowed.");
    }

    public OverbookingException(String message) {
        super(message);
    }
}
