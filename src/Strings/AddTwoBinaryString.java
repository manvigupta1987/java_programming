package Strings;

//Given two binary strings, return their sum (also a binary string).

// The idea is to start from last characters of two strings and compute digit sum one by one. If sum becomes more than 1, then store carry for next digits.
public class AddTwoBinaryString {
    static String addBinary(String a, String b) {
        int i = a.length()-1 , j = b.length()-1;
        int sum = 0;
        String res = "";
        // Traverse both strings starting from last character.
        while (i >=0 || j >= 0 || sum == 1) {
            //compute sum of last digit and carry.
            sum += (i >=0)? (a.charAt(i) -'0') : 0;
            sum += (j >=0)? (b.charAt(j) -'0') : 0;

            res = (char)(sum%2 + '0') + res;
            // compute carry.
            sum = sum /2;

            i--;
            j--;
        }
        return res;
    }
    public static void main(String[] args) {
        String a = "1101", b="100";

        System.out.print(addBinary(a, b));
    }
}
