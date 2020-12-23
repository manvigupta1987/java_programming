package Strings;

import java.util.ArrayList;

//Pangram is a sentence containing every letter in the English alphabet.
public class MissingCharsToMakeAStringPangram {
    static ArrayList<Character> missingChars(String str) {
        int i = 0;
        boolean a[] = new boolean[26];
        while ( i < str.length()) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                a[str.charAt(i) - 'A'] = true;
            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                a[str.charAt(i) - 'a'] = true;
            i++;
        }
        ArrayList<Character> res = new ArrayList<>();
        // Store missing characters in alphabetic order.
        for (int j = 0; j<a.length; j++) {
            if (!a[j]) {
                res.add((char)(j + 'a'));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the dog";
        ArrayList<Character> missing = missingChars(str);
        if (missing.size() >= 1)
        {
            for(Character character : missing)
            {
                System.out.print(character);
            }
        }
    }
}
