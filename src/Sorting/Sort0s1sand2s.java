package Sorting;

import java.util.HashMap;
// Simple approach is take three counter variables and traverse the array and count the number of 0s , 1s and 2s.
// Efficient approach is the full array is unknown.
    // There are three indices – low, mid and high. Initially, the value of low = mid = 1 and high = N.
    //If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
    //Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
    //If the element is 2 then swap it with an element in high range.

public class Sort0s1sand2s {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortArr(int[] arr, int len) {
        int low = 0, mid = 0, high = len;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, mid, low);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    static void printArray(int arr[], int arr_size)
    {
        for (int item: arr)
            System.out.print(item+ " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int n = arr.length-1;
        sortArr(arr, n);
        System.out.println("Array after seggregation ");
        printArray(arr, n);
    }
}
