package Arrays;

// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
// Given an array of n distinct elements, find the minimum number of swaps required to sort the array.
//
//Examples:
//
//Input: {4, 3, 2, 1}
//Output: 2
//Explanation: Swap index 0 with 3 and 1 with 2 to
//              form the sorted array {1, 2, 3, 4}.
//
//Input: {1, 5, 4, 3, 2}
//Output: 2

// Time Complexity: O(n Log n)
//Auxiliary Space: O(n)

import Utils.Utils;

import java.util.Arrays;
import java.util.HashMap;

public class minimumSwapsToSortArray {

    static int minSwaps(int[] a, int len) {
        int[] temp = Arrays.copyOfRange(a, 0, len);
        Arrays.sort(temp);
        int swaps = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< len; i++) {
            map.put(a[i], i);
        }

        for (int i = 0; i< len; i++) {
            if (a[i] != temp[i]) {
                swaps++;
                int tempNum = a[i];

                Utils.swap(a, i, map.get(temp[i]));
                map.put(tempNum, map.get(temp[i]));
                map.put(temp[i], i);

            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        int[] a = { 101, 758, 315, 730, 472,
                619, 460, 479 };
        int n = a.length;
        // Output will be 5
        System.out.println(minSwaps(a, n));
    }

}
