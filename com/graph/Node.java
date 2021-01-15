package com.graph;

import java.util.Comparator;

/**
 * Representation of a Node in the graph.
 */
class Node implements Comparator<Node> {
    private String name;
    private int nodeNumber;
    private int cost;

    /**
     * Empty constructor for objects of type Node.
     */
    public Node() {
    }

    /**
     * Constructor with parameters for objects of type Node.
     *
     * @param nodeNumber the number of the node
     */
    public Node(int nodeNumber) {
        this.name = "P" + nodeNumber;
        this.nodeNumber = nodeNumber;
        this.cost = 0;
    }

    /**
     * Constructor with parameters for objects of type Node.
     *
     * @param nodeNumber the number of the node
     * @param cost the cost of the node
     */
    public Node(int nodeNumber, int cost) {
        this.name = "P" + nodeNumber;
        this.nodeNumber = nodeNumber;
        this.cost = cost;
    }

    /**
     * Compares 2 objects of type Node using the cost.
     *
     * @param node1 first node
     * @param node2 second node
     * @return comparison of the 2 nodes using cost
     */
    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.cost, node2.cost);
    }

    /**
     * @return name of node
     */
    public String getName() {
        return name;
    }

    /**
     * @return number of node
     */
    public int getNodeNumber() {
        return nodeNumber;
    }

    /**
     * @return cost of node
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return representation of object as a string
     */
    @Override
    public String toString() {
        return "Node " + this.nodeNumber;
    }
}
