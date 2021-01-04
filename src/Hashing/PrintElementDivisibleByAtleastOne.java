package Hashing;

import java.util.HashSet;

// Given an array of length N that contains only integers, the task is to print the special numbers of array. A number in this array is called Special number if it is divisible by at least one other number in the array.
//
//Examples :
//
//Input : 1 2 3
//Output : 2 3
//Explanation : both 2 and 3 are divisible by 1.

public class PrintElementDivisibleByAtleastOne {
    static void divisibilityCheck(int[] arr, int len) {
        HashSet<Integer> set = new HashSet<>();
        for (int i =0; i< len; i++) {
            for (int j = 0; j<len;j++) {
                if (i != j) {
                    if (arr[j] % arr[i] == 0) {
                        if (!set.contains(arr[j])) {
                            set.add(arr[j]);
                        }
                    }
                }
            }
        }

        for (Integer item : set) {
            System.out.print( item + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {8, 6, 2, 3, 9, 10};
        int n = arr.length;
        divisibilityCheck(arr, n);
    }
}
