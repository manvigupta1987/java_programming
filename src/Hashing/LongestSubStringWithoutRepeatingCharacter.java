package Hashing;
import java.util.HashSet;

// Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.


// Time complexity : O(2n) = O(n)O(2n)=O(n). In the worst case each character will be visited twice by ii and jj.
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubStringWithoutRepeatingCharacter {
    static int findLongestSubStringLength(String str){
        int len = str.length();
        HashSet<Character> set = new HashSet<>();

        int i =0, j = 0;
        int ans = 0;
        while (i < len && j < len) {
            char ch = str.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
                ans = Math.max(ans, set.size());
            } else {
                set.remove(str.charAt(i++));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "abcdeafbdgcbb";
        System.out.println( " Longest substring length is = "+ findLongestSubStringLength(str));
    }

}
