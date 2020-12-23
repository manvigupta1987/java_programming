package Arrays;

// You have given an array which contain 1 to n element, your task is to sort this array in an efficient way and without replace with 1 to n numbers.
//
//Examples :
//
//Input : arr[] = {10, 7, 9, 2, 8,
//                 3, 5, 4, 6, 1};
//Output : 1 2 3 4 5 6 7 8 9 10

// Approaches:
// Method 1: Any sort alogrithm --> O(nLogn)
// Method 2: Replace every element with it’s position. it takes O(n) efficient time

import Utils.Utils;

public class SortArrayContaining1ToN {
    static void sortit(int[] arr, int n) {
        for (int i = 0; i< n; i++) {
            arr[i] = i+1;
        }
    }
    public static void main(String[] args) {
        int []arr = {10, 7, 9, 2, 8, 3, 5, 4, 6, 1};
        int n = arr.length;

        // for sort an array
        sortit(arr, n);

        Utils.printArray(arr, n);
    }

}
