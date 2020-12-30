package Strings;

//Write a method to replace all the spaces in a string with ‘%20’. You may assume that the string has sufficient space at the end to hold the additional characters and that you are given the “true” length of the string.

// Solution:
// We first count the number of spaces in the input string. Using this count, we can find the length of the modified (or result) string.
// After computing the new length we fill the string in-place from the end.

public class ReplaceSpaceWithString {
    static char[] replaceSpaces(char[] str) {
        int spaceCount = 0, i =0;
        while (i < str.length) {
            if (str[i] == ' ') {
                spaceCount++;
            }
            i++;
        }
        while (str[i-1] == ' ') {
            spaceCount--;
            i--;
        }

        int new_len = i + spaceCount*2;
        int index = new_len -1;
        char[] old_str = str;
        str = new char[new_len];

        for (int j = i-1; j>= 0; j--) {
            if (old_str[j] == ' ') {
                str[index] = '0';
                str[index-1] = '2';
                str[index-2] = '%';
                index = index-3;
            } else {
                str[index] = old_str[j];
                index--;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        char[] str = "Mr John Smith ".toCharArray();

        // Prints the replaced string
        str = replaceSpaces(str);

        for (int i = 0; i < str.length; i++)
            System.out.print(str[i]);
    }
}
