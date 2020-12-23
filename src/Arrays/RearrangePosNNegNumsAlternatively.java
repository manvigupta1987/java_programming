package Arrays;

// An array contains both positive and negative numbers in random order. Rearrange the array elements so that positive and negative
// numbers are placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they
// appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
//
//For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

// This needs to be done in O(n) and O(1) extra space

import Utils.Utils;

public class RearrangePosNNegNumsAlternatively {
    static void rearrange(int[] arr, int len) {
        // The following few lines are similar to partition process of QuickSort.  The idea is to consider 0 as pivot and divide the array around it.
        int pivot = 0, j = -1;
        for (int i=0; i<len; i++) {
            if (arr[i] < pivot) {
                j++;
                Utils.swap(arr, i, j);
            }
        }

        //Now all positive numbers are at end and negative numbers at the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = j+1, neg = 0;
        while (pos < len && neg < pos && arr[neg] < 0) {
            Utils.swap(arr, pos, neg);
            neg +=2;
            pos++;
        }
    }
    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr,n);
        System.out.println("Array after rearranging: ");
        Utils.printArray(arr,n);
    }
}
