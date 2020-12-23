package Strings;

//Given two strings, print all the common characters in lexicographical order. If there are no common letters, print -1. All letters are lower case.

//The idea is to use character count arrays.
//1) Count occurrences of all characters from ‘a’ to ‘z’ in first and second strings. Store these counts in two arrays a1[] and a2[].
//2) Traverse a1[] and a2[] (Note size of both is 26). For every index i, print character ‘a’ + i number of times equal min(a1[i], a2[i]).

public class PrintCommonCharsInAlphabeticalOrder {
    static void printCommon(String str1, String str2) {
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i=0; i< str1.length(); i++) {
            a1[str1.charAt(i) -'a']++;
        }
        for (int i=0; i< str2.length(); i++) {
            a2[str2.charAt(i) -'a']++;
        }

        for (int i =0; i< 26; i++) {
            if (a1[i] > 0 && a2[i] > 0 ) {
                int freq = Math.min(a1[i], a2[i]);
                for (int j = 0 ; j < freq ; j++)
                    System.out.print(((char)(i + 'a')));
            }
        }
    }
    public static void main(String[] args) {
        String s1 = "geeksforgeeks", s2 = "practiceforgeeks";
        printCommon(s1, s2);
    }
}
