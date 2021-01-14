package Hashing;

// Given a set S (all distinct elements) of integers, find the largest d such that a + b + c = d
//where a, b, c, and d are distinct elements of S.
//
//Constraints:
//1 ≤ number of elements in the set ≤ 1000
//INT_MIN ≤ each element in the set ≤ INT_MAX
//Examples :
//
//Input : S[] = {2, 3, 5, 7, 12}
//Output : 12
//Explanation: 12 is the largest d which can be represented as 12 = 2 + 3 + 7


// Solution:
//The above problem statement (a + b + c = d) can be restated as finding a, b, c, d such that a + b = d – c. So this problem can be efficiently solved using hashing.
//
//Store sums of all pairs (a + b) in a hash table
//Traverse through all pairs (c, d) again and search for (d – c) in the hash table.
//If a pair is found with the required sum, then make sure that all elements are distinct array elements and an element is not considered more than once.

import java.util.HashMap;

public class FindLargestDInArray {
    static class Indexes {
        int i;
        int j;

        Indexes(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int findLargestD(int[] arr, int len) {
        HashMap<Integer, Indexes> map = new HashMap<>();
        for (int i = 0; i< len-1; i++) {
            for (int j = i+1; j< len; j++) {
                map.put((arr[i] + arr[j]), new Indexes(i, j));
            }
        }
        int d = Integer.MIN_VALUE;

        for (int i = 0; i< len-1; i++) {
            for (int j = i + 1; j < len; j++) {
                int abs_diff = Math.abs(arr[i] - arr[j]);
                if (map.containsKey(abs_diff)) {
                    Indexes indexes = map.get(abs_diff);

                    // Making sure that all elements are distinct array elements and an element is not considered more than once.
                    if (indexes.i != i && indexes.j != j && indexes.i != j && indexes.j != i ) {
                        d = Math.max(d, Math.max(arr[i], arr[j]));
                    }
                }
            }
        }
        return d;
    }
    public static void main(String[] args) {
        int []S = new int[]{ 2, 3, 5, 7, 12 };
        int n = S.length;

        int ans = findLargestD(S, n);
        if (ans == Integer.MAX_VALUE)
            System.out.println("No Solution");
        else
            System.out.println("Largest d such that " +
                    "a + " + "b + c = d is " +
                    ans );
    }
}
