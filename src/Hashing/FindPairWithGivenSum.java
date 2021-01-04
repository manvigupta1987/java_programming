package Hashing;

import java.util.HashMap;

// Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.

// Create a map to store frequency of each number in the array. (Single traversal is required)
//In the next traversal, for every element check if it can be combined with any other element (other than itself!) to give the desired sum.Increment the counter accordingly.
//After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two times.
// Hence divide count by 2 and return.

public class FindPairWithGivenSum {
    static int findPairs(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< arr.length; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count +1);
        }
        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        int twice_count = 0;
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (map.get(diff) != null) {
                twice_count += map.get(diff);

                // if diff is equal to the arr[i] itself, reduce the twice_count by 1;
                if (diff == arr[i]) {
                    twice_count--;
                }
            }
        }
        // divide the count by 2.
        return twice_count / 2;
    }

    public static void main(String[] args) {
        int [] arr = {1, 1, 1, 1};
        int sum = 2;
        System.out.println(findPairs(arr, sum));

        int arr1[] = {1, 5, 7, -1, 5};
        System.out.println(findPairs(arr1, 6));
    }
}
