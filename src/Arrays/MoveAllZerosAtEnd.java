package Arrays;

import Utils.Utils;
//Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example,
// if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
// The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).

public class MoveAllZerosAtEnd {
    static void pushZerosToEnd(int[] arr, int n) {
        int count = 0;
        // Move all the non-zero element at the begining of the array.

        for (int i =0; i< n; i++) {
            if (arr[i] > 0) {
                Utils.swap(arr, i, count);
                count++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        pushZerosToEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");

        Utils.printArray(arr, n);
    }
}
