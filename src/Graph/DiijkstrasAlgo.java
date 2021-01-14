package Graph;


import java.util.*;

// This algorithm works on both direct and undirected graph. The only condition is weight should not be negetive.
//  time complexity is O(VLogV)

public class DiijkstrasAlgo {
    static class Node implements Comparator<Node> {
        int node;
        int cost;

        Node() {}

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.cost < o2.cost) {
                return -1;
            } else if (o1.cost > o2.cost) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    static void addNode(int u, int v, int cost) {
        Node node = new Node(v, cost);
        adj.get(u).add(node);
    }

    static void algo_dijkstra(int source) {
        int[] distance = new int[adj.size()];
        boolean[] visited = new boolean[adj.size()];
        Map<Integer, Integer> parent = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(adj.size(), new Node());

        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(source, 0));
        distance[source] = 0;
        parent.put(source, -1);
        for (int i = 0; i< adj.size(); i++) {
            int u = pq.remove().node;
            visited[u]= true;

            Iterator<Node> iterator = adj.get(u).listIterator();
            while (iterator.hasNext()) {
                Node node1 = iterator.next();
                int v = node1.node;
                int cost = node1.cost;
                if (!visited[v]) {
                    if ((distance[u] + cost) < distance[v]) {
                        distance[v] = distance[u] + cost;
                        parent.put(v, u);
                    }
                    pq.add(new Node(v, distance[v]));
                }
            }
        }

        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Vertex\t\t" + "Distance\t\t" + "Path");
        for (int i = 1; i < distance.length; i++) {
            System.out.print(source + " -> " + i + " \t\t " + distance[i] + " \t\t ");
            printPath(i, parent);
            System.out.println();
        }
    }

    static void printPath(int currentVertex,
                          Map<Integer, Integer> parents)
    {

        // Base case : Source node has
        // been processed
        if (currentVertex == -1) {
            return;
        }
        if (parents.containsKey(currentVertex)) {
            printPath(parents.get(currentVertex), parents);
            System.out.print(currentVertex + " ");
        } else {
            return;
        }
    }


    public static void main(String[] args) {
        int V = 9;
        int source = 0;

        for (int i =0; i<V; i++) {
           adj.add(new ArrayList<Node>());
        }

        addNode(0,1,4);
        addNode(0,7,8);
        addNode(1,0,4);
        addNode(1,2,8);
        addNode(1,7,11);
        addNode(2,1,8);
        addNode(2,3,7);
        addNode(2,5,4);
        addNode(2,8,2);
        addNode(3,2,7);
        addNode(3,4,9);
        addNode(4,3,9);
        addNode(4,5,10);
        addNode(5,2,4);
        addNode(5,4,10);
        addNode(5,6,2);
        addNode(6,3,14);
        addNode(6,5,2);
        addNode(6,7,1);
        addNode(6,8,6);
        addNode(7,0,8);
        addNode(7,1,11);
        addNode(7,6,1);
        addNode(7,8,7);
        addNode(8,2,2);
        addNode(8,6,6);
        addNode(8,7,7);

        algo_dijkstra(source);
    }
}
