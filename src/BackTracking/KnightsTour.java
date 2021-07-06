package BackTracking;

import java.util.Arrays;

public class KnightsTour {
    static int N = 8;
    static void printSolution(int[][] sol) {
        for (int i =0; i<N; i++) {
            for (int j =0; j<N; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveKTUtil(int[][] sol, int row, int col, int move ) {

        // Base case when move is equal to the number of squares in the chess.
        if (move == N*N) {
            printSolution(sol);
            return true;
        }
         /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int k = 0; k < 8; k++) {
            int next_x = row + xMove[k];
            int next_y = col + yMove[k];
            if (isSafe(sol, next_x, next_y)) {
                sol[next_x][next_y] = move;
                if(solveKTUtil(sol, next_x, next_y, move + 1) == true) {
                    return true;
                }
                sol[next_x][next_y] = -1;
            }
        }
        return false;
    }

    static boolean isSafe(int[][] sol, int row, int col) {
        return (row >= 0 && row < N && col>=0 && col<N && sol[row][col] == -1);
    }

    static void solveKT() {
        int[][] sol = new int[N][N];
        for (int i = 0; i<N; i++) {
            Arrays.fill(sol[i], -1);
        }

        sol[0][0] = 0;
        solveKTUtil(sol, 0, 0, 1);
    }

    public static void main(String[] args) {
        solveKT();
    }
}
