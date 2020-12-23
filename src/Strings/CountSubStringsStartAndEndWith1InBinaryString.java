package Strings;

// Given a binary string, count number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.

// Since here we don't need to consider the single character string, formula that we can use is Suppose frequency of 1 is m. Number of subString is m(m-1)/2.

public class CountSubStringsStartAndEndWith1InBinaryString {

    static int countSubStr(char[] str, int len) {
        int count =0;

        for (int i=0; i< len; i++) {
            if (str[i] == '1') {
                count++;
            }
        }
        return count*(count -1)/2;
    }

    public static void main(String[] args) {
        String string = "00100101";
        char str[] = string.toCharArray();
        int n = str.length;
        System.out.println(countSubStr(str, n));
    }
}
