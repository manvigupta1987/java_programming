package BackTracking;

import java.util.ArrayList;
import java.util.List;

// Given a string S containing only digits, Your task is to complete the function genIp() which returns a
// vector containing all possible combination of valid IPv4 ip address and takes only a string S as its only argument.
// Condition for valid ip string is:
// 1. it should be in the format for x.x.x.x
//2 . x can be 0 or any number between 1 to 255
// 3. x can not be prefix with 0. Only 0 is allowed but 01 or any other number is not allowed.

public class GenerateIpAddresses {
    static List<String> result = new ArrayList<>();

    static void restoreIpAddress(String str) {
        if (str.length() < 4) {
            System.out.println("String is not valid");
            return;
        }
        restoreIp(str, 0, new ArrayList<>());
        System.out.println(result);
    }

    static void restoreIp(String str, int start, List<String> curr) {
        if (curr.size() == 4 && start == str.length()) {
            result.add(curr.get(0) + "." + curr.get(1) + "." + curr.get(2) + "." + curr.get(3));
            return;
        }

        if (curr.size() >= 4) {
            return;
        }

        for (int i =start; i<str.length() ; i++) {
            String newStr = str.substring(start, i+1);
            if (isVaildStr(newStr)) {
                curr.add(newStr);
                restoreIp(str, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    static boolean isVaildStr(String str) {
        // length should not be greater than 3.
        if (str.length() > 3) {
            return false;
        }
        // prefix should not be 0. 0 alone is valid
        if (str.startsWith("0") && str.length()>1) {
            return false;
        }
        // if string is not in the range of 0 to 255
        return (Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255);
    }

    public static void main(String[] args) {
        String str = "25525511135";
        restoreIpAddress(str);
    }
}
