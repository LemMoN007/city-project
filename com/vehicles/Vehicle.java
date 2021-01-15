package com.vehicles;

/**
 * Class representing the vehicles used for traveling.
 */
public class Vehicle {
    private final String type;
    private final int size;
    private final int cost;

    /**
     * Empty constructor for objects of type Vehicle.
     */
    public Vehicle() {
        this.type = "Vehicle";
        this.size = 0;
        this.cost = 0;
    }

    /**
     * Constructor with parameters for objects of type Vehicle.
     *
     * @param type type of vehicle
     * @param size size of vehicle
     * @param cost cost of vehicle
     */
    public Vehicle(String type, int size, int cost) {
        this.type = type;
        this.size = size;
        this.cost = cost;
    }

    /**
     * @return type of vehicle
     */
    public String getType() {
        return type;
    }

    /**
     * @return size of vehicle
     */
    public int getSize() {
        return size;
    }

    /**
     * @return cost of vehicle
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "Vehicle.";
    }
}
