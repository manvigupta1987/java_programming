package Arrays;

// Given an array of n distinct elements, the task is to find all elements in array which have at-least two greater elements than themselves.
//
//Examples :
//
//Input : arr[] = {2, 8, 7, 1, 5};
//Output : 2  1  5
//The output three elements have two or
//more greater elements

import java.util.Collections;
import java.util.PriorityQueue;

// This can be solved using Max Heap and Min Heap.
// The following solution provides the complexity of O(n)
public class FindAllElementsSmallerThan2ndLargest {
    static void findElements(int[] arr, int len) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] < second) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void findElementsWithMaxHeap(int[] arr, int len) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i =0; i< len; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = 0; i< len; i++) {
            if (i < 2) {
                maxHeap.poll();
            } else {
                System.out.println(maxHeap.poll());
            }
        }


    }
    public static void main(String[] args) {
        int arr[] = { 2, -6, 3, 5, 1};
        int n = arr.length;
        findElements(arr, n);

        findElementsWithMaxHeap(arr, n);
    }
}
