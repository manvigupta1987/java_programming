package BackTracking;

public class Soduku {
    // N is the size of the 2D matrix   N*N
    static int N = 9;

    static void printSolution(int[][] sol) {
        for (int i =0; i<N; i++) {
            for (int j =0; j<N; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveSodukuUtil(int[][] grid, int row, int col) {

        //Base condition
        if (row == N-1 && col == N) {
            return true;
        }

        if (col == N) {
            row++;
            col = 0;
        }

        // Check if the current position of the grid already contains value >0, we iterate for next column
        if (grid[row][col] != 0) {
            return solveSodukuUtil(grid, row, col+1);
        }

        for (int num = 1; num < 10; num++ ) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (solveSodukuUtil(grid, row, col+1) == true) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int[][] grid, int row, int col, int num) {

        // Check if we find the same num in the similar row , we return false
        for (int i = 0; i<N; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }

        // Check if we find the same num in the similar column , we return false
        for (int i = 0; i<N; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        //check if we find the same num in the 3 * 3 matrix
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i<3; i++) {
            for (int j = startCol; j<3; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void solveSoduku(int[][] grid) {
        if (solveSodukuUtil(grid, 0, 0) == false) {
            System.out.println("Solution does not exist");
            return;
        }
        printSolution(grid);
    }

    public static void main(String[] args) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        solveSoduku(grid);
    }
}
