package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
// Given N elements, write a program that prints the length of the longest increasing subsequence whose adjacent element difference is one.
//Examples:
//
//Input : a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12}
//Output : 6
//Explanation: 3, 4, 5, 6, 7, 8 is the longest increasing subsequence whose adjacent element differs by one.


public class LongestIncreasingSubsequenceWithDiffAsOne {
    static int LongIncrConseqSubseq(int[] arr, int len) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        for (int i = 1; i< len; i++) {
            if (map.containsKey(arr[i] -1 )) {
                map.put(arr[i], map.get(arr[i]-1) + 1);
                map.remove(arr[i] - 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return Collections.max(map.values());
    }
    public static void main(String[] args) {
        int arr[] = { 3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
        System.out.println(LongIncrConseqSubseq(arr, arr.length));
    }
}
