package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

// , the Longest Path problem is NP-Hard for a general graph. However, the longest path problem has a linear time solution for directed acyclic graphs.
// The idea is similar to linear time solution for shortest path in a directed acyclic graph., we use Topological Sorting.

// We initialize distances to all vertices as minus infinite and distance to source as 0, then we find a topological sorting of the graph.
// Topological Sorting of a graph represents a linear ordering of the graph
// Once we have topological order (or linear representation), we one by one process all vertices in topological order. For every vertex being processed,
// we update distances of its adjacent using distance of current vertex.

// https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
public class LongestPathInDAG {
    static class Edge {
        int v;
        int weight;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

    static void addEdge(int u, int v, int weight) {
        Edge edge = new Edge(v, weight);
        adj.get(u).add(edge);
    }

    static void topologicalSortUtil(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;

        Iterator<Edge> iterator = adj.get(u).listIterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();

            if (!visited[edge.v]) {
                topologicalSortUtil(edge.v, visited, stack);
            }
        }
        stack.push(u);
    }

    static void longestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for (int i =0; i<adj.size(); i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[src] = 0;
        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                Iterator<Edge> iterator = adj.get(u).listIterator();
                while (iterator.hasNext()) {
                    Edge edge = iterator.next();

                    if (dist[edge.v] < dist[u] + edge.weight) {
                        dist[edge.v] = dist[u] + edge.weight;
                    }
                }
            }
        }

        for (int i = 0; i<adj.size(); i++) {
            if (dist[i] == Integer.MIN_VALUE) {
                System.out.println("INF");
            } else {
                System.out.print( dist[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i< 6; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0, 1, 5);
        addEdge(0, 2, 3);
        addEdge(1, 3, 6);
        addEdge(1, 2, 2);
        addEdge(2, 4, 4);
        addEdge(2, 5, 2);
        addEdge(2, 3, 7);
        addEdge(3, 5, 1);
        addEdge(3, 4, -1);
        addEdge(4, 5, -2);

        int src = 1;

        longestPath(src);
    }


}
