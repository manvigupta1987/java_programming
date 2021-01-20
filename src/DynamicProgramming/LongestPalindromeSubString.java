package DynamicProgramming;

import java.util.Arrays;
// // https://www.youtube.com/watch?v=XmSOWnL6T_I
//// Count number of palidromes substring in a string.

// https://www.youtube.com/watch?v=WpYHNHofwjc
public class LongestPalindromeSubString {

    static int longestPalindrome(String str) {
        boolean[][] T = new boolean[str.length()][str.length()];
        int maxPalinLen = 0;
        int starti = 0;
        int startj = 0;
        for (int i =0; i<str.length(); i++) {
            Arrays.fill(T[i], false);
        }
        // traverse the matrix diagonally.
        for (int start = 0; start<str.length(); start++) { // this loop basically indicates the diagonal.
            for (int i = 0, j = start; j<str.length() && i <str.length(); i++, j++) {
                // base cases
                // if its a zero dialognal, string will be of one character and palindrome
                if (start == 0) {
                    T[i][j] = true;
                } else if (start == 1) { // if its 1 diagonal, string will be only of 2 characters.
                    T[i][j] = (str.charAt(i) == str.charAt(j));
                } else { // palidrome condition, extreme should be equal and then i+1 and j-1 in the matrix should be the result.
                    if (str.charAt(j) == str.charAt(i)) {
                        T[i][j] = T[i + 1][j - 1];
                    }
                }
                if (T[i][j] == true) {
                    maxPalinLen = start+1;
                    starti = i;
                    startj = j+1;
                }
            }
        }
        System.out.println(str.substring(starti, startj));
        return maxPalinLen;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println("Longest palidrome length is "+longestPalindrome(str));
    }
}
