package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// A vertex in an undirected connected graph is an articulation point (or cut vertex) iff removing it (and edges through it) disconnects the graph.
// The idea is to use DFS (Depth First Search). In DFS, we follow vertices in tree form called DFS tree. In DFS tree, a vertex u is parent of another vertex v, if v is discovered by u (obviously v is an adjacent of u in graph). In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
//1) u is root of DFS tree and it has at least two children.
//2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.


// https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
// https://www.youtube.com/watch?v=2kREIkF9UAs


public class ArticulationPoint {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int V = 5;
    static int time = 0;
    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void APUtil(int u, boolean visited[], int disc[],
                       int low[], int parent[], boolean ap[]) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        Iterator<Integer> list = adj.get(u).listIterator();
        while (list.hasNext()) {
            int v = list.next();
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                low[u] = Math.min(low[u], low[v]);
                // node is root node and has more than 1 children
                if (parent[u] == -1 & children > 1) {
                    ap[u] = true;
                }
                //node is not root node but the visited time of the node is less than or equal to the low time of adjacent vertex which indicates that there is no back edge.
                if (parent[u] != -1 && disc[u] <= low[v]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) { // checks if parent of u is equal to v or not. if not, update the low value.
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void AP() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        Arrays.fill(ap, false);

        for (int i =0; i< V; i++) {
            if (!visited[i]) {
                APUtil(i, visited, disc, low, parent, ap);
            }
        }

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.print(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println("Articulation points in first graph ");
        addEdge( 1, 0);
        addEdge( 0, 2);
        addEdge(1, 2);
        addEdge( 0, 3);
        addEdge(3, 4);
        AP();
        System.out.println();
    }
}
