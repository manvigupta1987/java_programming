package Stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> revStack = new Stack<>();

    void push(int data) {
        stack.push(data);
    }

    void reverse() {
        if (!stack.empty()) {
            revStack.push(stack.pop());
            reverse();
        }
        return;
    }
    public static void main(String[] args) {
        ReverseStackUsingRecursion stack =  new ReverseStackUsingRecursion();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("reverse Stack");
        stack.reverse();
        while(!stack.revStack.empty()) {
            System.out.println(stack.revStack.pop());
        }
    }
}
