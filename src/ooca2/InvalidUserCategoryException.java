/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooca2.exceptions;

/**
 * InvalidUserCategoryException
 * ----------------------------
 * Custom checked exception thrown when an invalid or null user category is provided.
 */
public class InvalidUserCategoryException extends Exception {

    public InvalidUserCategoryException() {
        super("Invalid user category.");
    }

    public InvalidUserCategoryException(String message) {
        super(message);
    }
}

