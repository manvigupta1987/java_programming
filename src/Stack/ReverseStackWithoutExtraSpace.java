package Stack;

public class ReverseStackWithoutExtraSpace {
    public static StackNode reverseStack(StackNode top) {
        StackNode current = top, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
