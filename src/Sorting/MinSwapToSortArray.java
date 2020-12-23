package Sorting;

import java.util.Arrays;
import java.util.HashMap;

//Given an array of n distinct elements, find the minimum number of swaps required to sort the array.

public class MinSwapToSortArray {
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int minSwaps(int[] arr, int len) {
        int[] temp = Arrays.copyOfRange(arr, 0, len);
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< len; i++) {
            map.put(arr[i], i);
        }
        int swap =0;
        for (int i=0; i< len-1; i++) {
            if (arr[i] != temp[i]) {
                swap++;

                int val = arr[i];
                swap(arr, i, map.get(temp[i]));
                map.put(temp[i],i );
                map.put(val, map.get(temp[i]));
            }
        }
        return swap;
    }

    // Driver program to test the above function
    public static void main(String[] args)
            throws Exception
    {
        int[] a = { 1, 5, 4, 3, 2 };
        int n = a.length;
        // Output will be 5
        System.out.println(minSwaps(a, n));
    }
}
