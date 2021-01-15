package com.graph;

/**
 * Restrictions that appear on a streets and increase its cost.
 */
class Restriction {
    private final String type;
    private final int cost;

    /**
     * Constructor with parameters for objects of type Restriction.
     *
     * @param type type of restriction
     * @param cost cost of restriction
     */
    public Restriction(String type, int cost) {
        this.type = type;
        this.cost = cost;
    }

    /**
     * @return type of restriction
     */
    public String getType() {
        return type;
    }

    /**
     * @return cost of restriction
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "TrafficJam of type " + type + " and cost " + cost;
    }
}
