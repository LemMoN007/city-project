package com.vehicles;

/**
 * Class that inherits the Vehicle class.
 * Represents a vehicle of type Bicycle.
 */
public class Bicycle extends Vehicle {
    /**
     * Constructor method, calls super with predefined values.
     */
    public Bicycle() {
        super("Moped", 1, 1);
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "Bicycle.";
    }
}
