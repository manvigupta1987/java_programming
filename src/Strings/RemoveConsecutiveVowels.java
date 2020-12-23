package Strings;

import java.util.Arrays;
import java.util.List;

public class RemoveConsecutiveVowels {
    static String removeVowels(String str) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        List<Character> vowelList = Arrays.asList(vowels);
        StringBuffer sb = new StringBuffer(str);
        int start = 0;
        for (int i=1; i< sb.length(); i++) {
            if (vowelList.contains(sb.charAt(i)) && sb.charAt(i) == sb.charAt(start)) {
                sb.replace(start, i, "");
                i--;
            } else {
                start++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "GeeeksforGeeks - A Computer Science Portal for Geeksee";

        System.out.println(removeVowels(str));
    }
}


