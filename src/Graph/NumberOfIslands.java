package Graph;

// https://www.geeksforgeeks.org/find-number-of-islands/
// Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands

// The problem can be easily solved by applying DFS() on each component. In each DFS() call, a component or a sub-graph is visited. We will call DFS on the next un-visited component. The number of calls to DFS() gives the number of connected components. BFS can also be used.
// A cell in 2D matrix can be connected to 8 neighbours. So, unlike standard DFS(), where we recursively call for all adjacent vertices, here we can recursively call for 8 neighbours only. We keep track of the visited 1s so that they are not visited again.

// https://www.youtube.com/watch?v=__98uL6wst8

public class NumberOfIslands {
    static final int ROW = 5, COL = 5;

    static boolean isSafe(int M[][], int row, int col,
                          boolean visited[][]) {
        return (row >= 0 && row < ROW && col >=0 && col < COL && M[row][col] ==  1 && !visited[row][col]);
    }
    static void DFSUtil(int M[][], int row, int col, boolean visited[][]) {
        visited[row][col] = true;

        // these two arrays represents the 8 direction from row and col.
        int rowNbr[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int colNbr[] = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int k =0; k<8; k++) {
            if (isSafe(M, row+rowNbr[k], col+colNbr[k], visited)) {
                DFSUtil(M, row+rowNbr[k], col+colNbr[k], visited);
            }
        }
    }
    static int countIslands(int[][] M) {
        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;
        for (int i =0; i<ROW; i++) {
            for (int j= 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFSUtil(M, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println("Number of islands is: " + countIslands(M));

    }
}
