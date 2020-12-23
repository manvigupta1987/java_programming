package Strings;

import Utils.Utils;

//The idea is based on school mathematics. We traverse both strings from end, one by one add digits and keep track of carry. To simplify the process, we do following:
//1) Reverse both strings.
//2) Keep adding digits one by one from 0’th index (in reversed strings) to end of smaller string, append the sum % 10 to end of result and keep track of carry as sum/10.
//3) Finally reverse the result.

//O(n1 + n2) where n1 and n2 are lengths of two input strings representing numbers.

public class SumOfTwoLargeNumbers {
    static String findSum(String str1, String str2) {
        // Always make sure that length of Str2 is greater thanStr1.
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 > n2) {
            Utils.swapStrings(str1, str2);
        }

        int diff = n2 - n1;
        int carry = 0;
        String str = "";
        for (int i = n1-1; i>=0; i--) {
            int sum = ((int)(str1.charAt(i) - '0') + (int)(str2.charAt(i+diff) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        for (int i = n2-n1-1; i >= 0; i--) {
            int sum = (int)((str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        // Add remaining carry
        if (carry > 0) {
            str += (char)(carry + '0');
        }

        return new StringBuilder(str).reverse().toString();

    }
    public static void main(String[] args) {
        String str1 = "12";
        String str2 = "198111";
        System.out.println(findSum(str1, str2));
    }
}
