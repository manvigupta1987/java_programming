package Graph;

import java.util.*;

// Problem: Given a Weighted Directed Acyclic Graph and a source vertex in the graph, find the shortest paths from given source to all other vertices.
// For a general weighted graph, we can calculate single source shortest distances in O(VE) time using Bellman–Ford Algorithm.
// For a graph with no negative weights, we can do better and calculate single source shortest distances in O(E + VLogV)
// time using Dijkstra’s algorithm. Can we do even better for Directed Acyclic Graph (DAG)? We can calculate single source
// shortest distances in O(V+E) time for DAGs. The idea is to use Topological Sorting.

// Time Complexity: Time complexity of topological sorting is O(V+E). After finding topological order, the algorithm
// process all vertices and for every vertex, it runs a loop for all adjacent vertices. Total adjacent vertices in a
// graph is O(E). So the inner loop runs O(V+E) times. Therefore, overall time complexity of this algorithm is O(V+E).

// https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/

public class ShortestPathForDirectAcyclicGraph {
    static class Node {
        int vertex;
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    static int V = 6;

    static void addEdge(int u, int v, int cost) {
        Node node = new Node(v, cost);
        adj.get(u).add(node);
    }

    static void topologicalSortUtil(boolean[] visited, Stack<Integer> stack, int src) {
        visited[src] = true;

        Iterator<Node> iterator = adj.get(src).listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            int vertex = node.vertex;
            if (!visited[vertex]) {
                topologicalSortUtil(visited, stack, vertex);
            }
        }
        // push the node only when all of its children are visited.
        stack.push(src);
    }

    static void shortestPath(int src) {
        int[] dist = new int[V];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i =0; i<V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(visited, stack, i);
            }
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                Iterator<Node> iterator = adj.get(node).listIterator();
                while (iterator.hasNext()) {
                    Node node1 = iterator.next();
                    int vertex  = node1.vertex;
                    int weight = node1.cost;

                    if ((dist[node] + weight) < dist[vertex]) {
                        dist[vertex] = dist[node] + weight;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        for (int i =0; i<V; i++) {
            adj.add(new ArrayList<Node>());
        }

        addEdge(0, 1, 5);
        addEdge(0, 2, 3);
        addEdge(1, 3, 6);
        addEdge(1, 2, 2);
        addEdge(2, 4, 4);
        addEdge(2, 5, 2);
        addEdge(2, 3, 7);
        addEdge(3, 4, -1);
        addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        shortestPath(s);

    }
}
