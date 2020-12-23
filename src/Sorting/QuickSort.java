package Sorting;

import Utils.Utils;

public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
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
