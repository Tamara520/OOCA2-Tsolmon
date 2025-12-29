/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooca2;

/**
 * Item
 * ----
 * Base class for items in the system.
 *
 * Demonstrates:
 *  - Encapsulation (private fields)
 *  - Validation (defensive programming)
 *  - Inheritance support (subclasses like FoodItem)
 */
public class Item {

    private String name;
    private double price;

    public Item(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public final void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            // In a larger system, you could throw a custom exception here
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        this.name = name.trim();
    }

    public final void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Item price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + price + "}";
    }
}
