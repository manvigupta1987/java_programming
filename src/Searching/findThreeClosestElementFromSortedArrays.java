package Searching;

public class findThreeClosestElementFromSortedArrays {
    private static void findClosest(int[] ar1, int[] ar2, int[] ar3, int len1, int len2, int len3) {
        int i =0, j =0, k=0;
        int diff = Integer.MAX_VALUE;
        int res_i =0, res_j = 0, res_k = 0;
        while (i < len1 && j < len2 && k < len3) {
           int minimum = Math.min(ar1[i], Math.min(ar2[j], ar3[k]));
           int maximum = Math.max(ar1[i], Math.min(ar2[j], ar3[k]));

           if ((maximum - minimum) < diff) {
               diff = maximum - minimum;
               res_i = i;
               res_j = j;
               res_k = k;
           }
           if (diff == 0) break;
           if (ar1[i] == minimum) {
               i++;
           } else if (ar2[j] == minimum) {
               j++;
           } else {
               k++;
           }
        }
        // Print result
        System.out.println(ar1[res_i] + " " + ar2[res_j] + " " + ar3[res_k]);
    }

    public static void main(String[] args) {
        int A[] = {1, 4, 10};
        int B[] = {2, 15, 20};
        int C[] = {10, 12};

        int p = A.length;
        int q = B.length;
        int r = C.length;

        // Function calling
        findClosest(A, B, C, p, q, r);
    }
}
