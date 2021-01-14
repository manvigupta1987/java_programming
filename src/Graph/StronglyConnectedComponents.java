package Graph;

// A directed graph is strongly connected if there is a path between all pairs of vertices. A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph. For example, there are 3 SCCs in the following graph.
// https://www.geeksforgeeks.org/strongly-connected-components/
// We can find all strongly connected components in O(V+E) time using Kosaraju’s algorithm.
// 1) Create an empty stack ‘S’ and do DFS traversal of a graph. In DFS traversal, after calling recursive DFS for adjacent vertices of a vertex, push the vertex to stack. In the above graph, if we start DFS from vertex 0, we get vertices in stack as 1, 2, 4, 3, 0.
//2) Reverse directions of all arcs to obtain the transpose graph.
//3) One by one pop a vertex from S while S is not empty. Let the popped vertex be ‘v’. Take v as source and do DFS (call DFSUtil(v)). The DFS starting from v prints strongly connected component of v. In the above example, we process vertices in order 0, 3, 4, 2, 1 (One by one popped from stack).

//https://www.youtube.com/watch?v=RpgcYiky7uw

// The above algorithm calls DFS, finds reverse of the graph and again calls DFS. DFS takes O(V+E) for a graph represented
// using adjacency list. Reversing a graph also takes O(V+E) time. For reversing the graph, we simple traverse all adjacency
// lists

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponents {

    static class Graph {
        private int V;   // No. of vertices
        private ArrayList<ArrayList<Integer>> adj;

        //Constructor
        Graph(int v) {
            V = v;
            adj = new ArrayList<>();
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<>());
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        void fillOrderUsingDFS(int src, boolean[] visited, Stack<Integer> stack) {
            visited[src] = true;
            Iterator<Integer> iterator = adj.get(src).listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v]) {
                    fillOrderUsingDFS(v, visited, stack);
                }
            }
            stack.push(src);
        }

        Graph transposeGraph() {
            Graph g = new Graph(V);
            for (int i =0; i<V; i++) {
                Iterator<Integer> iterator = adj.get(i).listIterator();
                while (iterator.hasNext()) {
                    g.addEdge(iterator.next(), i);
                }
            }
            return g;
        }

        void DFSUtil(int src, boolean[] visited) {
            visited[src] = true;
            System.out.print(src + " ");
            Iterator<Integer> iterator = adj.get(src).listIterator();
            while (iterator.hasNext()) {
                int node = iterator.next();
                if (!visited[node]) {
                    DFSUtil(node, visited);
                }
            }
        }


        void printSCCs() {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();

            // Step 1: run the DFS on all the vertex and find the vertex order by finish time in the stack
            for (int i =0; i< V; i++) {
                if (!visited[i]) {
                    fillOrderUsingDFS(i, visited, stack);
                }
            }

            // transpose the graph
            Graph gr = transposeGraph();
            Arrays.fill(visited, false);

            // Step3: Take node out from the stack and run DFS on the node.
            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!visited[node]) {
                    gr.DFSUtil(node, visited);
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.printSCCs();
    }
}


