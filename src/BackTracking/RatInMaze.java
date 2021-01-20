package BackTracking;

//A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
//
//In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination.


// Solution:
// Create a solution matrix, initially filled with 0’s.
//Create a recursive function, which takes initial matrix, output matrix and position of rat (i, j).
//if the position is out of the matrix or the position is not valid then return.
//Mark the position output[i][j] as 1 and check if the current position is destination or not. If destination is reached print the output matrix and return.
//Recursively call for position (i+1, j) and (i, j+1).
//Unmark position (i, j), i.e output[i][j] = 0.

public class RatInMaze {

    static void printSolution(int[][] sol) {
        for (int i =0; i<sol.length; i++) {
            for (int j =0; j<sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] maze, int x, int y) {
        int len = maze.length;
        return (x >= 0 && x < len && y>=0 && y<len && maze[x][y] ==1);
    }

    static boolean solveMazeUtil(int[][] sol, int[][] maze, int x, int y, int len) {
        // if x and y are the destination
        if ( x == len-1 && y == len-1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;
            // move in direction of x
            if (solveMazeUtil(sol, maze, x+1, y, len)) {
                return true;
            }
            // move in the direction of y.
            if (solveMazeUtil(sol, maze, x, y+1, len)) {
                return true;
            }
            // if x and y both are not solution, then reset it // backtracking
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    static void solveMaze(int[][] maze, int len) {
        int[][] sol = new int[len][len];

        if (solveMazeUtil(sol, maze, 0, 0, len) == false) {
            System.out.print("Solution doesn't exist");
            return;
        }

        printSolution(sol);
    }
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        solveMaze(maze, maze.length);
    }
}
