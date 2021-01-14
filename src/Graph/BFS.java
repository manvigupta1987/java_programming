package Graph;

// BFS (G, s)                   //Where G is the graph and s is the source node
//      let Q be queue.
//      Q.enqueue( s ) //Inserting s in queue until all its neighbour vertices are marked.
//
//      mark s as visited.
//      while ( Q is not empty)
//           //Removing that vertex from queue,whose neighbour will be visited now
//           v  =  Q.dequeue( )
//
//          //processing all the neighbours of v
//          for all neighbours w of v in Graph G
//               if w is not visited
//                        Q.enqueue( w )             //Stores w in Q to further visit its neighbour
//                        mark w as visited.
// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    void BFS(ArrayList<ArrayList<Integer>> adj, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();

            System.out.print(start+" ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> list = adj.get(start).listIterator();
            while (list.hasNext()) {
                int node = list.next();

                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }

        }
    }
    void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        BFS g = new BFS();

        g.addEdge(adj,0, 1);
        g.addEdge(adj,0, 2);
        g.addEdge(adj,1, 2);
        g.addEdge(adj,2, 0);
        g.addEdge(adj,2, 3);
        g.addEdge(adj,3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(adj,2);
    }
}
