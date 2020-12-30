package Strings;

// Given a string S. The task is to print all the possible rotated strings of the given string.

// Solution:
 // We concatenate str with itself, i.e., we do str.str where . is concatenation operator. Now we traverse the concatenated string from 0 to n – 1 and print all substrings of size n.

public class GenerateAllRotationOfString {
    static void generateRotations(String str) {

        StringBuffer sb = new StringBuffer(str);
        sb.append(str);
        for (int i =0; i< str.length(); i++) {
            char[] result = new char[str.length()];
            for (int j=0; j<str.length(); j++) {
                result[j] += sb.charAt(i + j);
            }
            System.out.println(new String(result));
        }
    }

    public static void main(String[] args) {
        String str = "geeks";

        generateRotations(str);
    }
}
