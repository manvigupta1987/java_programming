package LinkedList;

public class SwapNodesWithoutSwappingData {
    static void swapNodes(int num1, int num2, LinkedList.Node head) {
        if (head == null) {
            return;
        }
        if (num1 == num2) {
            return;
        }
        LinkedList.Node prevNum1 = null, currNum1 = head;
        while (currNum1 != null && currNum1.data != num1) {
            prevNum1 = currNum1;
            currNum1 = currNum1.next;
        }

        LinkedList.Node prevNum2 = null, currNum2 = head;
        while (currNum2 != null && currNum2.data != num2) {
            prevNum2 = currNum2;
            currNum2 = currNum2.next;
        }

        // If either x or y is not present, nothing to do
        if (currNum1 == null || currNum2 == null) {
            return;
        }

        // check if prevNum1 is head node.
        if (prevNum1 == null) {
            head = currNum2;
        } else {
            prevNum1.next = currNum2;
        }

        // check if prevNum2 is head node
        if (prevNum2 == null) {
            head = currNum1;
        } else {
            prevNum2.next = currNum1;
        }

        // Swap next pointers
        LinkedList.Node temp = currNum1.next;
        currNum1.next = currNum2.next;
        currNum2.next = temp;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.pushAtFront(7);
        llist.pushAtFront(6);
        llist.pushAtFront(5);
        llist.pushAtFront(4);
        llist.pushAtFront(3);
        llist.pushAtFront(2);
        llist.pushAtFront(1);
        System.out.print("\n Linked list before calling swapNodes() ");
        llist.printList();

        swapNodes(4, 7, llist.getHead());
        System.out.print("\n Linked list after calling swapNodes() ");
        llist.printList();

    }
}
