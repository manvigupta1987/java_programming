package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    static void printSubArrays(int[] arr, int sumNeeded) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(0, list);
        for (int i =0; i < arr.length; i++) {
            sum += arr[i];
            List<Integer> list1 = new ArrayList<>();
            int diff = sum-sumNeeded;
            if (map.containsKey(diff)) {
                list1 = map.get(diff);
                for (Integer item: list1) {
                    System.out.println("Subarray found from Index " + item + " to " + i);
                }
                list1.add(i+1);
                map.put(sum, list1);
            } else {
                list1.add(i+1);
                map.put(sum, list1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println("Number of subarrays = " + findSubArrays(arr, k));
        int[] arr1 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        printSubArrays(arr1, 0);
    }
}
