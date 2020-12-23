package Strings;

//Write a Java Program to Swap first and last character of words in a Sentence as mentioned in the example?
//Input : geeks for geeks
//Output :seekg rof seekg

public class SwapFirstAndLastCharOfWord {
    static String swapChars(String str) {
        int i =0, j =0;
        char[] ch = str.toCharArray();
        while (j < ch.length) {
            if (ch[j] == ' ') {
                char temp = ch[i];
                ch[i] = ch[j-1];
                ch[j-1] = temp;
                i = j+1;
            }
            j++;
        }
        if ((j-1) == ch.length-1) {
            char temp = ch[i];
            ch[i] = ch[j-1];
            ch[j-1] = temp;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        String str = "geeks for geeks";
        System.out.println(swapChars(str));
    }
}
