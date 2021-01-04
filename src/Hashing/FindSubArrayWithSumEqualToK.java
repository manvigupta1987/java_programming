package Hashing;

import java.util.HashMap;

//Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

// https://leetcode.com/problems/subarray-sum-equals-k/solution/
// Time Complexity : O(n)
public class FindSubArrayWithSumEqualToK {
    static int findSubArrays(int[] arr, int sumNeeded) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count =0;
        for (int i =0; i < arr.length; i++) {
            sum += arr[i];
            map.put(0, 1);
            if (map.containsKey(sum-sumNeeded)) {
                count += map.get(sum-sumNeeded);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println("Number of subarrays = " + findSubArrays(arr, k));
    }
}
