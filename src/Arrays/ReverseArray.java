package Arrays;

import Utils.Utils;
//Given an array (or string), the task is to reverse the array/string.

//Time Complexity : O(n)

public class ReverseArray {

    static void reverseArray(int[] arr, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int len = arr.length;
        while (start < len/2) {
            Utils.swap(arr, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int len = arr.length;
        Utils.printArray(arr, len);
        reverseArray(arr, 0, len-1);
        System.out.println("Reversed array is ");
        Utils.printArray(arr, len);
    }
}
