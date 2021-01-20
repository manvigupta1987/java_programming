package Sorting;

import Utils.Utils;

// QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
// There are many different versions of quickSort that pick pivot in different ways.
//
// 1. Always pick first element as pivot.
// 2. Always pick last element as pivot (implemented below)
// 3. Pick a random element as pivot.
// 4. Pick median as pivot.

// The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot,
// put x at its correct position in sorted array and put all smaller elements (smaller than x) before x,
// and put all greater elements (greater than x) after x. All this should be done in linear time.

// https://www.geeksforgeeks.org/quick-sort/

// best case complexity is O(nlogn), worst case is O(n2);
public class QuickSort {

    /** returns the location of pivot after the adjustment
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        // taking last element as pivot
        int pivot = arr[high];

        int i = low - 1;
        for (int j =low; j< high; j++) {
            if (arr[j] < pivot) {
                i++;
                Utils.swap(arr, i, j);
            }
        }
        Utils.swap(arr, i+1, high);
        return i+1;
    }

    private static void sort(int[] arr, int low, int high) {
        int len = arr.length;
        if (len < 1) {
            throw new IllegalArgumentException();
        }

        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("pi =" + pi);
            Utils.printArray(arr, arr.length);
            sort(arr, low, pi-1);
            sort(arr, pi+1 , high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        sort(arr, 0, arr.length-1);
        System.out.println("Sorted array");
        Utils.printArray(arr, arr.length);
    }
}
