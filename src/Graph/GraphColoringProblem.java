package Graph;
// Vertex coloring is the most common graph coloring problem. The problem is, given m colors, find a way of coloring the vertices of a graph such that no two adjacent vertices are colored using same color
// This is a NP Complete Problem ==> https://www.geeksforgeeks.org/graph-coloring-applications/

// Applications of the Graph Coloring problem:
// 1. Making schedule or time table
// 2. Mobile Radio Frequency Assignment
// 3. Soduku
// 4. Bipartite Graphs
// 5. Map Coloring


// This is greedy Algorithm. Time Complexity O(V^2 + E) in worst case.
// https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GraphColoringProblem {
    static ArrayList<ArrayList<Integer>> adj;
    static class Graph {
        Graph(int V ) {
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        void greedyColoring() {
            int V = adj.size();
            int[] result = new int[V];
            boolean[] avaiable = new boolean [V];

            Arrays.fill(result, -1);
            Arrays.fill(avaiable, true);
            // Assign first color to 0th vertex
            result[0] = 0;

            for (int u= 1; u<V; u++) {

                //first find out the colors not available
                Iterator<Integer> list = adj.get(u).listIterator();
                while (list.hasNext()) {
                    int v = list.next();
                    if (result[v] != -1) {
                        avaiable[result[v]] = false;
                    }
                }

                // find out the available color.
                int cr;
                for (cr = 0; cr < V; cr++) {
                    if (avaiable[cr]) {
                        break;
                    }
                }

                result[u] = cr; // Assign the found color.

                //reset the color array for the next iteration.
                Arrays.fill(avaiable, true);
            }

            //Print the result
            for (int i =0; i<V; i++) {
                System.out.println(" Vertex " + i + "----> Color " + result[i] );
            }
        }
    }
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();

        System.out.println();
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.greedyColoring();
    }
}
