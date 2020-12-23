package Searching;

//Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an
// element from each array.
//Complexity is O(n)
public class FindClosestPairFromTwoSortedArray {

    private static void findClosest(int[] ar1, int[] ar2, int len1, int len2, int sum) {
        int diff = Integer.MAX_VALUE;
        int ar1Ind = 0, ar2Indx = 0;
        int i =0, j = len2-1;
        while (i < len1 && j >=0) {

            int tempDiff = Math.abs((ar1[i] + ar2[j]) -sum);
            if (tempDiff < diff) {
                diff = tempDiff;
                ar1Ind = i;
                ar2Indx = j;
            }

            if ((ar1[i] + ar2[j]) > sum) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Closest pair is: "+ar1[ar1Ind] + " " + ar2[ar2Indx]);
    }

    public static void main(String[] args) {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;
        findClosest(ar1, ar2, m, n, x);
    }
}
