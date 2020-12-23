package Stack;

import java.util.Stack;

//Given a string str, we need to print reverse of individual words.

//We use a stack to push all words before space. As soon as we encounter a space, we empty the stack.
public class ReverseIndividualWords {
    static void reverseWords(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i< str.length(); i++) {
            if (str.charAt(i) != ' ') {
                stack.push(str.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
        }
        // As there is no space after last word.
        while (stack.empty() == false) {
            System.out.print(stack.pop());
        }
    }
    public static void main(String[] args) {
        String str = "Geeks for Geeks";
        reverseWords(str);
    }

}
