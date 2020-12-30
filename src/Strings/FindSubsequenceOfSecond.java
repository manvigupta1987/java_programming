package Strings;

// Problem: Given two strings str1 and str2, find if str1 is a subsequence of str2. A subsequence is a sequence that can be derived from another
// sequence by deleting some elements without changing the order of the remaining elements

// Solution : we traverse both strings from one side to other side (say from rightmost character to leftmost). If we find a matching character,
// we move ahead in both strings. Otherwise we move ahead only in str2.

public class FindSubsequenceOfSecond {
    static boolean isSubSequence(String str1, String str2, int len1, int len2) {
        int i = 0, j=0;

        if (len1 > len2) {
            return false;
        }

        // iterate over the strings and match the character of string1 with string2 in sequence.
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return (i == len1);
    }

    public static void main(String[] args) {
        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        int m = str1.length();
        int n = str2.length();
        boolean res = isSubSequence(str1, str2, m, n);

        if(res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
