package Sorting;

import java.util.Arrays;

//An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.
//For the below array, program should print -80 and 85.
//https://java2blog.com/find-pair-whose-sum-is-closest-to-zero-in-array/
public class FindPairWithMinSum {

    // this method gives the compplexity of O(NLog(n))
    private static void findMinSumPair(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n <= 0) {
            return;
        }
        int l = 0, r = n - 1;
        int sum = 0, minSum = Integer.MAX_VALUE;
        int minL = l, minR = r;
        while (l < r) {
            sum = arr[l] + arr[r];
            if(Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minL = l;
                minR= r;
            }
            if(sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("The pair whose sum is close to zero is : " + arr[minL] + " " + arr[minR]);
    }

    //// this method gives the compplexity of O(n2)
    public static void findMinSumPairWithBruteForce(int[] arr) {
        int sum = 0;
        if(arr.length < 2) {
            return;
        }

        int minSum = Integer.MAX_VALUE;
        int minL = -1;
        int minR = -1;
        for(int i =0; i < arr.length; i++) {
            for (int j=1; j<arr.length; j++) {
                sum = arr[i] + arr[j];
                if(Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    minL = i;
                    minR = j;
                }
            }
         }
        System.out.println(" The pair whose sum is closest to zero with brute force is : "+arr[minL]+" "+ arr[minR]);
    }
    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        findMinSumPairWithBruteForce(arr);
        findMinSumPair(arr);
    }
}
