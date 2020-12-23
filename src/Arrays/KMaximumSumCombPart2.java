package Arrays;

// Method 2:
// Instead of brute-forcing through all the possible sum combinations, we should find a way to
// limit our search space to possible candidate sum combinations.

//1. Sort both arrays array A and array B.
//2. Create a max heap i.e priority_queue to store the sum combinations along with the indices of elements.
//3. Initialize the heap with the maximum possible sum combination i.e (A[N – 1] + B[N – 1] where N is the size of array) and with the indices of elements from both arrays (N – 1, N – 1).
//4. Pop the heap to get the current largest sum and along with the indices of the element that make up
// the sum. Let the tuple be (sum, i, j).
//Next insert (A[i – 1] + B[j], i – 1, j) and (A[i] + B[j – 1], i, j – 1) into the max heap but make sure that the pair of indices i.e (i – 1, j) and (i, j – 1) are not
//already present in the max heap. To check this we can use set in C++.

//Time Complexity is O(N log N) assuming K <= N

import java.util.*;

public class KMaximumSumCombPart2 {
    static void enterSum(PriorityQueue<PairSum> priorityQueue, HashSet<Pair> pairs, int l, int m, int sum) {
        priorityQueue.add(new PairSum(l, m, sum));
        pairs.add(new Pair(l, m));
    }
    public static void NMaxCombinations_method2(int[] arr1, int[] arr2, int len1, int k) {
        // Step 1: Sort the arrays.
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //Step 2: Create a max heap
        PriorityQueue<PairSum> priorityQueue = new PriorityQueue<PairSum>();
        //// pairs is used to store the indices of the  Pair(i, j) we use pairs to make sure the indices doe not repeat inside max heap.
        HashSet<Pair> pairs = new HashSet<Pair>();

        // Add the N-1 index from arr1 and arr2 in the queue.
        int l = len1 -1;
        int m = len1 -1;

        pairs.add(new Pair(l, m));
        priorityQueue.add(new PairSum(l, m, (arr1[l] + arr2[m])));

        for (int i =0; i<k; i++) {
            PairSum pairSum = priorityQueue.poll();
            System.out.println(pairSum.sum);

            l = pairSum.l -1;
            m = pairSum.m;
            // insert only if l and m are greater than 0 and the pair (l, m) is not already present inside set
            if (l>=0 && m >=0 && !pairs.contains(new Pair(l,m))) {
                enterSum(priorityQueue, pairs, l, m, arr1[l] + arr2[m]);
            }
            l = pairSum.l;
            m = pairSum.m -1;
            if (l>=0 && m >=0 && !pairs.contains(new Pair(l,m))) {
                enterSum(priorityQueue, pairs, l, m, arr1[l] + arr2[m]);
            }
        }
    }
}

class Pair {
    int l, m;
    Pair(int l, int m) {
        this.l = l;
        this.m = m;
    }
}

class PairSum implements Comparable<PairSum> {
    int l,m , sum;
    PairSum(int l, int m, int sum) {
        this.l = l;
        this.m = m;
        this.sum = sum;
    }

    @Override
    public int compareTo(PairSum o) {
        return Integer.compare(o.sum, sum);
    }
}
