package Hashing;

import java.util.*;
// Print the elements of an array in the decreasing frequency if 2 numbers have the same frequency then print the one which came first.

//https://leetcode.com/problems/sort-array-by-increasing-frequency/discuss/989745/Java-Min-Heap

public class SortElementsByFrequenct {
    static class Pair {
        int index;
        int freq;

        Pair(int index, int freq) {
            this.index = index;
            this.freq = freq;
        }
    }
    static void frequencySort(int[] arr) {
        HashMap<Integer, Pair> map = new HashMap<>();
        // Keep track of frequencies and indexes of the elements.
        for (int i =0; i< arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]).freq;
                map.put(arr[i], new Pair(i, count +1));
            } else {
                map.put(arr[i], new Pair(i, 1));
            }
        }

        // Create a Max priority queue with Map that contains element, its frequency and indexes.
        PriorityQueue<Map.Entry<Integer, Pair>> pq = new PriorityQueue<>(Collections.reverseOrder(new Comparator<Map.Entry<Integer, Pair>>() {
            @Override
            public int compare(Map.Entry<Integer, Pair> o1, Map.Entry<Integer, Pair> o2) {
                return (o1.getValue().freq == o2.getValue().freq) ? (o2.getValue().index - o1.getValue().index) : o1.getValue().freq - o2.getValue().freq;
            }
        }));

        //Add all the element from map to the priority queue.
        for (Map.Entry<Integer, Pair> entry: map.entrySet()) {
            pq.add(entry);
        }

        // now we have the map entries in the decreasing order in the max heap.
        // put the number in the returned array based on the number of times it occurs
        int j =0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Pair> entry = pq.poll();
            for (int i =0; i< entry.getValue().freq; i++) {
                arr[j++] = entry.getKey();
            }
        }
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        frequencySort(a);

        for (int i = 0; i< a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
