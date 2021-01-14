package Graph;

import java.util.ArrayList;
import java.util.List;

//Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree. There is a cycle in a graph only if there is a
// back edge present in the graph. A back edge is an edge that is from a node to itself (self-loop) or one of its ancestors in the tree produced by DFS.
// In the following graph, there are 3 back edges, marked with a cross sign. We can observe that these 3 back edges indicate 3 cycles present in the graph.

public class DetectCycleInDirectedGraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
    // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;
        return false;
    }

    static boolean isCyclic() {
        boolean[] recStack = new boolean[adj.size()];
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i<adj.size(); i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        if(isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't " + "contain cycle");
        }
    }
}
