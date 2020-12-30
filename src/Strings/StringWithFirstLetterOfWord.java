package Strings;

// A String str is given which contains lowercase English letters and spaces. It may contain multiple spaces. Get the first letter of every word
// and return the result as a string. The result should not contain any space.

public class StringWithFirstLetterOfWord {
    static String firstLetterWord(String str) {
        String res = "";
        boolean space = true;
        for (int i=0; i< str.length(); i++) {
            if (str.charAt(i) == ' ') {
                space = true;
            }
            if (str.charAt(i) != ' ' && space) {
                res += str.charAt(i);
                space = false;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "geeks for geeks";
        System.out.println(firstLetterWord(str));
    }
}
