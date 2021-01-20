package Arrays;

import java.util.*;
import java.util.stream.Collectors;

// Method 1: Using sorting --> Sort the array and find the kth element. Time is O(nlog(n)).
// The problem of this solution is that sorting all
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

        int arr2[] = { 11, 3, 2, 1, 15, 5, 4};
        // boxed is used to convert the intStream to Integer Stream.
        Optional<Integer> optional = Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst();
//        List<Integer> list = Arrays.stream(arr2).boxed().collect(Collectors.toList());
//        Optional<Integer> optional = list.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst();
        System.out.println(optional.get());
    }
}
