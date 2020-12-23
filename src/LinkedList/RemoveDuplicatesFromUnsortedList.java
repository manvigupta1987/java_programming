package LinkedList;

import java.util.HashSet;

//We traverse the link list from head to end. For every newly encountered element, we check whether it is in the hash table:
// if yes, we remove it; otherwise we put it in the hash table.

//Time Complexity : O(n)

public class RemoveDuplicatesFromUnsortedList {
    static void removeDuplicates(LinkedList.Node head) {
        LinkedList.Node temp = head, prev = null;

        if (head == null) {
            return;
        }
        // Traverse list till the last node
        HashSet<Integer> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp.data)) {
                prev.next = temp.next;
            } else {
                set.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
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
        llist.append(10);
        llist.append(12);
        llist.append(11);
        llist.append(11);
        llist.append(11);
        llist.append(11);
        llist.append(12);
        llist.append(11);
        llist.append(10);
        llist.printList();

        removeDuplicates(llist.getHead());
        System.out.println("\nAfter removing duplicates ");
        llist.printList();
    }
}

