package LinkedList;

public class MoveLastElementToFront {
    static void moveNodes(LinkedList list) {
        LinkedList.Node head = list.getHead();
        if (head == null) {
            return;
        }
        LinkedList.Node temp = head, temp_head = null;

        while (temp.next.next!=null) {
            temp = temp.next;
        }

        temp.next.next = head;
        temp_head = temp.next;
        temp.next = null;

        list.setHead(temp_head);
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
        System.out.print("\n Linked list before calling moveNodes() ");
        llist.printList();

        moveNodes(llist);
        llist.printList();

    }
}
