package Stack;
import java.util.PriorityQueue;

//How to Implement stack using a priority queue(using min heap)?.

// Solution: In priority queue, we assign priority to the elements that are being pushed. A stack requires elements to be processed in Last in First Out manner.
// The idea is to associate a count that determines when it was pushed. This count works as a key for the priority queue.

// Time Complexity O(log n) time for both push and pop
public class StackUsingPriorityQueue {

    class Pair implements Comparable<Pair> {
        int count;
        int num;

        Pair(int c, int n) {
            this.count = c;
            this.num = n;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.count, count);
        }
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int count =0;
    void push (int data) {
        count++;
        pq.add(new Pair(count, data));
    }

    void pop() {
        if (pq.isEmpty()) {
            System.out.println("Nothing to pop");
            return;
        }
        count--;
        pq.poll();
    }

    int top() {
        if (pq.isEmpty()) {
            System.out.println("Nothing to pop");
            return -1;
        }
        Pair pair = pq.peek();
        return pair.num;
    }

    Boolean isEmpty() {
        return pq.isEmpty();
    }


    public static void main(String[] args) {
        StackUsingPriorityQueue stack = new StackUsingPriorityQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.top());
            stack.pop();
        }
    }
}
