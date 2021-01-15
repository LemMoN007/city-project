package com.vehicles;

/**
 * Class that inherits the Vehicle class.
 * Represents a vehicle of type Motorcycle.
 */
public class Motorcycle extends Vehicle {
    /**
     * Constructor method, calls super with predefined values.
     */
    public Motorcycle() {
        super("Moped", 1, 2);
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "Motorcycle.";
    }
}
