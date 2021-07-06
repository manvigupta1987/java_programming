package Strings;

//Given a string s and a character c, find if all occurrences of c appear together in s or not.
// If the character c does not appear in the string at all,
// the answer is true.
public class CheckIfAllOccurancesOfACharAppearTogether {
    static boolean findOccurances(String str, char ch) {
        boolean isOccurSingleTime = false;
        for (int i = 0; i< str.length(); i++) {
            if (str.charAt(i) == ch) {
                if (isOccurSingleTime == true) {
                    return false;
                }
                while (i < str.length() && str.charAt(i) == ch) {
                    i++;
                }
                isOccurSingleTime = true;
            }
        }
        return isOccurSingleTime;
    }

    public static void main(String[] args) {
        String str = "11111";
        char c = '1';
        if(findOccurances(str, c)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
