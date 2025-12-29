/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ooca2;

/**
 * Action
 * ------
 * Common interface for all actions (Confirm/Modify/Cancel).
 * Demonstrates polymorphism and scalable OO design.
 */
public interface Action {
    void execute() throws Exception;
}