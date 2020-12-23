package LinkedList;

public class RemoveDuplicatesFromSortedList {
    static void removeDuplicates(LinkedList.Node head) {
        LinkedList.Node temp = head, temp2 = head;

        if (head == null) {
            return;
        }
        // Traverse list till the last node
        while (temp2.next != null ) {
            if (temp2.data == temp2.next.data) {
                temp2 = temp2.next;
            } else {
                temp.next = temp2.next;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        /*This is the edge case if there are more than one occurrences of the last element*/
        if (temp != temp2) {
            temp.next = null;
        }
    }
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
//        llist.pushAtFront(20);
//        llist.pushAtFront(13);
//        llist.pushAtFront(13);
//        llist.pushAtFront(11);
//        llist.pushAtFront(11);
//        llist.pushAtFront(11);
        llist.append(20);
        llist.append(13);
        llist.append(13);
        llist.append(11);
        llist.append(11);
        llist.append(11);
        llist.printList();

        removeDuplicates(llist.getHead());
        System.out.println("\nAfter removing duplicates ");
        llist.printList();
    }
}
