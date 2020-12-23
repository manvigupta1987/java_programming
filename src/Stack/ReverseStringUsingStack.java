package Stack;

import java.util.Stack;

public class ReverseStringUsingStack {
    static void reverse(StringBuffer str) {
        int len = str.length();

        if (len == 1) {
            return;
        }

        Stack<Character> stack = new Stack<>();
        int i =0;
        while (i < len) {
            stack.push(str.charAt(i));
            i++;
        }
        i = 0;
        while (i < len) {
            str.setCharAt(i, stack.pop());
            i++;
        }
    }
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("GeeksQuiz");
        System.out.println("Original string is " + s);
        reverse(s);
        System.out.println("Reversed string is " + s);

    }
}
