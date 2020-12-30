package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// Given a string of length n, print all permutation of the given string. Repetition of characters is allowed. Print these permutations in lexicographically sorted order

// For an input string of size n, there will be n^n permutations with repetition allowed. The idea is to fix the first character at first index and
// recursively call for other subsequent indexes. Once all permutations starting with the first character are printed, fix the second character at
// first index. Continue these steps till last character.

public class PrintAllPermutationLexographically {
    static void allLexicographicRecur(String str, char[] data, int last, int index) {
        for (int i = 0; i< str.length(); i++) {
            data[index] = str.charAt(i);

            if (index == last) {
                System.out.println(new String(data));
            } else {
                allLexicographicRecur(str, data, last, index + 1);
            }
        }
    }
    static void allLexicographic(String str) {
        char[] data = new char[str.length()];
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        allLexicographicRecur(new String(temp), data, str.length() -1, 0);
    }
    public static void main(String[] args) {
        String str = "ABC";
        System.out.printf("All permutations with " +
                "repetition of %s are: \n", str);
        allLexicographic(str);
    }
}
