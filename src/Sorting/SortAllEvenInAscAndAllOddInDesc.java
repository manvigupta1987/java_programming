package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

//Given an array of integers (both odd and even), sort them in such a way that the first part of the
// array contains odd numbers sorted in descending order, rest portion contains even numbers sorted
// in ascending order.

//Time complexity: O(n log n)
public class SortAllEvenInAscAndAllOddInDesc {

    private static void twoWaySort(int[] arr, int n) {
        //Make all odd numbers negative.
        for (int i=0; i< n; i++) {
          if (arr[i] % 2 != 0 ) {
              arr[i] *= -1;
          }
        }
        //Sort the array
        Arrays.sort(arr);

        //// Retaining original array
        for (int i=0; i< n; i++) {
            if (arr[i] % 2 != 0 ) {
                arr[i] *= -1;
            }
        }
     }
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 7, 5, 4 };

        twoWaySort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
