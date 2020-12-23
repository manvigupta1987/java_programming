package Stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Method 1 (By making push operation costly): This method makes sure that newly entered element is always at the front of ‘q1’, so that pop operation just dequeues from ‘q1’.
    // ‘q2’ is used to put every new element at front of ‘q1’.
// Method 2 (By making pop operation costly): In push operation, the new element is always enqueued to q1. In pop() operation, if q2 is empty then all the elements except the
    // last, are moved to q2. Finally the last element is dequeued from q1 and returned.
public class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void pushUsingMethod1(int data) {
        queue2.add(data);
        // push all the elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.remove();
        }

        // interchange the names of two queue. Now queue1 has the all elements
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    int popUsingMethod1() {
        if (queue1.isEmpty()) {
            return -1;
        }
        int x = queue1.peek();
        queue1.remove();
        return x;
    }

    void pushUsingMethod2(int data) {
        q1.add(data);
    }

    int popUsingMethod2() {
        if (q1.isEmpty()) {
            return -1;
        }

        while (q1.size() > 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        int x = q1.peek();
        q1.remove();

        // interchange the names of two queue. Now queue1 has the all elements
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
        return x;
    }
    public static void main(String[] args) {
        StackUsingQueues stack1 = new StackUsingQueues();
        stack1.pushUsingMethod1(1);
        stack1.pushUsingMethod1(2);
        stack1.pushUsingMethod1(3);

        System.out.println(stack1.popUsingMethod1());
        System.out.println(stack1.popUsingMethod1());
        System.out.println(stack1.popUsingMethod1());


        System.out.println("Method 2: By making the pop costly");
        StackUsingQueues stack2 = new StackUsingQueues();
        stack2.pushUsingMethod2(1);
        stack2.pushUsingMethod2(2);
        stack2.pushUsingMethod2(3);

        System.out.println(stack2.popUsingMethod2());
        System.out.println(stack2.popUsingMethod2());
        System.out.println(stack2.popUsingMethod2());

    }
}
