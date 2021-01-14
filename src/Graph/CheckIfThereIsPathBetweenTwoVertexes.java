package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Given a Directed Graph and two vertices in it, check whether there is a path from the first given vertex to second.
// This can be done either through BFS or DFS.

public class CheckIfThereIsPathBetweenTwoVertexes {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    static boolean isReachable(int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            Iterator<Integer> list = adj.get(v).listIterator();
            while (list.hasNext()) {
                int node = list.next();
                if (node == dest) {
                    return true;
                }
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge( 0, 1);
        addEdge( 0, 2);
        addEdge(1, 2);
        addEdge( 2, 0);
        addEdge( 2, 3);
        addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        int u = 1;
        int v = 3;

        if (isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

        u = 3;
        v = 1;
        if (isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }
}
