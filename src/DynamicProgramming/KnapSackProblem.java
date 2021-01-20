package DynamicProgramming;
// Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).


// Idea is to create a matrix between the weights and totalWeight. Each matrix value indicates the max value if the product is included
// or left.

public class KnapSackProblem {
    static int knapSack(int totalW, int[] weightArr, int[] valueArr) {
        int length = valueArr.length;
        int[][] T = new int[length+1][totalW+1];
        for (int i =0; i<=length; i++) {
            for (int j = 0; j <= totalW; j++) {
                // when weight is 0 or capacity of knapsack is zero.
                if (i == 0 || j ==0) {
                    T[i][j] = 0;
                } else if (weightArr[i-1] > j ) { // if weight is more than the capacity of knapsack, then copy the value from the above matrix index as this weight can't be included.
                    T[i][j] = T[i-1][j];
                } else { // consider the max value if the item is included and item not included.
                    T[i][j] = Math.max(T[i-1][j], valueArr[i-1] + T[i-1][j-weightArr[i-1]]);
                }
             }
        }
        return T[length][totalW];
    }
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val));
    }
}
