package Hashing;

import java.util.HashMap;

// Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
// Input: arr[] = {9, 7, 5, 3},
//k = 6
//Output: True
//We can divide array into (9, 3) and
//(7, 5). Sum of both of these pairs
//is a multiple of 6.

// Solution:
// 1. Create a map with reminder and its frequency
// 2. Traverse the array, n check if reminder is equal to 0, there should be two elements with 0 rem in the array.
// 3. if twice of reminder is equal to sum, there should be two such elements in the array.
// 4. Else frequency of reminder and sum-reminder in the map should be same.

public class PairDivisibleByK {
    static boolean findIfPairsDivisibleByK(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int item : arr) {
            int rem = item % sum;
            if (rem < 0) {
                rem += sum;
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int item : arr) {
            int rem = item % sum;
            if (rem < 0) {
                rem += sum;
            }
            // If remainder is 0 or twice of reminder is equal to sum, then there must be two elements with 0 remainder
            if (rem == 0 || rem * 2 == sum) {
                if (map.get(rem) % 2 != 0) {
                    return false;
                }
            } else if (map.get(rem) != map.get(sum - rem)) { // number of occurrences of remainder must be equal to number of occurrences of sum - remainder
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int sum = 10;
        if(findIfPairsDivisibleByK(arr, sum)) {
            System.out.println("True");
        } else {
            System.out.println("No");
        }
    }
}
