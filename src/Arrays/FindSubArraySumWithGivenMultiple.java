package Arrays;


// Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two
// whose elements sum up to a multiple of k, or false otherwise.
//
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
//
//
//
//Example 1:
//
//Input: nums = [23,2,4,6,7], k = 6
//Output: true
//Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

import java.util.HashMap;

public class FindSubArraySumWithGivenMultiple {
    public static void main(String[] args) {
        int [] arr = {23, 2, 4, 6, 7};
        int k = 6;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i< arr.length; i++) {
            sum += arr[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                int prev = map.get(sum);
                if (i - prev > 1) {
                    System.out.println("True");
                    return;
                }
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("False");
    }
}
