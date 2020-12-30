package Strings;

public class ReverseVowelsInString {
    static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'A' ||
                ch == 'e' || ch == 'E' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U' ||
                ch == 'i' || ch == 'I');
    }
    static String reverseVowel(String str) {
        char[] str1 = str.toCharArray();
        int i =0, j = str.length()-1;

        while (i < j) {
            if (!isVowel(str1[i])) {
                i++;
                continue;
            }
            if (!isVowel(str1[j])) {
                j--;
                continue;
            }

            // swapping
            char t = str1[i];
            str1[i]= str1[j];
            str1[j]= t;

            i++;
            j--;
        }
        return new String(str1);

    }
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(reverseVowel(str));
    }
}
