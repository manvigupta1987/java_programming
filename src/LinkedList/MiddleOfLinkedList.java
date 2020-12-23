package LinkedList;

//Traverse linked list using two pointers. Move one pointer by one and the other pointers by two.
// When the fast pointer reaches the end slow pointer will reach the middle of the linked list.
public class MiddleOfLinkedList {
    public static void middleLinkedList(LinkedList.Node head) {
        LinkedList.Node fast_ptr = head;
        LinkedList.Node slow_ptr = head;

        if (head == null) {
            return;
        }

        while (fast_ptr != null && fast_ptr.next !=null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        System.out.println("Middle Node is =" + slow_ptr.data);
    }
}
