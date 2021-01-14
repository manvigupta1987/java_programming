package Graph;

// Given a directed graph, find out whether the graph is strongly connected or not. A directed graph is strongly connected if there is a path between any two pair of vertices.
// It is easy for undirected graph, we can just do a BFS and DFS starting from any vertex. If BFS or DFS visits all vertices,
// then the given undirected graph is connected. This approach won’t work for a directed graph.

// Approaches to find connectivity in Directed graph:
// 1. Floyd Warshal Algo --> complexitity is O(V3)
// 2. Perform DFS V times for every vertex. if any DFS, doesnt visit all vertices, then graph is not strongly connected. This takes O(V*(V+E)) time.
// 3. A better approach is strongly connected components algorithm. We can find all SCCs in O(V+E) time. If number of SCCs is one, then graph is strongly connected. The algorithm for SCC does extra work as it finds all SCCs.
// Following is the Kosaraju's DFS based algo that does two DFS traversals.

// Steps required for this problem statement:
// 1) Initialize all vertices as not visited.
//2) Do a DFS traversal of graph starting from any arbitrary vertex v.
//3) Traverse visited array and check If DFS traversal doesn’t visit all vertices, then return false.
//4) Reverse all arcs (or find transpose or reverse of graph)
//5) Mark all vertices as not-visited in visited array for reversed graph.
//6) Do a DFS traversal of reversed graph starting from same vertex v (Same as step 2). If DFS traversal doesn’t visit all vertices, then return false. Otherwise return true.


// The idea is, if every node can be reached from a vertex v, and every node can reach v, then the graph is strongly connected.
// In step 2, we check if all vertices are reachable from v. In step 4, we check if all vertices can reach v (In reversed graph,
// if all vertices are reachable from v, then all vertices can reach v in original graph).

// https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/

public class ConnectivityInDirectedGraph {
    public static void main(String[] args) {
        // implemented almost same as KosaRaju's strongly connected component algo.
    }
}
