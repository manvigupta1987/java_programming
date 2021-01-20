package Hashing;

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]

// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentNumbers {
    static int[] topKFrequentNumbers(int[] arr, int k) {
        if(k == arr.length) {
            return arr;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        // first create the frequency map
        for(int i = 0; i< arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        // Create a Max heap;
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            return map.get(n2) - map.get(n1);
        });

        // Add the K top elements in the min heap
        for (int n: map.keySet()) {
            heap.add(n);
        }

        for(int i = 0; i<k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 4, 4, 5, 5, 5, 2, 2};
        int k = 2;
        int num[] = topKFrequentNumbers(arr, k);
        for(int i = 0; i<num.length; i++ ) {
            System.out.println(num[i] + " ");
        }
    }
}
