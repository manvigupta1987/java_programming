package Strings;

public class ReverseAString {
    static String reverseString(String str) {
        if (str.length() == 1) {
            return str;
        }
        int left = 0, right = str.length() -1;
        char[] ch = str.toCharArray();
        while (left != right) {
            int temp = ch[left];
            ch[left] = ch[right];
            ch[right] = ch[left];
            left++;
            right--;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        System.out.println(reverseString(str));
    }
}
