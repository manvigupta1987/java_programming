package BackTracking;

import java.util.ArrayList;
import java.util.Iterator;

// Problem: Given a graph, a source vertex in the graph and a number k, find if there is a simple path (without any
// cycle) starting from given source and ending at any other vertex.
// Input  : Source s = 0, k = 58
// Output : True
// There exists a simple path 0 -> 7 -> 1 -> 2 -> 8 -> 6 -> 5 -> 3 -> 4
// Which has a total distance of 60 km which is more than 58.

// One important thing to note is, simply doing BFS or DFS and picking the longest edge at every step would not work.
// The reason is, a shorter edge can produce longer path due to higher weight edges connected through it.
// The idea is to use Backtracking. We start from given source, explore all paths from current vertex. We keep track of
// current distance from source. If distance becomes more than k, we return true. If a path doesn’t produces more than k
// distance, we backtrack.

// https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/

public class FindPathOfMoreThanKLength {
    static class Edge {
        int vertex;
        int weight;

        Edge(int node, int cost) {
            this.vertex = node;
            this.weight = cost;
        }
    }
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static int V = 9;

    static void addEdge(int u, int v, int cost) {
        Edge node1 = new Edge(v, cost);
        Edge node2 = new Edge(u, cost);
        adj.get(u).add(node1);
        adj.get(v).add(node2);
    }

    static boolean findPathMoreThanKUtil(int src, int k, boolean[] visited) {
        if (k <= 0) {
            return true;
        }

        Iterator<Edge> iterator = adj.get(src).listIterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            int v = edge.vertex;
            int weight = edge.weight;

            // If vertex v is already there in path, then there is a cycle (we ignore this edge)
            if (!visited[v]) {
                // If weight of is more than k, return true
                if (weight >= k) {
                    return true;
                }
                visited[v] = true;

                // If this adjacent can provide a path longer than k, return true.
                if (findPathMoreThanKUtil(v, k-weight, visited)) {
                    return true;
                }

                // Backtrack
                visited[v] = false;
            }
        }
        // if no adjacent vertex could produce the result, return false.
        return false;
    }

    static boolean findPathMoreThanK(int src, int k) {
        boolean[] visited = new boolean[V];
        visited[src] = true;

        return findPathMoreThanKUtil(src, k, visited);
    }

    public static void main(String[] args) {
        for (int i =0; i<V; i++) {
            adj.add(new ArrayList<Edge>());
        }

        addEdge(0, 1, 4);
        addEdge(0, 7, 8);
        addEdge(1, 2, 8);
        addEdge(1, 7, 11);
        addEdge(2, 3, 7);
        addEdge(2, 8, 2);
        addEdge(2, 5, 4);
        addEdge(3, 4, 9);
        addEdge(3, 5, 14);
        addEdge(4, 5, 10);
        addEdge(5, 6, 2);
        addEdge(6, 7, 1);
        addEdge(6, 8, 6);
        addEdge(7, 8, 7);

        int src = 0, k = 60;
        if (findPathMoreThanK(src, k)) {
            System.out.println("Yes\n");
        } else {
            System.out.println("No\n");
        }
    }
}

