package Strings;


import java.util.Stack;

public class ReverseWordsInString {

    static String reverseWords(String s1, int index) {
        Stack<String> stack = new Stack<>();
        if (s1.length() == 1) {
            return s1;
        }
        String word = "";
        for (int i =0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') {
                word += s1.charAt(i);
            } else {
                stack.push(word);
                word = "";
            }
        }
        stack.push(word);
        word = "";
        while (!stack.isEmpty()) {
            word += stack.pop();
            word += ' ';
        }
        return word;
    }
    public static void main(String[] args) {
        String s1 = "Welcome to geeksforgeeks";
        System.out.println(reverseWords(s1, 0));
    }
}
