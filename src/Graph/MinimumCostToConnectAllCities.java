package Graph;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// There are n cities and there are roads in between some of the cities. Somehow all the roads are damaged simultaneously. We have to repair the roads to connect the cities again. There is a fixed cost to repair a particular road. Find out the minimum cost to connect all the cities by repairing roads. Input is in matrix(city) form, if city[i][j] = 0 then there is not any road between city i and city j, if city[i][j] = a > 0 then the cost to rebuild the path between city i and city j is a. Print out the minimum cost to connect all the cities.
//It is sure that all the cities were connected before the roads were damaged.

// https://www.geeksforgeeks.org/minimum-cost-connect-cities/
public class MinimumCostToConnectAllCities {
    static void findcost(int cityNum, int[][] cityArr) {
        boolean[] mst = new boolean[cityNum];
        int[] distance = new int[cityNum];
        int[] parent = new int[cityNum];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        distance[0] = 0;
        parent[0] = -1;
        pq.offer(new Pair<>(distance[0], 0));

        while (!pq.isEmpty()) {
           Pair<Integer, Integer> extractedPair = pq.poll();
           int extractedVertex = extractedPair.getValue();

           mst[extractedVertex] = true;

           for (int v = 0; v < cityNum; v++) {
               int weight = cityArr[extractedVertex][v];
               if (mst[v] == false && cityArr[extractedVertex][v] >0) {
                   if (cityArr[extractedVertex][v] > weight) {
                       cityArr[extractedVertex][v] = weight;
                       Pair<Integer, Integer> p = new Pair<>(weight, v);
                       pq.offer(p);
                       parent[v] = extractedVertex;
                       distance[v] = weight;
                   }
               }
           }
        }
        int cost = 0;
        for (int i = 1; i<cityNum; i++) {
            cost += cityArr[parent[i]][i];
        }
        System.out.println(cost);
    }
    public static void main(String[] args) {
        int n1 = 5;
        int city1[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        findcost(n1, city1);

        int n2 = 6;
        int city2[][] = { { 0, 1, 1, 100, 0, 0 },
                { 1, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0 },
                { 100, 0, 0, 0, 2, 2 },
                { 0, 0, 0, 2, 0, 2 },
                { 0, 0, 0, 2, 2, 0 } };

        findcost(n2, city2);
    }
}
