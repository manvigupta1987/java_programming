package Strings;

// We are given a string S, we need to find count of all contiguous substrings starting and ending with same character.
// Input  : S = "aba"
//Output : 4
//The substrings are a, b, a and aba
// Now if we carefully observe then we can realize that the answer just depends on frequencies of characters in the original string.
// For example in string abcab, frequency of ‘a’ is 2 and substrings contributing to answer are a, abca and a respectively, a total of 3,
// which is calculated by (frequency of ‘a’+1)C2.


public class CountSubstringsWithSameFirstAndLastChars {
    static int countSubstringWithEqualEnds(String str) {
        int[] count = new int[26];
        for (int i = 0; i< str.length(); i++) {
            count[str.charAt(i) - 'a'] ++;
        }

        int res = 0;
        for (int i = 0; i< 26; i++) {
            res += (count[i] * (count[i] + 1) / 2);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(countSubstringWithEqualEnds(s));
    }
}
