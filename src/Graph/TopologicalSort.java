package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering.
// Topological Sorting for a graph is not possible if the graph is not a DAG.

// In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. In topological sorting, we use a temporary stack.
// We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack.
// Finally, print contents of the stack. Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are
// already in the stack.

// Time Complexity: O(V+E).

// https://www.youtube.com/watch?v=ddTC4Zovtbc

public class TopologicalSort {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void addEdge (int u, int v) {
        adj.get(u).add(v);
    }

    static void toplogicalSortUtil(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;

        Iterator<Integer> iterator = adj.get(u).listIterator();
        while (iterator.hasNext()) {
            int node = iterator.next();
            if (!visited[node]) {
                toplogicalSortUtil(node, visited, stack);
            }
        }
        // push the node only when all of its children are visited.
        stack.push(u);
    }

    static void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for (int u =0; u< adj.size(); u++) {
            if (!visited[u]) {
                toplogicalSortUtil(u, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(5, 2);
        addEdge(5, 0);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);

        topologicalSort();
    }
}
