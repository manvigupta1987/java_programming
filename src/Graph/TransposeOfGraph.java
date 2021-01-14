package Graph;

import java.util.ArrayList;

//Transpose of a directed graph G is another directed graph on the same set of vertices with all of the edges reversed compared to the orientation of the corresponding edges in G.
// That is, if G contains an edge (u, v) then the converse/transpose/reverse of G contains an edge (v, u) and vice versa.



public class TransposeOfGraph {
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<ArrayList<Integer>> transposeAdj;

    static void addEdge(int u, int v, boolean transpose) {
        if (!transpose) {
            adj.get(u).add(v);
        } else {
            transposeAdj.get(u).add(v);
        }
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i =0; i< graph.size(); i++) {
            System.out.print(i);
            for (int j = 0; j<graph.get(i).size(); j++) {
                System.out.print(" -> "+graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void transpose() {
        for (int i = 0; i < adj.size(); i++) {
            for (int j =0; j < adj.get(i).size(); j++) {
                int u = adj.get(i).get(j);
                addEdge(u, i, true);
            }
        }
    }

    public static void main(String[] args) {
        adj = new ArrayList<>();
        transposeAdj = new ArrayList<>();
        int V = 5;

        for (int i =0; i< V; i++) {
            adj.add(new ArrayList<>());
            transposeAdj.add(new ArrayList<>());
        }

        addEdge(0, 1, false);
        addEdge(0, 4, false);
        addEdge(0, 3, false);
        addEdge(2, 0, false);
        addEdge(3, 2, false);
        addEdge(4, 1, false);
        addEdge(4, 3, false);

        printGraph(adj);
        transpose();
        System.out.println("=========== After transposing the graph ================");
        printGraph(transposeAdj);

    }
}
