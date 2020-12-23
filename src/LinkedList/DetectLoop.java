package LinkedList;

// Traverse linked list using two pointers.
//Move one pointer(slow_p) by one and another pointer(fast_p) by two.
//If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.

//Time complexity: O(n).
public class DetectLoop {

    static void countNumberOfNodesInloop(LinkedList.Node ptr) {
        LinkedList.Node temp = ptr;
        int count = 1;
        while (temp.next != ptr) {
            temp = temp.next;
            count += 1;
        }
        System.out.println("\nNumber of Nodes in loop are: "+ count);
    }
    private static void detectLoop(LinkedList.Node head) {
        if (head == null) {
            return;
        }

        LinkedList.Node fast_ptr = head;
        LinkedList.Node slow_ptr = head;

        while (fast_ptr!= null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if (fast_ptr == slow_ptr) {
                System.out.println("\n Loop Found");
                countNumberOfNodesInloop(slow_ptr);
                return;
            }
        }
        System.out.println("\n Loop Not Found");

    }
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.pushAtFront(20);
        llist.pushAtFront(4);
        llist.pushAtFront(15);
        llist.pushAtFront(10);
        llist.printList();

        llist.head.next.next.next = llist.head;

        detectLoop(llist.getHead());
    }
}


