/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package ooca2;

/**
 * FoodItem
 * --------
 * Subclass of Item that adds a perishable property.
 *
 * Demonstrates:
 *  - Inheritance (extends Item)
 *  - Additional state in subclass
 *  - Overriding toString()
 */
public class FoodItem extends Item {

    private boolean perishable;

    public FoodItem(String name, double price, boolean perishable) {
        super(name, price);
        this.perishable = perishable;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public String toString() {
        return "FoodItem{name='" + getName() + "', price=" + getPrice()
                + ", perishable=" + perishable + "}";
    }
}
