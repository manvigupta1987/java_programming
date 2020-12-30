package Strings;

//Given a string containing many consecutive spaces, trim all spaces so that all words should contain only a single space between them.
// The conversion should be done in-place and solution should handle trailing and leading spaces and also remove preceding spaces before
// common punctuation like full stop, comma and a question mark.

public class RemoveExtraSpaces {
    static boolean isSpaceBetweenWords(char[] str, int index) {
        return ((index-1 > 0) && (str[index - 1] >= 65 && str[index-1] <= 90 ||
                str[index - 1] >= 97 && str[index-1] <= 122 || str[index-1] == '.' || str[index-1] == ',' || str[index-1] == '?'));
    }
    static int removeSpaces(char[] str) {
        int i =0, j =0, len = str.length-1;
        boolean spaceFound = false;
        // remove leading spaces.
        while (str[i] == ' ' && i < str.length) {
            i++;
        }
        while (str[len] == ' ' && len >=0) {
            len--;
        }
        while (i <= len) {
            // if current character is not space.
            if (str[i] != ' ') {
                // remove the extra space before the ., ? or ,
                if ((str[i] == '.' || str[i] == ',' || str[i] == '?') &&
                        j-1 >=0 && str[j-1] == ' ') {
                    str[j-1] = str[i];
                } else {
                    //copy the character to the string.
                    str[j++] = str[i];
                }
                spaceFound = false;
            } else if (str[i] == ' ') {
                // If space is encountered for the first
                // time after a word, put one space in the
                // output and set space flag to true
                if (!spaceFound) {
                    str[j++] = ' ';
                    spaceFound = true;
                }
            }
            i++;
        }
        return j;
    }

    public static void main(String[] args) {
        char[] str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ".toCharArray();
        int count = removeSpaces(str);
        System.out.println("String after removing extra spaces =" + String.valueOf(str, 0, count).toString());
    }
}
