package Arrays;

import Utils.Utils;

import java.util.Arrays;

//Given an array of integers, task is to print the array in the order – smallest number, Largest number,
// 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on…..

//Input : arr[] = [5, 8, 1, 4, 2, 9, 3, 7, 6]
//Output :arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5}

//Time Complexity : O(n Log n)
//Auxiliary Space : O(n)

public class ArrayWithSmallestLargestSecondSmallestElems {
    static void rearrangeArray(int[] arr, int n) {
        Arrays.sort(arr);
        int[] temp = new int[n];
        int i =0, j = n-1, k =0;
        while (i <= j) {
            if (k < n) {
                temp[k++] = arr[i];
            }
            if (k < n) {
                temp[k++] = arr[j];
            }
            i++;
            j--;
        }

        for (int l = 0; l< n; l++) {
            arr[l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 1, 4, 2, 9, 3, 7, 6 };
        int n = arr.length;
        rearrangeArray(arr, n);
        Utils.printArray(arr, n);
    }
}
