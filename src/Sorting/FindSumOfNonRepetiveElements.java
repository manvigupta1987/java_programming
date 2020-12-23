package Sorting;

import java.util.HashSet;

//Given an integer array with repeated elements, the task is to find sum of all distinct elements in
// array.

//Time Complexity : O(n)

public class FindSumOfNonRepetiveElements {
    private static int findSum(int[] arr, int n) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<n; i++) {
            if (!set.contains(arr[i])) {
                sum += arr[i];
                set.add(arr[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {12, 10, 9, 45, 2, 10, 10, 45,10};
        int n = arr.length;
        System.out.println(findSum(arr, n));
    }
}
