package DynamicProgramming;

// Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
//
//Insert
//Remove
//Replace
//All of the above operations are of equal cost.

// Solution : Idea is to create a matrix where row indicates the str1 and col indicates str2. This indicates that how many edits are required for str1 to match with str2.
// So, if the char in the row is same as col, then take the value from the upper left diagonal. if the char is not same, the take the min from (upper diagonal , just above value and left side val) + 1.

// https://www.youtube.com/watch?v=We3YDTzNXEk&t=410s

// Time Complexity: O(m x n)
public class EditDistance {
    static int findEdits(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Create a table to store results of subproblems
        int[][] T = new int[len1+1][len2+1];

        for (int i =0; i<= len1; i++) {
            for (int j=0; j<= len2; j++) {
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0 ) {
                    T[i][j] = j;
                } else if (j ==0) {  // If second string is empty, only option is
                    // to remove all characters of second string
                    T[i][j] = j+1;
                }
                // If last characters are same, ignore last
                // char and recur for remaining string
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    T[i][j] = T[i-1][j-1];
                } else { // If the last character is different, consider all possibilities and find the minimum
                    T[i][j] = Math.min(Math.min(T[i-1][j], T[i][j-1]), T[i-1][j-1]) + 1;
                }
            }
        }
        return T[len1][len2];
    }
    public static void main(String[] args) {
        String s1 = "azced";
        String s2 = "abcdef";

        System.out.println("Minimum Edits required are " + " " + findEdits(s1, s2));
    }
}
