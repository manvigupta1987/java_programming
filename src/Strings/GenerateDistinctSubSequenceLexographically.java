package Strings;

import java.util.TreeSet;

// Given a string s, make a list of all possible combinations of letters of a given string S. If there are two strings with the same set of characters, print the lexicographically smallest arrangement of the two strings
//
//For string abc, the list in lexicographic order subsequences are, a ab abc ac b bc c
//
//Examples:
//
//Input : s = "ab"
//Output : a ab b

// Solution:
// The idea is to use a set (which is implemented using self balancing BST) to store subsequences so that duplicates can be tested.
//To generate all subsequences, we one by one remove every character and recur for remaining string.


public class GenerateDistinctSubSequenceLexographically {
    static void generate(TreeSet<String> st, String s) {
        if (s.length() == 0) {
            return;
        }

        // If current string is not already present.
        if (!st.contains(s)) {
            st.add(s);

            // Traverse current string, one by one
            // remove every character and recur.
            for (int i = 0; i < s.length(); i++) {
                String t = s;
                t = t.substring(0, i) + t.substring(i + 1);
                generate(st, t);
            }
        }
        return;
    }
    public static void main(String[] args) {
        String s = "xyz";
        TreeSet<String> st = new TreeSet<>();
        generate(st, s);
        for (String str : st) {
            System.out.println(str);
        }
    }
}
