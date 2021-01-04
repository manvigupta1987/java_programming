package Hashing;

import java.util.HashMap;

public class SmallestsubArrayWithMostFrequentElem {
    static void smallestSubsegment(int[] arr, int len) {

        HashMap<Integer, Integer> left = new HashMap<>(); // this array will hold the element and first occurence index,
        HashMap<Integer, Integer> count = new HashMap<>(); // This array holds the element and its frequency.

        int mx = 0; // captures the maximum frequency.
        int mn = -1; // captures the smallest subsequence length.
        int strindex = -1; // captures the starting index of smallest subsequence window.
        for (int i =0; i< len; i++) {
            int num = arr[i];
            if (count.get(num) == null) {
                count.put(num, 1);
                left.put(num, i);
            } else {
                count.put(num, count.get(num) + 1);
            }

            // if the frequency of the item is greater, update max count, min length of the subsequence and starting index.
            if (count.get(num) > mx) {
                mx = count.get(num);
                mn = i - left.get(num) + 1;
                strindex = left.get(num);
                // if frequency is same as the other item, update the min length and starting index with minimum subsequence length.
            } else if ((count.get(num) == mx) &&
                    ((i - left.get(num) + 1) < mn)) {
                mn = i - left.get(num) + 1;
                strindex = left.get(num);
            }
        }
        for (int i = strindex; i< strindex+ mn; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 2, 2, 1 };
        int n = A.length;
        smallestSubsegment(A, n);
    }
}
