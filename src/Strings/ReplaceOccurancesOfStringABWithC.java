package Strings;

public class ReplaceOccurancesOfStringABWithC {
    static void translate(char [] str) {
        if (str.length < 2) {
            return;
        }
        int j = 0, i =0;
        for (; i< str.length; i++) {
            if ('A' == str[i] && 'B' == str[i+1]) {
                str[j++] = 'C';
                i = i +1;
                continue;
            }
            str[j] = str[i];
            j++;
        }
        while (j < str.length) {
            str[j] = ' ';
            j++;
        }
    }
    public static void main(String[] args) {
        String st="helloABworldABGfG";
        char str[] = st.toCharArray();
        translate(str);
        System.out.println("The modified string is :");
        System.out.println(str);
    }
}
