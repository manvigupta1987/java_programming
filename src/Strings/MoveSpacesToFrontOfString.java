package Strings;

// Given a string that has set of words and spaces, write a program to move all spaces to front of string, by traversing the string only once.

// Solution: copy all non-space characters to end. Finally copy spaces.

public class MoveSpacesToFrontOfString {
    static void moveSpaceInFront(char[] str) {
        int i = str.length -1;
        for (int j = i; j>=0; j--) {
            if (str[j] != ' ') {
                str[i--] = str[j];
            }
        }

        while (i >= 0) {
            str[i--] = ' ';
        }
    }
    public static void main(String[] args) {
        char str[] = "Hey there, it's GeeksforGeeks".toCharArray();
        moveSpaceInFront(str);
        System.out.println(String.valueOf(str));
    }
}
