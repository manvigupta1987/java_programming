package DynamicProgramming;

// Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
//For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
// there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

// idea is to a array of N +1 size and start calculating the coins needed for that particular sum.
// fill the T[0] with 1.

// https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13
public class CoinsChangeCombinations {
    static int findCombinations(int N, int[] coins) {
        int[] T = new int[N+1];
        T[0] = 1;

        for (int i = 0; i<coins.length; i++) {
            for (int j = coins[i]; j< N+1; j++) {
                // calculates the combinations of coins needed to make that sum.
                T[j] += T[j - coins[i]];
            }
        }
        return T[N];
    }

    public static void main(String[] args) {
        int N = 4;
        int[] coins = {1, 2, 3};

        System.out.println(findCombinations(N, coins));
    }
}
