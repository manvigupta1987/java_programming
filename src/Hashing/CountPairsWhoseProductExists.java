package Hashing;

import java.util.HashSet;

// Given an array, count those pair whose product value is present in array.
//
//Examples:
//
//Input : arr[] = {6, 2, 4, 12, 5, 3}
//Output : 3
//       All pairs whose product exist in array
//       (6 , 2) (2, 3) (4, 3)

public class CountPairsWhoseProductExists {
    static int countPairs(int[] arr, int len) {
        HashSet<Integer> set = new HashSet<>();
        for (int i =0; i<len; i++) {
            set.add(arr[i]);
        }
        int count = 0;
        for (int i = 0; i< len; i++) {
            for (int j = i+1; j<len ; j++) {
                int product = arr[i] * arr[j];

                if (set.contains(product)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {6, 2, 4, 12, 5, 3} ;
        int n = arr.length;
        System.out.println(countPairs(arr, n));
    }
}
