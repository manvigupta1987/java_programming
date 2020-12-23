package Sorting;

//Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.
//Input: arr[] = {1, 5, 3, 4, 2}, k = 3
//Output: 2
//There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2}

import java.util.HashMap;
import java.util.HashSet;

public class CountPairDifferenceEqualK {

    static int countPairsWithDiffK(int[] arr, int n, int k) {
        int count = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int item: arr) {
            set.add(item);
        }
        for (int item: arr) {
            if (set.contains(item+k)) {
                count++;
            } else if (set.contains(item-k)) {
                count++;
            }
            set.remove(item);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 4, 2 };
        int n = arr.length;
        int k = 3;
        System.out.println("Count of pairs with given diff is "
                + countPairsWithDiffK(arr, n, k));
    }
}
