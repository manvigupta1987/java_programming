package Strings;

import java.util.Arrays;
import java.util.HashMap;

// Given a string of lower alphabet characters, count total substring of this string which are anagram to each other.
// Input  : str = “xyyx”
//Output : 4
//Total substrings of this string which
//are anagram to each other are 4 which
//can be enumerated as,
//{“x”, “x”}, {"y", "y"}, {“xy”, “yx”},
//{“xyy”, “yyx”}

// Solution:
// Create a hashMap with the substring (sorted) as a key and corresponding counts as values.
// Once occurrence ‘o’ of each frequency array is stored, total anagrams will be the sum of o*(o-1)/2 for all different frequency
// arrays because if a particular substring has ‘o’ anagrams in string total o*(o-1)/2 anagram pairs can be formed.
// https://www.geeksforgeeks.org/count-total-anagram-substrings/

public class AnagramPairCount {
    static void subString(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i< str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                char[] subString = str.substring(i, j+1).toCharArray();
                Arrays.sort(subString);
                String val = new String(subString);
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }
        }
        int anagramCount = 0;
        for (String key : map.keySet()) {
            int val = map.get(key);
            anagramCount += (val*(val-1))/2;
        }
        System.out.println(anagramCount);
    }
    public static void main(String[] args) {
        subString("xyyx");
    }
}
