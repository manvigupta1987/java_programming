package Arrays;

import Utils.Utils;

public class DoubleTheElementsAndMoveAllZerosAtEnd {
    static void modifyAndRearrangeArr(int[] arr, int n) {
        int count =0;
        for (int i = 0; i< n; i++) {
            if (arr[i] > 0) {
                Utils.swap(arr, i, count);
                arr[i] = arr[i] *2;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 };
        int n = arr.length;

        System.out.print("Original array: ");
        Utils.printArray(arr, n);

        modifyAndRearrangeArr(arr, n);

        System.out.print("Modified array: ");
        Utils.printArray(arr, n);
    }
}
