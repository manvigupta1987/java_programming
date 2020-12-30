package Strings;

public class RemoveSpacesFromString {
    static String removeSpaces(char[] str) {
        if (str.length == 1) {
            return new String(str);
        }
        int i =0, j=0;
        int count = 0;
        while (i < str.length) {
            if (str[i] != ' ') {
                str[count] = str[i];
                count++;
            }
            i++;
        }
        return new String(str, 0, count);
    }
    public static void main(String[] args) {
        String str = "g  eeks   for ge  eeks  ";
        System.out.println("String after removing spaces " + removeSpaces(str.toCharArray()));
    }
}
