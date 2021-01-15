package com.vehicles;

/**
 * Class that inherits the Vehicle class.
 * Represents a vehicle of type Car.
 */
public class Car extends Vehicle {
    /**
     * Constructor method, calls super with predefined values.
     */
    public Car() {
        super("Autovehicul", 2, 4);
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "Car.";
    }
}
