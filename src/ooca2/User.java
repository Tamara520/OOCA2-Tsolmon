/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooca2;

import ooca2.exceptions.InvalidUserCategoryException;

/**
 * User
 * ----
 * Represents a user in the system.
 *
 * Demonstrates:
 *  - Encapsulation (private fields + getters/setters)
 *  - Validation using a custom checked exception
 *  - Use of enum (UserCategory)
 */
public class User {

    // -----------------------------
    // Fields
    // -----------------------------
    private String name;
    private UserCategory category;

    // -----------------------------
    // Constructor
    // -----------------------------
    public User(String name, UserCategory category)
            throws InvalidUserCategoryException {
        setName(name);
        setCategory(category);
    }

    // -----------------------------
    // Getters
    // -----------------------------
    public String getName() {
        return name;
    }

    public UserCategory getCategory() {
        return category;
    }

    // -----------------------------
    // Setters with validation
    // -----------------------------

    /**
     * Sets the user name.
     *
     * @param name user name
     * @throws InvalidUserCategoryException if name is null or empty
     */
    public void setName(String name)
            throws InvalidUserCategoryException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidUserCategoryException(
                    "User name cannot be empty."
            );
        }

        this.name = name.trim();
    }

    /**
     * Sets the user category.
     *
     * @param category user category
     * @throws InvalidUserCategoryException if category is null
     */
    public void setCategory(UserCategory category)
            throws InvalidUserCategoryException {

        if (category == null) {
            throw new InvalidUserCategoryException(
                    "User category cannot be null."
            );
        }

        this.category = category;
    }

    // -----------------------------
    // toString
    // -----------------------------
    @Override
    public String toString() {
        return "User{name='" + name + "', category=" + category + "}";
    }
}
