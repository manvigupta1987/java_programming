package Strings;

public class LeftAndRightRotateString {
    static String leftrotate(String str, int d ) {
        // add the string from d to end and then from 0 to d.
        return str.substring(d) + str.substring(0, d);
    }

    static String rightrotate(String str, int d) {
        return leftrotate(str, str.length() -d);
    }

    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        System.out.println(leftrotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(rightrotate(str2, 2));
    }
}
