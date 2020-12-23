package Stack;

class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    StackNode top;

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (top == null) {
            top = newNode;
            return;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public StackNode pop() {
        if (top == null) {
            System.out.println("\n Stack is empty");
            return null;
        }
        StackNode node = top;
        top = top.next;
        return node;
    }

    public  void display() {
        StackNode temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Original Stack");
        s.display();

        s.top = ReverseStackWithoutExtraSpace.reverseStack(s.top);
        System.out.println("Reversed Stack");
        s.display();
    }
}
