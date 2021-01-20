package BackTracking;

// The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. For example, following is a solution for 4 Queen problem.
// https://www.youtube.com/watch?v=05y82cP3bJo

public class NQueensProblem {
    static int N = 4;

    static void printSolution(int[][] sol) {
        for (int i =0; i<N; i++) {
            for (int j =0; j<N; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int row, int col, int[][] board) {
        // check vertically in the upper direction
        for (int i = row-1, j = col; i>=0; i--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check left upper diagonal
        for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check right upper diagonal
        for (int i = row-1, j = col+1; i>=0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean solveNQUtil(int[][] board, int row) {
        // base condition
        if (row >= N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col, board)) {
                board[row][col]  = 1;
                if (solveNQUtil(board, row +1) == true) {
                    return true;
                }
                // backtracking
                board[row][col]  = 0;
            }
        }
        return false;
    }
    static void solveNQ() {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return;
        }
        printSolution(board);
    }
    public static void main(String[] args) {
        solveNQ();
    }
}
