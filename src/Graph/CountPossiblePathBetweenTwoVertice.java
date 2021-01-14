package Graph;

// Count the total number of ways or paths that exist between two vertices in a directed graph. These paths don’t contain a cycle,
// the simple enough reason is that a cycle contains an infinite number of paths and hence they create a problem.

// Solution:
//Create a recursive function that takes index of node of a graph and the destination index. Keep a global or a static variable count to store the count.
//If the current nodes is the destination increase the count.
//Else for all the adjacent nodes, i.e. nodes that are accessible from the current node, call the recursive function with the index of adjacent node and the destination.
//Print the Count.

import java.util.*;

public class CountPossiblePathBetweenTwoVertice {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static void addEdge(int u, int v) {
        adj.get(u).add(v);
//        adj.get(v).add(u);
    }

    static int countPathsUtil(int u, int d, int totalpaths) {
        if (u == d) {
            totalpaths++;
        } else {
            Iterator<Integer> iterator = adj.get(u).listIterator();
            while (iterator.hasNext()) {
                totalpaths = countPathsUtil(iterator.next(), d, totalpaths);
            }
        }
        return totalpaths;
    }


    static int countPathsUsingDFS(int u, int d) {
        int totalPaths = 0;
        return countPathsUtil(u, d, totalPaths);
    }

    static List<List<Integer>> printAllPathsUsingBFS(int src, int d) {
        Queue<List<Integer>> queue  = new LinkedList<>();
        List<List<Integer>> path = new ArrayList<>();

        queue.add(Arrays.asList(src));


        while (!queue.isEmpty()) {
            List<Integer> pathSoFar = queue.poll();
            int last = pathSoFar.get(pathSoFar.size() -1);

            if (last == d) {
                path.add(new ArrayList<>(pathSoFar));
            } else {
                Iterator<Integer> iterator = adj.get(last).listIterator();
                while (iterator.hasNext()) {
                    List<Integer> newPath = new ArrayList<>(pathSoFar);
                    newPath.add(iterator.next());
                    queue.add(newPath);
                }
            }
        }
        return path;
    }

    static void printGraph(List<List<Integer>> adj) {
        for (int i =0; i< adj.size(); i++) {
            for (int j = 0; j<adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(1, 4);
        addEdge(2, 4);

        int s = 0, d = 3;
        System.out.println(countPathsUsingDFS(s, d));
        List<List<Integer>> result = printAllPathsUsingBFS(s, d);
        printGraph(result);

    }
}
