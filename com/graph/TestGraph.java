package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Core class that reads the input from a file and based
 * on it builds a graph and performs certain actions.
 *
 * @author Toader George-Catalin
 * @version 1.0
 */
public class TestGraph {
    /**
     * Empty constructor for objects of type TestGraph.
     */
    public TestGraph() {
    }

    /**
     * Core method that reads the input from a file, builds
     * a graph using it and then runs multiple commands on that
     * graph.
     */
    public void start() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.in"))) {
            String word;
            String[] values = br.readLine().split(" ");
            int nrStreets = Integer.parseInt(values[0]);
            int nrNodes = Integer.parseInt(values[1]);
            if (nrStreets < 0 || nrNodes < 0)
                return;
            // build graph
            Graph city = new Graph(nrStreets, nrNodes);
            // read input and add streets to graph
            for (int i = 0; i < nrStreets; i++) {
                values = br.readLine().split(" ");
                city.addStreet(city.searchNode(values[0]), city.searchNode(values[1]),
                        Integer.parseInt(values[2]), Integer.parseInt(values[3]));
            }
            // commands
            while ((word = br.readLine()) != null) {
                values = word.split(" ");
                runCommand(values, city);
            }
            city.closeOut();
        } catch (IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }

    /**
     * Runs a specific command on a graph received as parameter.
     *
     * @param values the values in the command
     * @param city graph used for command
     */
    private void runCommand(String[] values, Graph city) {
        if (values[0].equals("drive")) {
            // find shortest path between 2 specific nodes
            city.drive(city.selectVehicle(values[1]), city.searchNode(values[2]), city.searchNode(values[3]));
        } else {
            // add a restriction to the street between the 2 nodes
            city.addRestriction(values[0], city.searchNode(values[1]),
                    city.searchNode(values[2]), Integer.parseInt(values[3]));
        }
    }
}
