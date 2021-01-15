package com.graph;

import com.vehicles.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used for building a graph. The graph is based
 * on a adjacency list of elements of type Node. The output
 * received after certain commands is written in an output file
 * named "map.out".
 *
 * @author Toader George-Catalin
 * @version 1.0
 */
class Graph {
    private final int nrStreets;
    private final int nrNodes;
    /** List of streets. */
    private final List<Street> streets;
    /** List of nodes. */
    private final List<Node> nodes;
    /** Representation of graph as adjacency list. */
    private final List<List<Node>> adjList;
    /** Output file. */
    protected BufferedWriter out;

    /**
     * Constructor with parameters for objects of type Graph.
     * Initializes the class variables.
     *
     * @param nrStreets number of streets in graph
     * @param nrNodes number of nodes in graph
     */
    public Graph(int nrStreets, int nrNodes) {
        this.nrStreets = nrStreets;
        this.nrNodes = nrNodes;
        this.streets = new ArrayList<>();
        this.nodes = new ArrayList<>();
        this.adjList = new ArrayList<>();
        initializeNodes();
        initializeList();
        initializeOut();
    }

    /**
     * Creates nrNodes objects of type Node and adds them
     * to the list of nodes.
     */
    private void initializeNodes() {
        for (int i = 0; i < nrNodes; i++) {
            nodes.add(new Node(i));
        }
    }

    /**
     * Initializes the adjacency list.
     */
    private void initializeList() {
        for (int i = 0; i < nrNodes; i++) {
            List<Node> line = new ArrayList<>();
            adjList.add(line);
        }
    }

    /**
     * Creates the BufferedWriter used for writing to a file.
     */
    private void initializeOut() {
        try {
            out = new BufferedWriter(new FileWriter("map.out"));
        } catch (IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }

    /**
     * Creates a street with the values given as parameters and adds
     * it to the list of streets.
     *
     * @param start starting node of street
     * @param end ending node of street
     * @param cost the cost of the street
     * @param size the size limit of the street
     */
    public void addStreet(Node start, Node end, int cost, int size) {
        if (start == null || end == null)
            return;
        streets.add(new Street(start, end, cost, size));
        adjList.get(start.getNodeNumber()).add(end);
    }

    /**
     * Adds a restriction to the street between the 2 nodes given
     * as parameters.
     *
     * @param type type of restriction
     * @param start starting node of street
     * @param end ending node of street
     * @param cost the cost of the restriction
     */
    public void addRestriction(String type, Node start, Node end, int cost) {
        // search for the street between the 2 nodes
        Street street = searchStreet(start, end);
        if (street != null) {
            // street found so add restriction
            street.addStreetRestriction(new Restriction(type, cost));
            return;
        }
        System.out.println("Street doesn't exist.");
    }

    /**
     * Finds the shortest path between 2 nodes given as parameters and
     * writes to file the cost and the nodes traveled through.
     * The vehicle chosen will influence the outcome based on its cost
     * and size.
     *
     * @param vehicle vehicle used for traveling the path
     * @param start starting node of path
     * @param end ending node of path
     */
    public void drive(Vehicle vehicle, Node start, Node end) {
        // create new object of type Dijkstra with the current graph and the chosen vehicle
        Dijkstra test = new Dijkstra(this, vehicle);
        // use the algorithm to get the cost and the path
        test.algDijkstra(start.getNodeNumber());
        List<Node> path = test.getPath(end);
        if (path == null) {
            // path does not exist
            writeOut(start.getName() + " " + end.getName() + " null");
            return;
        }
        writeOut(path, test.getMinimumCost(end));
    }

    /**
     * Returns a different type of vehicle based on
     * the value given in string.
     *
     * @param type string used for selecting the type of vehicle
     * @return object of type Vehicle
     */
    public Vehicle selectVehicle(String type) {
        if (type.equals("b"))
            return new Bicycle();
        if (type.equals("m"))
            return new Motorcycle();
        if (type.equals("a"))
            return new Car();
        return new Truck();
    }

    /**
     * Writes to output file the string given as parameter.
     *
     * @param s the message to be written to file
     */
    private void writeOut(String s) {
        try {
            out.write(s + "\n");
        } catch (IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }

    /**
     * Writes to output file the elements in the list and the value.
     *
     * @param path list of nodes representing the path
     * @param value the cost of the path
     */
    private void writeOut(List<Node> path, int value) {
        try {
            for (Node node : path)
                out.write(node.getName() + " ");
            out.write(value + "\n");
        } catch (IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }

    /**
     * Close the output file.
     */
    public void closeOut() {
        try {
            out.close();
        } catch (IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }

    /**
     * Search for an object of type Node by its name
     * in the list of nodes.
     *
     * @param name the name of the object of type Node
     * @return the object of type Node searched for, else null
     */
    public Node searchNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name))
                return node;
        }
        return null;
    }

    /**
     * Search for an object of type Street by its starting and ending
     * nodes in the list of streets.
     *
     * @param start starting node of street
     * @param end ending node of street
     * @return the object of type Street searched for, else null
     */
    public Street searchStreet(Node start, Node end) {
        if (start == null || end == null)
            return null;
        for (Street street : streets) {
            if (street.getStart().getNodeNumber() == start.getNodeNumber() &&
                    street.getEnd().getNodeNumber() == end.getNodeNumber()) {
                return street;
            }
        }
        return null;
    }

    /**
     * @return the list of streets
     */
    public List<Street> getStreets() {
        return streets;
    }

    /**
     * @return the list of nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * @return the adjacency list
     */
    public List<List<Node>> getAdjList() {
        return adjList;
    }

    /**
     * @return number of streets
     */
    public int getNrStreets() {
        return nrStreets;
    }

    /**
     * @return number of nodes
     */
    public int getNrNodes() {
        return nrNodes;
    }

}
