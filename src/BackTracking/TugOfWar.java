package BackTracking;

import java.util.ArrayList;

// Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets
// is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, then size of one subset
// must be (n-1)/2 and size of other subset must be (n+1)/2.

// For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10. Output for this set should be {4, 100, 1, 23, 20}
// and {3, 5, -3, 89, 54}. Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).

// Let us consider another example where n is odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}. The output subsets should be {45, -34, 12, 98, -1}
// and {23, 0, -99, 4, 189, 4}. The sums of elements in two subsets are 120 and 121 respectively.

// The following solution tries every possible subset of half size. If one subset of half size is formed, the remaining elements form the other subset.
// We initialize current set as empty and one by one build it. There are two possibilities for every element, either it is part of
// current set, or it is part of the remaining elements (other subset). We consider both possibilities for every element. When the size
// of current set becomes n/2, we check whether this solutions is better than the best solution available so far. If it is, then we
// update the best solution.

// https://www.geeksforgeeks.org/tug-of-war/
// https://www.youtube.com/watch?v=Q1fLW_zQr3M

public class TugOfWar {
    static int minDiff = Integer.MAX_VALUE;
    static String ans = "";
    static void tugOfWar(int[] arr, int index, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumSet1, int sumSet2) {
        //Base condition
        if (index == arr.length) {
            int delta = Math.abs(sumSet1 - sumSet2);
            if (delta < minDiff) {
                minDiff = delta;
                ans = set1 + " " + set2;
            }
            return;
        }
        // (arr.length + 1) /2) is to take care of odd length arrays.
        if (set1.size() < (arr.length + 1) /2) {
            set1.add(arr[index]);
            tugOfWar(arr, index + 1, set1, set2, (sumSet1 + arr[index]), sumSet2 );
            //backtracking
            set1.remove(set1.size() - 1);
        }

        if (set2.size() < (arr.length + 1) /2) {
            set2.add(arr[index]);
            tugOfWar(arr, index + 1, set1, set2, sumSet1, (sumSet2+ arr[index] ));
            set2.remove(set2.size() - 1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98,  -99, 4, 189, -1, 4};
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();

        int startIndex = 0;
        tugOfWar(arr,startIndex, set1, set2, 0, 0 );
        System.out.println(ans);
    }
}
