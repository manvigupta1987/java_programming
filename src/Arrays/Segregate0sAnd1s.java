package Arrays;

import Utils.Utils;
// We are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.

//Time Complexity : O(N)
public class Segregate0sAnd1s {
    static void segregate0and1(int[] arr, int len) {
        int i = 0, j=0;
        while (i < len) {
            if (arr[i] == 0 ) {
                Utils.swap(arr, i, j);
                j++;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 };

        segregate0and1(arr, arr.length);
        Utils.printArray(arr, arr.length);
    }
}
