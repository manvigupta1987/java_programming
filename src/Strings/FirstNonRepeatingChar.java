package Strings;

import java.util.HashMap;
import java.util.Map;

// Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”, then the output should be ‘f’
// and if the input string is “GeeksQuiz”, then the output should be ‘G’.

// Solution:
//1. Store the character and index of the char in the hash map.
//2. set the index as -1 for the repeating characters in the hashmap.
//3. traverse the hashmap and find the first non repeating character by comparing the index.

public class FirstNonRepeatingChar {
    static int firstNonRepeating(String str) {
        HashMap<Character, Integer> hashMap= new HashMap<>(); // Map that contains character and index of non repeating characters.

        for (int i =0; i< str.length(); i++) {
            Character ch = str.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, -1);
            } else {
                hashMap.put(ch, i);
            }
        }

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> map: hashMap.entrySet()) {
            int index = map.getValue();
            if (index > -1 && index < result) {
                result = index;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "abcdabce";
        int index = firstNonRepeating(str);

        if (index == Integer.MAX_VALUE) {
            System.out.print("No non-repeating char is found");
        } else {
            System.out.print("first Non repeating char is found at: " + str.charAt(index));
        }
    }
}
