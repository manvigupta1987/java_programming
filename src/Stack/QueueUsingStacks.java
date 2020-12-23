package Stack;

// There are two ways to achieve this:
// 1. (By making enqueue operation costly): Oldest entered element is always at the top of stack 1, so that deQueue operation just pops from stack1.
        //To put the element at top of stack1, stack2 is used.
// 2. (By making dequeue operation costly): in en-queue operation, the new element is entered at the top of stack1. In de-queue operation, if stack2 is
        // empty then all the elements are moved to stack2 and finally top of stack2 is returned.

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueueWithMethod1(int data) {
        // Move all elements from stack 1 to stack 2.
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        // Push the new element in the stack 1.
        stack1.push(data);

        // Push all the elements of stack2 to stack1.
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    int dequeueWithMethod1() {
        if (stack1.empty()) {
            System.exit(0);
        }
        // return top of S1.
        int x = stack1.peek();
        stack1.pop();
        return x;
    }

    void enqueueWithMethod2(int data) {
        s1.push(data);
    }

    int dequeueWithMethod2() {
        if (s1.empty() && s2.empty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }

        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        int x = s2.pop();
        return x;
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueueWithMethod1(1);
        queue.enqueueWithMethod1(2);
        queue.enqueueWithMethod1(3);

        System.out.println(queue.dequeueWithMethod1());
        System.out.println(queue.dequeueWithMethod1());
        System.out.println(queue.dequeueWithMethod1());


        QueueUsingStacks queue1 = new QueueUsingStacks();
        queue1.enqueueWithMethod2(1);
        queue1.enqueueWithMethod2(2);
        queue1.enqueueWithMethod2(3);

        System.out.println(queue1.dequeueWithMethod2());
        System.out.println(queue1.dequeueWithMethod2());
        System.out.println(queue1.dequeueWithMethod2());

    }
}
