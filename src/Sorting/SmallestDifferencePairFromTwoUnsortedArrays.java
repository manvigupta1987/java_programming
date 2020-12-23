package Sorting;

import java.util.Arrays;

//Problem: Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.

//This algorithm takes O(m log m + n log n) time to sort and O(m + n) time to find the minimum difference. Therefore, the overall runtime is O(m log m + n log n).
public class SmallestDifferencePairFromTwoUnsortedArrays {
    static int findSmallestDifference(int[] arr1, int[] arr2, int len1, int len2) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i =0, j=0;
        while (i<len1 && j< len2) {
            if (Math.abs(arr1[i] - arr2[j]) < result) {
                result = Math.abs(arr1[i] - arr2[j]);
            }

            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Input given array A
        int A[] = {1, 2, 11, 5};

        // Input given array B
        int B[] = {4, 12, 19, 23, 127, 235};

        // Call function to print smallest result
        System.out.println(findSmallestDifference(A, B, A.length, B.length));

    }
}
