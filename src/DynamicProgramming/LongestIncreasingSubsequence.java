package DynamicProgramming;

// A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.


// https://www.youtube.com/watch?v=CE2b_-XfVDk


import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int LongIncrConseqSubseq(int[] arr, int len) {
        int[] T = new int[len];
        Arrays.fill(T, 1);
        int i =1;
        for (int j = 0; j < len && i<len ; j++) {
            if (arr[j] < arr[i]) {
                T[i] = Math.max(T[i], T[j] + 1);
            } else if (i == j){
                j = -1;
                i = i+1;
            }
        }

        int max = 0;
        for (int j =0; j<len; j++) {
            if (T[j] > max) {
                max = T[j];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = { 5, 7, 6, 7, 8};
        System.out.println(LongIncrConseqSubseq(arr, arr.length));
    }
}
