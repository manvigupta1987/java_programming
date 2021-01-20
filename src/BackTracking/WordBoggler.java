package BackTracking;

import java.util.Arrays;
import java.util.List;

// Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
//
//Example:
//
//Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
//       boggle[][]   = {{'G', 'I', 'Z'},
//                       {'U', 'E', 'K'},
//                       {'Q', 'S', 'E'}};
//      isWord(str): returns true if str is present in dictionary
//                   else false.
//
//Output:  Following words of dictionary are present
//         GEEKS
//         QUIZ
// https://www.youtube.com/watch?v=T0z1VFXegQk

public class WordBoggler {
    static final int M = 3, N = 3;

    static boolean isSafe(int row, int col, boolean[][] visited) {
        return (row >= 0 && row <M && col>= 0 && col < N && visited[row][col] == false);
    }

    static void findWordsUtil(boolean[][] visited, int row, int col, char[][] boggle, String word, List<String>dictionary) {
        if (dictionary.contains(word)) {
            System.out.println(word);
        }

        if (word.length() == M*N) {
            return;
        }
        // these two arrays represents the 8 direction from row and col.
        int rowNbr[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int colNbr[] = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int i = 0; i<8; i++) {
            int rowNew = row + rowNbr[i];
            int colNew = col + colNbr[i];

            if (isSafe(rowNew, colNew, visited )) {
                visited[rowNew][colNew] = true;
                findWordsUtil(visited, rowNew, colNew, boggle, word + boggle[rowNew][colNew] , dictionary);
                visited[rowNew][colNew] = false;
            }
        }
    }

    static void findWords(char[][] boggle, List<String> dictionary) {
        boolean visited[][] = new boolean[M][N];
        for (int i =0; i<M; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i =0; i<M; i++) {
            for (int j =0; j<N; j++) {
                visited[i][j] = true;
                findWordsUtil(visited, 0, 0, boggle, ""+boggle[i][j], dictionary);
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        char boggle[][] = { { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' } };

        String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };

        System.out.println("Following words of dictionary are present");
        findWords(boggle, Arrays.asList(dictionary));
    }
}
