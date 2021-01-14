package Graph;

// Eulerian Path is a path in graph that visits every edge exactly once.
// Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex.
// A graph is called Eulerian if it has an Eulerian Cycle and called Semi-Eulerian if it has an Eulerian Path.

// Condition for Eulerian Cycle:
//... All vertices with non-zero degree are connected.
//... All the vertices should have even degree

// Condition for Eulerian Path:
//... All vertices with non-zero degree are connected.
//... One or two vertices can have odd degree while all other vertices have even degree. Note that only one
// vertex with odd degree is not possible in an undirected graph (sum of all degrees is always even in an undirected graph)

//Note that a graph with no edges is considered Eulerian because there are no edges to traverse.
// https://www.geeksforgeeks.org/eulerian-path-and-circuit/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class EulerianPathAndCycle {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int V = 5;
    static int time = 0;
    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void DFSUtil(boolean[] visited, int src) {
        visited[src] = true;
        Iterator<Integer> iterator = adj.get(src).listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!visited[v]) {
                DFSUtil(visited, v);
            }
        }
    }

    static boolean isConnected(boolean[] visited) {
        // first findout the non zero degree node
        int i;
        for (i =0; i< V; i++) {
            if (adj.get(i).size() > 0) {
                break;
            }
        }

        // if no edges are found.
        if (i == V) {
            return true;
        }
        // run DFS from this node.
        DFSUtil(visited, i);

        //check if all the non zero degree nodes are visited or not.
        for (i =0; i< V; i++) {
            if (visited[i] == false && adj.get(i).size() > 0) {
                return false;
            }
        }
        return true;
    }

    /* The function returns one of the following values
       0 --> If grpah is not Eulerian
       1 --> If graph has an Euler path (Semi-Eulerian)
       2 --> If graph has an Euler Circuit (Eulerian)  */
    static int isEulerian() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        //Step 1: Check if all non zero degree nodes are connected or not
        if (!isConnected(visited)) {
            return 0;
        }

        //Step 2: Find the odd degree vertexes
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() %2 != 0) {
                odd++;
            }
        }
        // If count is more than 2, then graph is not Eulerian
        if (odd > 2) {
            return 0;
        }

        // If odd count is 2, then semi-eulerian.
        // If odd count is 0, then eulerian
        // Note that odd count can never be 1 for undirected graph
        return (odd == 0) ? 2 : 1;
    }

    static void test() {
        int res = isEulerian();
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
            System.out.println("graph has a Euler cycle");
    }

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge( 1, 0);
        addEdge( 0, 2);
        addEdge(1, 2);
        addEdge( 0, 3);
        addEdge(3, 4);
        addEdge(4, 0);

        test();
    }
}
