package Hashing;

import java.util.HashMap;
import java.util.Map;

// Given a list of tickets, find itinerary in order using the given list.
//
//Example:
//
//Input:
//"Chennai" -> "Banglore"
//"Bombay" -> "Delhi"
//"Goa"    -> "Chennai"
//"Delhi"  -> "Goa"
//
//Output:
//Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,

// Solution:
// One Solution is to build a graph and do Topological Sorting of the graph. Time complexity of this solution is O(n).
//
// Second: We can also use hashing to avoid building a graph. The idea is to first find the starting point. A starting point would never be on ‘to’ side of a ticket.
// Once we find the starting point, we can simply traverse the given map to print itinerary in order.


public class PrintIternary {
    static void printResult(Map<String, String> map) {
        // create a reverse map with key as value and value as key.
        HashMap<String, String> reverseMap = new HashMap<>();

        for (Map.Entry<String, String> entry: map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        // find the key which is not present in the reverse map as it will be our starting point.
        String startingPoint = "";
        for (Map.Entry<String, String> entry: map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                startingPoint = entry.getKey();
                break;
            }
        }

        // Traverse the map with the help of starting point.
        String to = map.get(startingPoint);
        while (to != null) {
            System.out.print(startingPoint + " -> " + to + " ");
            startingPoint = to;
            to = map.get(startingPoint);
        }

    }
    public static void main(String[] args)
    {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);
    }
}
