package DynamicProgramming;

// A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order
// of the remaining elements.


//https://www.youtube.com/watch?v=odrfUCS9sQk

public class LongestIncreasingSubsequence {
    static int LongIncrConseqSubseq(int[] arr, int len) {
        int[] T = new int[len];
        T[0] = 1;
        int num = 0;
        for (int j = 0; j < len; j++) {
            int max = 0;
            for(int i = 0; i< j; i++) {
                if(arr[i] < arr[j]) {
                    if(T[i] > max) {
                        max = T[i];
                    }
                }
            }
            T[j] = max + 1;
            if(T[j] > num) {
                num = T[j];
            }
        }

        return num;
    }
    public static void main(String[] args) {
        int arr[] = { 5, 7, 6, 7, 8};
        System.out.println(LongIncrConseqSubseq(arr, arr.length));
    }
}
