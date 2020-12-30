package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

// Given a string, find concatenation of all substrings in lexicographic order.
//
//Examples:
//
//Input : s = “abc”
//Output : aababcbbcc
//The substrings of s in lexicographic order are “a”, “b”, “c”, “ab”, “abc”, “bc”. Concatenation of substrings is “a”+”ab”+”abc”+”b”+”bc”+”c” = “aababcbbcc”.


public class LexographicallyConcatenateSubstrings {
    static void lexicographicSubConcat(String s, ArrayList<String> arr) {
        if (s.length() == 0) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j<=s.length()-i; j++ ) {
                arr.add(s.substring(i, i+j));
            }
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> arr = new ArrayList<>();
        lexicographicSubConcat(s, arr);
        Collections.sort(arr);
        String res = "";
        for (String item : arr) {
            res += item;
        }
        System.out.println("Concatenated string is: " + res);
    }
}
