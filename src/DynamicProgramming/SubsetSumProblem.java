package DynamicProgramming;

// Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to
// given sum.

// Idea is to take a two dimensional matrix which stores if sum of array elements is equal to the num.

// https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11
public class SubsetSumProblem {

    static boolean findSubSet(int[] arr, int sum) {
        int[][] T = new int[arr.length + 1][ sum +1];
        T[0][0] = 1;
        for (int i =0; i< arr.length; i++) {
            for (int j = arr[i]; j<sum+1; j++) {
                T[i+1][0] = T[0][0];
                T[i+1][j] = Math.max(T[i][j], T[i][j-arr[i]]);
            }
        }
        return T[arr.length][sum] == 1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3 ,7};
        int sum = 11;

        if (findSubSet(arr, sum)) {
            System.out.println("Yes" );
        } else {
            System.out.println( "No" );
        }
    }
}
