package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a Street in the graph.
 */
class Street {
    private Node start;
    private Node end;
    private int cost;
    private int sizeLimit;
    /** List of restrictions. */
    private List<Restriction> restrictions;

    /**
     * Empty constructor for objects of type Street.
     */
    public Street() {
    }

    /**
     * Constructor with parameters for objects of type Street.
     *
     * @param start starting node of street
     * @param end ending node of street
     * @param cost cost of street
     * @param sizeLimit size limit of street
     */
    public Street(Node start, Node end, int cost, int sizeLimit) {
        this.start = start;
        this.end = end;
        this.cost = cost;
        this.sizeLimit = sizeLimit;
        this.restrictions = new ArrayList<>();
    }

    /**
     * Add a new restriction to the list.
     *
     * @param a restriction to be added to the list
     */
    public void addStreetRestriction(Restriction a) {
        restrictions.add(a);
    }

    /**
     * @return sum of all restrictions costs
     */
    public int sumRestrictions() {
        return restrictions.stream()
                .mapToInt(Restriction::getCost)
                .sum();
    }

    /**
     * @return list of restrictions
     */
    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    /**
     * @return starting node of street
     */
    public Node getStart() {
        return start;
    }

    /**
     * @return ending node of street
     */
    public Node getEnd() {
        return end;
    }

    /**
     * @return cost of street
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return size limit of street
     */
    public int getSizeLimit() {
        return sizeLimit;
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "Street between " + this.start.getNodeNumber() + " and " +
                this.end.getNodeNumber() + " with: " + this.cost + " " + this.sizeLimit;
    }
}
