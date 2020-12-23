package Searching;

import java.util.*;

// Method 1: Sort the array and find the k elements. Complexity depends on the sorting algorithm.
// Method 2: Sort the element in descending order in O(nLogn). Print the first k numbers of the sorted array O(k).
// Method 3: Use Max Heap in O(n) and then run extractMax k times to get the K maximum elements. Time Complexity is O(klogn)
// Method 4: Build MinHeap with first k elements (arr[0] to arr[k-1]) of the given array. O(k).
        // For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
            //……a) If the element is greater than the root then make it root and call heapify for MH
            //……b) Else ignore it.
            //// The step 2 is O((n-k)*logk)
        // MH has k largest elements and root of the MH is the kth largest element.
        //Time Complexity: O(k + (n-k)Logk) without sorted output
public class KLargestOrSmallestElements {

    // Method:2
    public static void FirstKelementsWithMaxHeap(int[] arr, int size, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i =0; i<arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        System.out.println("K largest elements are :" );
        for (int i = 0; i<k; i++ ) {
            System.out.println(priorityQueue.poll());
        }
    }

    //Method :3 : Min Heap with K elements.
    public static void FirstKelementsWithMinHeap(int[] arr, int size, int k) {
        if (k > size) {
            throw  new IllegalArgumentException();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        // Creating Min Heap for given array with only k elements Create min heap with priority queue
        for (int i =0; i<k; i++) {
            priorityQueue.add(arr[i]);
        }

        // Loop For each element in array after the kth element
        for (int i = k; i<size; i++) {
            // Change minimum element (top element of the minHeap) to current element by polling out the top element of the minHeap
            if (arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        // Now queue contains K largest elements.
        System.out.println("K largest elements are :" );
        for (int i = 0; i<k; i++ ) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };

        int size = arr.length;

        // Size of Min Heap
        int k = 3;

        FirstKelementsWithMaxHeap(arr, size, k);
        int arr1[] = { 11, 3, 2, 1, 15, 5, 4};
        int len = arr1.length;
        FirstKelementsWithMinHeap(arr1, len, k);

    }

}
