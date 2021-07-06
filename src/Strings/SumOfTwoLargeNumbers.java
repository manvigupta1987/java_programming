package Strings;

import Utils.Utils;

//The idea is based on school mathematics. We traverse both strings from end, one by one add digits and keep track of carry.
// To simplify the process, we do following:
//1) Reverse both strings.
//2) Keep adding digits one by one from 0’th index (in reversed strings) to end of smaller string, append the sum % 10 to end of result and keep track of carry as sum/10.
//3) Finally reverse the result.

//O(n1 + n2) where n1 and n2 are lengths of two input strings representing numbers.

public class SumOfTwoLargeNumbers {
    static String findSum(String str1, String str2) {
        // Always make sure that length of Str2 is greater thanStr1.
        int n1 = str1.length();
        int n2 = str2.length();
        String str = "";

        int i = n1 -1 , j = n2-1;
        int sum = 0, carry = 0;
        while(i >= 0 || j >= 0 ) {
            sum = carry;
            if (i >= 0) {
                sum += str1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += str2.charAt(j--) - '0';
            }

            str += String.valueOf(sum %10);
            carry = sum >= 10 ? 1: 0;
        }

        if ( carry > 0) {
            str += String.valueOf(carry);
        }
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "456";
        String str2 = "998";
        System.out.println(findSum(str1, str2));
    }
}
