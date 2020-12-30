package Strings;

public class CheckIfStringPalindrome {
    static void isPalindrome(String str) {
        int n = str.length();
        int low = 0, high = n-1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                System.out.println("String " + str + " is Not palindrome");
                return;
            }
            low++;
            high--;
        }
        System.out.println("String " + str +  " is palindrome");
    }
    public static void main(String[] args) {
        isPalindrome("abba");
        isPalindrome("abbccbba");
        isPalindrome("geeks");
    }
}
