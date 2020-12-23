package Stack;

import java.util.ListIterator;
import java.util.Stack;

//Time Complexity: O(n2).
//In the worst case for every sortstack(), sortedinsert() is called for ‘N’ times recursively for putting element to the right place
public class SortStackUsingRecursion {

    static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

    static void InsertSorted(Stack<Integer> stack, int data) {
        if (stack.isEmpty() || data > stack.peek()) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        InsertSorted(stack, data);

        stack.push(temp);
    }

    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);

            InsertSorted(stack, x);
        }
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println("\nStack elements after sorting:");
        printStack(s);
    }
}
