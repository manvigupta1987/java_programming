package Graph;

// An edge in an undirected connected graph is a bridge iff removing it disconnects the graph. For a disconnected undirected graph, definition is similar, a bridge is an edge removing which increases number of disconnected components.
//The idea is similar to O(V+E) algorithm for Articulation Points. We do DFS traversal of the
// given graph. In DFS tree an edge (u, v) (u is parent of v in DFS tree) is bridge if there
// does not exist any other alternative to reach u or an ancestor of u from subtree rooted
// with v. As discussed in the previous post, the value low[v] indicates earliest visited vertex
// reachable from subtree rooted with v.
// The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]”.

//The above function is simple DFS with additional arrays. So time complexity is same as DFS which is O(V+E) for adjacency list representation of graph.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BridgeInGraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int V = 5;
    static int time = 0;
    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void APUtil(int u, boolean visited[], int disc[],
                       int low[], int parent[]) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        Iterator<Integer> list = adj.get(u).listIterator();
        while (list.hasNext()) {
            int v = list.next();
            if (!visited[v]) {
                parent[v] = u;
                APUtil(v, visited, disc, low, parent);
                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u

                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (disc[u] < low[v]) {
                    System.out.print(u + " " + v);
                    System.out.println();
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void bridge() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);

        for (int i =0; i< V; i++) {
            if (!visited[i]) {
                APUtil(i, visited, disc, low, parent);
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
        bridge();
        System.out.println();

    }
}
