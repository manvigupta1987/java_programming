package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

// Method 1: Using sorting --> Sort the array and find the kth element. Time is O(nlog(n)). The problem of this solution is that sorting all
// elements is not necessary and is a overkill for getting just one element.

public class KthLargestElementInArray {

    //Time complexity is O(nlog(k))
    public static int kthLargestElementsWithMinHeap(int[] arr, int size, int k) {
        if (k > size) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i<k ; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < size ; i++) {
            if (arr[i] > queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.peek();
    }
    //Time Complexity is O(klogn)
    public static int kthLargestElementsWithMaxHeap(int[] arr, int size, int k) {
        if (k > size) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i<size ; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < k-1 ; i++) {
            queue.poll();
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int arr1[] = { 11, 3, 2, 1, 15, 5, 4};
        int len = arr1.length;
        int k = 3;
        System.out.println("Kth Largest Element is "+ kthLargestElementsWithMinHeap(arr1, len, k));
        System.out.println("Kth Largest Element is "+ kthLargestElementsWithMaxHeap(arr1, len, k));
    }
}
