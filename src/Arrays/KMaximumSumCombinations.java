package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

// Method 1: We can use Brute force through all the possible combinations that can be made by
// taking one element from array A and another from array B and inserting them to a max heap.
// After inserting all the sum combinations we take out K elements from max heap and display it.
// Time Complexity : O(n2)

// https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/

public class KMaximumSumCombinations {
    static void NMaxCombinations_method1(int[] arr1, int[] arr2, int len1, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i =0; i< len1; i++) {
            for (int j=0; j< len1; j++) {
                priorityQueue.add(arr1[i] + arr2[j]);
            }
        }

        int count = 0;
        while(count < k && priorityQueue.size() != 0) {


            System.out.println(priorityQueue.peek());
            priorityQueue.remove();
            count++;
        }
    }
    public static void main(String[] args) {
        int A[] = {1, 2};
        int B[] = { 3 };
        int N = A.length;
        int K = 3;

        // Function Call
        //Time Complexity is O(N2)
        NMaxCombinations_method1(A, B, N, K);
        // Time Complexity is O(N log N) assuming K <= N
        KMaximumSumCombPart2.NMaxCombinations_method2(A, B, N, K);
    }
}
