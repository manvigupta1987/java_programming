package Strings;

import java.util.HashSet;

// Given a string str, find the length of the longest substring without repeating characters.
//
//For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
//For “BBBB” the longest substring is “B”, with length 1.
//For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7


public class LongestSubstringWithoutRepeatingChars {
    static int longestUniqueSubsttr(String str) {
        int j = 0, maxCount = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        for (int i =0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
            } else {
                maxCount = Math.max(set.size(), maxCount);
                set.clear();
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        System.out.println("The input string is " + str);

        int len = longestUniqueSubsttr(str);
        System.out.println("The length of the longest " +
                "non-repeating character " +
                "substring is " + len);
    }
}
