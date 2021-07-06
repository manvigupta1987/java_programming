package Arrays;

import Utils.Utils;
// Given an array of positive and negative numbers, arrange them such that all negative integers
// appear before all the positive integers in the array without using any additional data structure
// like a hash table, arrays, etc.The order of appearance should be maintained.

//Since we need to keep the order, we can use insertion sort to order the negative and positive numbers.

// Time complexity of above solution is O(n2) and auxiliary space is O(1)
public class RearrangePosNNegNums {
    static void rearrange(int[] arr, int len ) {
        int key;
        for(int i =1; i<len; i++) {
            key = arr[i];
            // Try to keep all the positive number at the end and negative numbers at the beginning.
            if (key > 0) {
                continue;
            }

            int j = i-1;
            while (j >= 0 && arr[j] > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            // Put negative element at its right position
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        int length = array.length;

        rearrange(array, length);
        Utils.printArray(array, length);
    }
}
