package Hashing;

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.

// https://leetcode.com/problems/valid-sudoku/

import java.util.HashSet;

public class validateSoduku {
    static boolean isValidSudoku(String[][] board) {
        HashSet<Integer> [] rows = new HashSet[9];
        HashSet<Integer> [] cols = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];

        for (int i = 0; i< 9; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        for (int i = 0; i< 9; i++) {
            for (int j =0; j < 9; j++) {
                String num = board[i][j];
                if(num != ".") {
                    int n = Integer.valueOf(num);
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (!rows[i].add(n) || !cols[j].add(n) || !boxes[boxIndex].add(n)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] board =
                {{"5","3",".",".","7",".",".",".","."}
                ,{"6",".",".","1","9","5",".",".","."}
                ,{".","9","8",".",".",".",".","6","."}
                ,{"8",".",".",".","6",".",".",".","3"}
                ,{"4",".",".","8",".","3",".",".","1"}
                ,{"7",".",".",".","2",".",".",".","6"}
                ,{".","6",".",".",".",".","2","8","."}
                ,{".",".",".","4","1","9",".",".","5"}
                ,{".",".",".",".","8",".",".","7","9"}};

        System.out.println(isValidSudoku(board));
    }
}
