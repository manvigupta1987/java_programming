package Strings;

// 1’s complement of a binary number is another binary number obtained by toggling all bits in it, i.e., transforming the 0 bit to 1 and the 1 bit to 0.
// 2’s complement of a binary number is 1 added to the 1’s complement of the binary number.
public class FindOnesTwosCompliment {
    static String flip(StringBuffer str, int n) {
        for (int i = n-1; i>=0; i-- ) {
            if (str.charAt(i) == '1') {
                str.replace(i, i+1, "0");
            } else {
                str.replace(i, i+1, "1");
            }
        }
        return str.toString();
    }
    static String findOnesCompliment(StringBuffer str) {
        return flip(str, str.length());
    }

    static String findTwoscomplement(StringBuffer str) {
        int i = str.length() -1;
        for (; i >=0 ; i--) {
            if (str.charAt(i) == '1'){
                break;
            }
        }
        if (i == -1) {
            return "1" + str;
        }

        return flip(str, i);
    }
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("00000101");
        System.out.println(findOnesCompliment(str));
        StringBuffer str1 = new StringBuffer("00000101");
        System.out.println(findTwoscomplement(str1));
    }
}
