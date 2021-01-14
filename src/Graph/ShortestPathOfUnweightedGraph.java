package Graph;

// Given an unweighted graph, a source, and a destination, we need to find the shortest path from source to destination in the graph in the most optimal way.
// https://www.geeksforgeeks.org/shortest-path-unweighted-graph/

//One solution is to solve in O(VE) time using Bellman–Ford. If there are no negative weight cycles, then we can solve in O(E + VLogV) time using Dijkstra’s algorithm.
//Since the graph is unweighted, we can solve this problem in O(V + E) time. The idea is to use a modified version of Breadth-first search in which we keep storing the
// predecessor of a given vertex while doing the breadth-first search. This algorithm will work even when negative weight cycles are present in the graph.

import java.util.*;

public class ShortestPathOfUnweightedGraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int V = 8;

    static void add_edge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean BFS(int[] parents, int[] dist, int src, int dest) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);
        dist[src] = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            Iterator<Integer> iterator = adj.get(node).listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[node] + 1;
                    parents[v] = node;
                    queue.add(v);

                    if (v == dest) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void printShortestPath(int src, int dest) {
        int[] parents = new int[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        if (!BFS(parents, dist, src, dest)) {
            System.out.println("Source and destination are not connected");
            return;
        }
        System.out.println("Shortest path length is: " + dist[dest]);
        System.out.println("Path is ::");
        int crawl = dest;
        System.out.print(crawl + " ");
        while (parents[crawl] != -1) {
            System.out.print(parents[crawl] + " " );
            crawl = parents[crawl];
        }
    }


    public static void main(String[] args) {
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        add_edge(0, 1);
        add_edge(0, 3);
        add_edge( 1, 2);
        add_edge( 3, 4);
        add_edge( 3, 7);
        add_edge( 4, 5);
        add_edge( 4, 6);
        add_edge( 4, 7);
        add_edge( 5, 6);
        add_edge( 6, 7);

        int source = 2, dest = 6;
        printShortestPath(source, dest);
    }
}
