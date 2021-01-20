package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// Given a string of length n, print all permutation of the given string. Repetition of characters is allowed. Print these permutations in lexicographically sorted order

// For an input string of size n, there will be n^n permutations with repetition allowed. The idea is to fix the first character at first index and
// recursively call for other subsequent indexes. Once all permutations starting with the first character are printed, fix the second character at
// first index. Continue these steps till last character.

public class PrintAllPermutationLexographically {
    static void allLexicographicRecur(String str, List<Character> data) {
        if(data.size() == str.length()) {
            System.out.println(data.stream().map(String::valueOf).collect(Collectors.joining()));
        } else {
            for (int i = 0; i< str.length(); i++) {
                // if you dont want to include same character in the string again, include this check
                // if(data.contains(str.charAt(i)) continue;
                data.add(str.charAt(i));
                allLexicographicRecur(str, data);
                data.remove(data.size() - 1);
            }
        }
    }
    static void allLexicographic(String str) {
        List<Character> data = new ArrayList<>();
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        allLexicographicRecur(new String(temp), data);
    }
    public static void main(String[] args) {
        String str = "ABC";
        System.out.printf("All permutations with " +
                "repetition of %s are: \n", str);
        allLexicographic(str);
    }
}
