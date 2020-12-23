package Sorting;

import java.util.Arrays;

public class MinimumSumOfTwoNumsFromArray {
    static int solve(int[] arr, int n) {
        Arrays.sort(arr);
        int a =0, b =0;
        for (int i=0; i< arr.length; i++) {
            if (i%2 != 0) {
                a = a*10 + arr[i];
            } else {
                b = b*10 + arr[i];
            }
        }
        return a + b;
    }
    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 5, 2, 3};
        int n = arr.length;

        System.out.print("Sum is " + solve(arr, n));
    }
}
