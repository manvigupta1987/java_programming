package Hashing;
import java.util.HashSet;

// Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
//
//Examples:
//
//Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
//Output: 4
//Explanation:
//The subsequence 1, 3, 4, 2 is the longest
//subsequence of consecutive elements

// Solution:
// Create an empty hash.
// Insert all array elements to hash.
// Do following for every element arr[i]
// Check if this element is the starting point of a subsequence. To check this, simply look for arr[i] – 1 in the hash, if not found, then this is the first element a subsequence.
// If this element is the first element, then count the number of elements in the consecutive starting with this element. Iterate from arr[i] + 1 till the last element that can be found.
// If the count is more than the previous longest subsequence found, then update this.

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int[] arr, int len) {
        int max_count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int item : arr) {
            set.add(item);
        }

        for (int i =0; i< len; i++) {
            // arr[i] can be start of the sequence.
            if (!set.contains(arr[i] -1)) {
                int num = arr[i];
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num = num +1;
                }
                if (count > max_count) {
                    max_count = count;
                }
            }
        }
        return max_count;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println( "Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
    }
}
