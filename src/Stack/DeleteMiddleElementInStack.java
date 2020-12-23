package Stack;

import java.util.Stack;

// idea is to use recursive calls. We first remove all items one by one, then we recur.
// After recursive calls, we push all items back except the middle item.

public class DeleteMiddleElementInStack {
    static void deleteMiddleElement(Stack<Character> st, int size, int curr) {
        if (st.empty() || curr == size) {
            return;
        }

        char x = st.pop();
        deleteMiddleElement(st, size, curr+1);

        if (curr != size/2) {
            st.push(x);
        }
    }
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();

        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        st.push('7');

        deleteMiddleElement(st, st.size(), 0);

        // Printing stack after deletion
        // of middle.
        while (!st.empty())
        {
            char p=st.pop();
            System.out.print(p + " ");
        }
    }
}
