package Strings;

//Problem: Given a string and a number k, find the longest subsequence of a string where every character appears at-least k times.

//Find the frequency of the string and store it in an integer array of size 26 representing the alphabets.
//2. After finding the frequency iterate the string character by character and if the frequency of that character is greater than or
// equal to the required number of repetitions then print that character then and there only.

public class LongestSubsequenceWithEveryCharAppearsKtime {
    static String findSequence(String str, int freq) {
        int[] visited = new int[26];
        for (int i=0; i< str.length(); i++) {
            visited[str.charAt(i) - 'a']++;
        }
        char[] res = new char[str.length()];
        for (int i =0; i<str.length(); i++ ) {
            if (visited[str.charAt(i)-'a'] >= freq ) {
                res[i] = str.charAt(i);
            }
        }
        return new String(res);
    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int k = 2;
        System.out.println("Longest Subsequence is : " + findSequence(str, k));
    }
}
