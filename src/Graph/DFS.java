package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// Pick a starting node and push all its adjacent nodes into a stack.
//Pop a node from stack to select the next node to visit and push all its adjacent nodes into a stack.
//Repeat this process until the stack is empty. However, ensure that the nodes that are visited are marked.
// This will prevent you from visiting the same node more than once. If you do not mark the nodes that are
// visited and you visit the same node more than once, you may end up in an infinite loop.
//  O(V + E), where V is the number of vertices and E is the number of edges in the graph.

public class DFS {
    void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
//        adj.get(v).add(u);
    }

    void DFS_iterative(ArrayList<ArrayList<Integer>> adj, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            start = stack.pop();
            System.out.print(start+" ");
            Iterator<Integer> iterator = adj.get(start).listIterator();
            while (iterator.hasNext()) {
                int node = iterator.next();
                if (!visited[node]) {
                    visited[node] = true;
                    stack.add(node);
                }
            }
        }
    }

    void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");

        Iterator<Integer> iterator = adj.get(start).listIterator();
        while (iterator.hasNext()) {
            int node = iterator.next();

            if (!visited[node]) {
                DFS(adj, visited, node);
            }
        }
    }
    void DFS_recursive(ArrayList<ArrayList<Integer>> adj, int start) {
        boolean[] visited = new boolean[adj.size()];
        DFS(adj, visited, start);
    }

    void DFS_DiconnectedGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i<adj.size(); i++ ) {
            if (!visited[i]) {
                DFS(adj, visited, i);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 4;
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        DFS g = new DFS();

        g.addEdge(adj,0, 1);
        g.addEdge(adj,0, 2);
        g.addEdge(adj,1, 2);
        g.addEdge(adj,2, 0);
        g.addEdge(adj,2, 3);
        g.addEdge(adj,3, 3);



        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.DFS_iterative(adj,2);
        System.out.println("recursive order");
        g.DFS_recursive(adj, 2);

        System.out.println("Disconnected graph");
        g.DFS_DiconnectedGraph(adj);
    }
}
