package Hashing;

import java.util.HashMap;
import java.util.Map;

// Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. The expected time complexity is O(n).
//Examples:
//
//Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
//Output: 1 to 6
//(Starting and Ending indexes of output subarray)

// https://medium.com/@yzhua3/leetcode-contiguous-array-1e5c0076cf4e
//  imagine you have a counter that when iterating over the array nums it increments when hitting 0 and decrements when hitting 1. This implies that after iterating over a subarray with equal numbers of 0s and 1s, the value of the counter stays the same or repeats itself.
//More specifically, suppose we iterate over the array nums. When we reach nums[i], the counter value is v. Suppose from nums[i+1],…,nums[j] there are equal numbers of 0s and 1s. Then when we reach nums[j], the counter value should be the same, as v increments (j-1-i+1+1)/2 times and decrements (j-1-i+1+1)/2 times.
public class LargestSubarrayWithEqual0sAnd1s {
    static void maxLen(int[] arr, int len) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0; int maxlen = 0, endIndex = -1;
        for (int i =0; i<len; i++) {
            count = count + (arr[i] == 1? 1 : -1);
            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                if (maxlen < (i- map.get(count))) {
                    maxlen = (i- map.get(count));
                    endIndex = i;
                }

            }
        }
        System.out.println((endIndex - maxlen + 1) + " to " + endIndex);
    }

    static int countSubarrWithEqualZeroAndOne(int [] arr, int len) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr_sum = 0;

        // Traverse original array and compute cumulative
        // sum and increase count by 1 for this sum
        // in 'um'. Adds '-1' when arr[i] == 0
        for (int i = 0; i < len; i++) {
            curr_sum += (arr[i] == 0) ? -1 : arr[i];
            map.put(curr_sum, map.get(curr_sum)==null?1:map.get(curr_sum)+1);
        }

        int count = 0;

        // traverse the hash table 'um'
        for (Map.Entry<Integer,Integer> itr : map.entrySet())
        {

            // If there are more than one prefix subarrays
            // with a particular sum
            if (itr.getValue() > 1)
                count += ((itr.getValue()* (itr.getValue()- 1)) / 2);
        }

        // add the subarrays starting from 1st element and
        // have equal number of 1's and 0's
        if (map.containsKey(0))
            count += map.get(0);
        return count;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 1, 0, 1, 1};
        int n = arr.length;

        maxLen(arr, n);
        System.out.println("Count = "
                + countSubarrWithEqualZeroAndOne(arr, n));
    }
}
