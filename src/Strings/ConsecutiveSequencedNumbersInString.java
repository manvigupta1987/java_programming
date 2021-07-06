package Strings;

// Given a string that contains only numeric digits, we need to check whether that strings contains numbers in
// consecutive sequential manner in increasing order.
//Note: Negative numbers are not considered part of this problem. So we consider that input only contains positive integer.
public class ConsecutiveSequencedNumbersInString {
    public static boolean checkConsective(String str1, String str, String prev) {
        if (str1.length() >= str.length()) {
            return str1.equals(str);
        }
        prev = prev.equals("") ? String.valueOf(Integer.parseInt(str1) + 1) : String.valueOf(Integer.parseInt(prev) + 1);
        String temp = str1 + prev;
        return checkConsective(temp, str, prev);
    }
    public static boolean checkIfStringConsective(String str) {
        String ch = "";
        for (int i = 0; i<str.length()/2; i++) {
             ch += str.charAt(i);
             boolean status = checkConsective(ch, str, "");
             if (status) {
                 return true;
             }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "11121314";
        if(checkIfStringConsective(str)) {
            System.out.println("Yes");
        } else  {
            System.out.println("No");
        }
    }
}
