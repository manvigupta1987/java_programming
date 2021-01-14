package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
// Dijkstra’s algorithm is a Greedy algorithm and time complexity is O(VLogV).
// Dijkstra doesn’t work for Graphs with negative weight edges, Bellman-Ford
// works for such graphs. Bellman-Ford is also simpler than Dijkstra and suites
// well for distributed systems. But time complexity of Bellman-Ford is O(VE),
// which is more than Dijkstra.

public class BellmanFordShortestPath {

    static class Edge {
        int vertex;
        int weight;

        Edge(int node, int cost) {
            this.vertex = node;
            this.weight = cost;
        }
    }

    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static int V = 5;

    static void add_edge(int u, int v, int weight) {
        Edge edge = new Edge(v, weight);
        adj.get(u).add(edge);
    }

    static void BellmanFord(int src) {
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];

        // Step 1: Initialize distances from src to all other vertices as INFINITE
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i =0; i< V-1; i++) {
            for (int j =0; j <V; j++) {
                Iterator<Edge> iterator = adj.get(j).listIterator();
                while (iterator.hasNext()) {
                    Edge edge = iterator.next();
                    int v = edge.vertex;
                    int weight = edge.weight;
                    if (dist[j] != Integer.MAX_VALUE &&
                            (dist[j] + weight) < dist[v]) {
                        dist[v] = dist[j] + weight;
                    }
                }
            }
        }

        for (int j =0; j <V; j++) {
            Iterator<Edge> iterator = adj.get(j).listIterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                int v = edge.vertex;
                int weight = edge.weight;
                if (dist[j] != Integer.MAX_VALUE && (dist[j] + weight) < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        printArr(dist);
    }

    static void printArr(int dist[])
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        add_edge(0, 1, -1);
        add_edge(0, 2, 4);
        add_edge( 1, 2, 3);
        add_edge( 1, 3, 2);
        add_edge( 1, 4, 2);
        add_edge( 3, 1, 1);
        add_edge( 4, 3, -3);

        BellmanFord(0);
    }
}
