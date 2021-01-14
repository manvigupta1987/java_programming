package Graph;

// A spanning tree is a subset of Graph G, which has all the vertices covered with minimum possible number of edges. Hence, a spanning tree does not have cycles and it cannot be disconnected..
//By this definition, we can draw a conclusion that every connected and undirected Graph G has at least one spanning tree. A disconnected graph does not have any spanning tree, as it cannot be spanned to all its vertices.
// A complete undirected graph can have maximum nn-2 number of spanning trees, where n is the number of nodes. In the above addressed example, n is 3, hence 33−2 = 3 spanning trees are possible.

// Minimum Spanning Tree:
// In a weighted graph, a minimum spanning tree is a spanning tree that has minimum weight than all other spanning trees of the same graph.
// The time complexity for the matrix representation is O(V^2). In this post, O(ELogV) algorithm for adjacency list representation is discussed.

// https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/

import javafx.util.Pair;

import java.util.*;

public class PrimsMinimumSpanningTreeAlgo {
    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class ResultSet {
        int parent;
        int weight;
    }
    static int V= 9;
    static LinkedList<Edge>[] adj = new LinkedList[V];

    static void addEdge(int u, int v, int cost) {
        Edge edge1 = new Edge(v, cost);
        Edge edge2 = new Edge(u, cost);

        adj[u].addFirst(edge1);
        adj[v].addFirst(edge2);
    }

    static void PrimMST() {
        boolean[] mst = new boolean[V];
        ResultSet[] result = new ResultSet[V];
        int [] distance = new int[V]; // this is used to store the key to know whether priority queue update is required.

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            result[i] = new ResultSet();
        }

        // priority queue contains the pair of weight n vertex such that it can be arranged as per  weight.
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        distance[0]= 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);
        pq.offer(p0);
        result[0].parent = -1;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> extractedPair = pq.poll();
            int extractedVertex = extractedPair.getValue();
            mst[extractedVertex] = true;

            Iterator<Edge> iterator = adj[extractedVertex].listIterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                int destination = edge.dest;
                int weight = edge.weight;
                if (mst[destination] == false) {
                    if (distance[destination] > weight) {
                        Pair<Integer, Integer> p = new Pair<>(weight, destination);
                        pq.offer(p);
                        result[destination].parent = extractedVertex;
                        result[destination].weight = weight;
                        distance[destination] = weight;
                    }
                }
            }
        }

        int total_min_weight = 0;
        System.out.println("Minimum Spanning Tree: ");
        for (int i = 1; i <V ; i++) {
            System.out.println("Edge: " + result[i].parent + " - " + i +
                    " weight: " + result[i].weight);
            total_min_weight += result[i].weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }

    public static void main(String[] args) {
        for (int i =0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }

        addEdge(0, 1, 4);
        addEdge( 0, 7, 8);
        addEdge( 1, 2, 8);
        addEdge( 1, 7, 11);
        addEdge( 2, 3, 7);
        addEdge( 2, 8, 2);
        addEdge( 2, 5, 4);
        addEdge( 3, 4, 9);
        addEdge( 3, 5, 14);
        addEdge( 4, 5, 10);
        addEdge( 5, 6, 2);
        addEdge( 6, 7, 1);
        addEdge( 6, 8, 6);
        addEdge( 7, 8, 7);

        PrimMST();
    }
}
