package Strings;

//Given a number as string, remove recurring digits from the given string. The changes must be made in-place. Expected time complexity O(n) and auxiliary space O(1).
//
//Examples:
//
//Input:  num[] = "1299888833"
//Output: num[] = "12983"

public class RemoveReoccuringDigits {
    static String removeRecurringDigits(char[] num) {
        String res = "";
        for (int i= 0; i< num.length; i++) {
            res += num[i];
            while (i+1 < num.length && num[i] == num[i+1]){
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        char num[] = "1299888833".toCharArray();
        System.out.print("Modified number is " + removeRecurringDigits(num));
    }
}
