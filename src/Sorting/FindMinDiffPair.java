package Sorting;

import java.util.Arrays;

//Given an unsorted array, find the minimum difference between any pair in given array.

//Solution: Time Complexity : O(n Log n)
// Sort array in ascending order. This step takes O(n Log n) time.
//2) Initialize difference as infinite. This step takes O(1) time.
//3) Compare all adjacent pairs in sorted array and keep track of minimum difference. This step takes O(n) time.

public class FindMinDiffPair {
    static int findMinDiff(int[] arr, int n) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i=0; i<n-1; i++) {
            if (arr[i+1] - arr[i] < diff) {
                diff = arr[i+1] - arr[i];
            }
        }
        return diff;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 3, 19, 18, 25};
        System.out.println("Minimum difference is "+
                findMinDiff(arr, arr.length));

    }
}
