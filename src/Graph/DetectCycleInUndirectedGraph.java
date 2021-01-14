package Graph;

import java.util.ArrayList;
import java.util.List;

//Given an undirected graph, how to check if there is a cycle in the graph?
// Time Complexity: O(V+E).

public class DetectCycleInUndirectedGraph {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A recursive function that uses visited[]
    // and parent to detect cycle in subgraph
    // reachable from vertex v.
    static boolean isCyclicUtil(int i, boolean[] visited, int parent) {
        // Mark the current node as visited
        visited[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children) {
            if (!visited[c]) {
                if (isCyclicUtil(c, visited, i)) {
                    return true;
                }
            } // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (c != parent) {
                return true;
            }
        }
        return false;
    }


    static boolean isCyclic() {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i<adj.size(); i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 3;
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(1, 2);

        if(isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't " + "contain cycle");
        }
    }
}
