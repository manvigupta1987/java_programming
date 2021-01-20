package Arrays;

import Utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromUnsortedArrat {
    static void removeDupsUsingSet(int[] arr, int len) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i< len; i++) {
            set.add(arr[i]);
        }
        System.out.print("after using set =" + set);
    }

    static void removeDupsUsingOtherMethod(int[] arr, int len) {

        sortArray(arr, len);
    }

    static int partition(int low, int high, int[] arr) {
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

    static void sort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(low, high, arr);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    private static void sortArray(int[] arr, int len) {
        sort(arr, 0, len-1 );
        int j =0;
        for (int i =0; i< len-1; i++) {
            if (arr[i] != arr[i+1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[len-1];

        Utils.printArray(arr, j);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 1, 7, 2, 4, 2 };
        int n = arr.length;
        // O(n)
        removeDupsUsingSet(arr, n);
        int[] arr1 = { 1, 2, 5, 1, 7, 2, 4, 2 };
        // O(2nlogn)
        removeDupsUsingOtherMethod(arr1, n);
    }
}
