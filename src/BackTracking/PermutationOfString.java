package BackTracking;

import java.util.HashMap;

// https://www.youtube.com/watch?v=4-Makzrj5qM
// Find permutations of a string using backtracking.

public class PermutationOfString {
    static void generateWords(int index, int len, HashMap<Character,Integer> map, String result) {
        if (index == len) {
            System.out.println(result);
            return;
        }
        for (Character ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch)-1);
                generateWords(index +1, len, map, result + ch);
                map.put(ch, map.get(ch)+1);
            }
        }
    }
    static void findPermutation(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0; i<str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        generateWords(0, str.length(), map, "" );

    }
    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str);
    }
}