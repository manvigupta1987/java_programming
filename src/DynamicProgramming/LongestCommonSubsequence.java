package DynamicProgramming;

// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
//LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

// https://www.youtube.com/watch?v=NnD96abizww
// Idea is to create a matrix between both the substrings and find out the longest
// common length by including one one character of both the strings.

public class LongestCommonSubsequence {
    static int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] T = new int[len1+1][len2+1];

        for (int i =0; i<= len1; i++) {
            for (int j=0; j<= len2; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    T[i][j] = T[i-1][j-1] + 1;
                } else {
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
                }
            }
        }
        return T[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of LCS is" + " " + longestCommonSubsequence(s1, s2));

    }
}
