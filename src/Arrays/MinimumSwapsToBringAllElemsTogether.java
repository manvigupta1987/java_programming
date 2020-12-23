package Arrays;

//Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
//
//Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
//Output: 1

//TimeComplexity : O(n)

import Utils.Utils;

public class MinimumSwapsToBringAllElemsTogether {
    static int minSwap(int[] arr, int len, int range) {
        int start = 0;
        int end = len-1;
        int swapReq = 0;

        while (start < end) {
            if (arr[start] > range && arr[end] <= range) {
                Utils.swap(arr, start, end);
                swapReq++;
            }
            if (arr[start] <= range) {
                start++;
            }
            if (arr[end] > range) {
                end--;
            }
        }
        return swapReq;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.print(minSwap(arr, n, k) + "\n");

        int arr1[] = {2, 7, 9, 5, 8, 7, 4};
        n = arr1.length;
        k = 5;
        System.out.print(minSwap(arr1, n, k));
    }
}
