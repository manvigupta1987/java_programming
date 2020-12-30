package Strings;

// Problem: Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them

// Solution:
// problem can be solved using the recursion. We will fix the position of 0th element and then, we will place spaces on by one and generate a new string.

public class PrintStringsWithPlacingSpaces {
    static void printSubsequences(String str, char[] res, int i, int j, int len ) {
        if (j == len) {
            System.out.println(String.valueOf(res));
            return;
        }

        res[i] = str.charAt(j);
        printSubsequences(str, res, i+1, j+1, len);
        res[i] = ' ';
        res[i+1] = str.charAt(j);
        printSubsequences(str, res, i+2, j+1, len);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        char[] res = new char[str.length()*2];
        res[0] = str.charAt(0);
        printSubsequences(str, res, 1, 1, str.length());
    }
}
