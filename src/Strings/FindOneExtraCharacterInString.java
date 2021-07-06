package Strings;

//Given two strings which are of lengths n and n+1. The second string contains all the character of the first
// string, but there is one extra character. Your task to find the extra character in the second string.

//Time Complexity:- O(n+n+1)
//Space Complexity:- O(1).

// (1) If you take xor of a number with 0 ( zero ) , it would return the same number again.
//
//Means , n ^ 0 = n
//
//(2) If you take xor of a number with itself , it would return 0 ( zero ).
//
//Means , n ^ n = 0
public class FindOneExtraCharacterInString {
    static char findExtraCharcter(String str1, String str2) {
        int i =0;
        int res = 0;
        while (i < str1.length()) {
            res ^= str1.charAt(i);
            i++;
        }
        i = 0;
        while ( i < str2.length()) {
            res ^= str2.charAt(i);
            i++;
        }
        return (char)res;
    }

    public static void main(String[] args) {
        // given string
        String strA = "abcd";
        String strB = "cbdad";
        System.out.println(findExtraCharcter(strA, strB));
    }
}
