package com.graph;

import com.vehicles.Vehicle;

import java.util.*;

/**
 * Class used for Dijkstra algorithm. Receives a graph and an object of type Vehicle
 * and uses the Dijkstra algorithm to find the shortest path from a source node to
 * every other node.
 *
 * @author Toader George-Catalin
 * @version 1.0
 */
class Dijkstra {
    /** Cost from source to each node. */
    private final int[] costs;
    private final int nrNodes;
    /** Contains already visited nodes, whose lowest cost is determined. */
    private final Set<Integer> visited;
    /** Priority Queue used for finding next lowest cost node. */
    private final PriorityQueue<Node> pQueue;
    /** Vehicle used for traveling. */
    private final Vehicle vehicle;
    /** Map used for shortest path nodes, keeps track of predecessor nodes. */
    private final Map<Node, Node> predecessor;
    /** Graph used for the algorithm. */
    private final Graph graph;

    /**
     * Constructor with parameters for objects of type Dijkstra.
     * Initializes the class variables, receiving as parameters a graph and the vehicle to be used.
     *
     * @param graph the graph used for the algorithm
     * @param vehicle the vehicle used for traveling
     */
    public Dijkstra(Graph graph, Vehicle vehicle) {
        this.nrNodes = graph.getNrNodes();
        this.costs = new int[nrNodes];
        this.visited = new HashSet<>();
        this.pQueue = new PriorityQueue<>(nrNodes, new Node());
        this.predecessor = new HashMap<>();
        this.vehicle = vehicle;
        this.graph = graph;
    }

    /**
     * The Dijkstra algorithm, receives a source node as parameter
     * and finds the shortest path to every other node. Uses a priority queue
     * and an adjacency list.
     *
     * @param source the node used as starting point for the algorithm
     */
    public void algDijkstra(int source) {
        // initialize costs array with maximum values
        for (int i = 0; i < nrNodes; i++)
            costs[i] = Integer.MAX_VALUE;
        // add source node to priority queue and the cost to itself is 0
        pQueue.add(new Node(source, 0));
        costs[source] = 0;
        while (visited.size() != nrNodes && !pQueue.isEmpty()) {
            // get top element from priority queue which has lowest cost
            Node node = pQueue.remove();
            // add node to visited and call method to update costs
            visited.add(node.getNodeNumber());
            adjacentNodes(node);
        }
    }

    /**
     * Updates costs for all unvisited neighbour nodes of the one given as parameter.
     *
     * @param node just visited node used for updating costs
     */
    private void adjacentNodes(Node node)   {
        int current = node.getNodeNumber();
        // all neighbouring nodes of current node
        for (Node next : graph.getAdjList().get(current)) {
            Street street = graph.searchStreet(node, next);
            // check if next node is unvisited and size is ok
            if (!visited.contains(next.getNodeNumber()) && vehicle.getSize() <= street.getSizeLimit()) {
                int streetCost = street.getCost() * vehicle.getCost() + street.sumRestrictions();
                int newCost = costs[current] + streetCost;
                if (newCost < costs[next.getNodeNumber()]) {
                    costs[next.getNodeNumber()] = newCost;
                    predecessor.put(next, graph.searchNode(node.getName()));
                }
                // add next node to priority queue using a copy with new cost
                pQueue.add(new Node(next.getNodeNumber(), costs[next.getNodeNumber()]));
            }
        }
    }

    /**
     * Builds the shortest path used for traveling from source node
     * to target node.
     *
     * @param target node used as ending point for the path
     * @return shortest path between source and target
     */
    public List<Node> getPath(Node target) {
        List<Node> path = new ArrayList<>();
        Node step = target;
        // check if path exists
        if (predecessor.get(step) == null) {
            return null;
        }
        path.add(step);
        // get predecessor of each node on path
        while (predecessor.get(step) != null) {
            step = predecessor.get(step);
            path.add(step);
        }
        // reverse order
        Collections.reverse(path);
        return path;
    }

    /**
     * Minimum cost between source and node.
     *
     * @param node node used as ending point for the path
     * @return the minimum cost from source to the node given as parameter
     */
    public int getMinimumCost(Node node) {
        return costs[node.getNodeNumber()];
    }
}
