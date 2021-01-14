package Graph;

import java.util.*;
// A bipartite graph is possible if the graph coloring is possible using two colors
// such that vertices in a set are colored with the same color. Note that it is
// possible to color a cycle graph with even cycle using two colors.
// time complexity is O(V+E) where V is the number of vertexes and E is the edges.

// A graph containing odd number of cycles or Self loop  is Not Bipartite.
// https://www.geeksforgeeks.org/bipartite-graph/
public class BipartiteGraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean isBipartiteUtil(int[] color, int src) {
        // we will use only two colors. 1 for first color and 0 for second.
        color[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            Iterator<Integer> iterator = adj.get(u).listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                // if self loop exits, graph is not bipartite.
                if (u == v) {
                    return false;
                }
                // if no color is assigned, then assign the color opposite of u vertex.
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
                // if u and v are of same color, return false.
                else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isBipartite() {
        int V = adj.size();
        int [] color = new int[V];
        Arrays.fill(color, -1);
        // this code will handle the disconnected graph.
        for (int i =0 ; i< V; i++) {
            if (color[i] == -1) {
                if (isBipartiteUtil(color, i) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge( 0, 1);
        addEdge( 0, 3);
        addEdge( 1, 2);
        addEdge( 2, 3);

        if (isBipartite())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
