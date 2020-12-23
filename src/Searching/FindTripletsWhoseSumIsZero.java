package Searching;

import java.util.HashSet;

//Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
// Complexity is O(n2)
public class FindTripletsWhoseSumIsZero {
    private static void findTriplets(int[] arr, int len) {
        for (int i =0; i< len; i++) {
            HashSet set = new HashSet();
            for (int j = i+1; j < len+1 ; j++  ) {
                int x = -(arr[i] + arr[j]);

                if (set.contains(x)) {
                    System.out.println("Triplets are : " + x + " " + arr[i] + " " + arr[j]);
                } else {
                    set.add(arr[j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        findTriplets(arr, n-1);
    }
}
