package LinkedList;

import java.util.List;

// Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

public class SegregateOddEvent {
    static void segregateEvenOddNodes(LinkedList llist) {
        LinkedList.Node head = llist.getHead();
        if (head == null ) {
            return;
        }

        LinkedList.Node odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next  = evenHead;
     }

     //The idea is to split the linked list into two: one containing all even nodes and other containing all odd nodes.
     // And finally attach the odd node linked list after the even node linked list.
    // Time Complexity : O(n)
     static void segregateEvenOddBasedOnValue(LinkedList linkedList) {
         LinkedList.Node head = linkedList.getHead();
         if (head == null ) {
             return;
         }
         LinkedList.Node oddEnd = null, evenEnd = null, evenHead = null, oddHead = null;
         LinkedList.Node temp = head;
         while (temp != null) {
            if (temp.data % 2 == 0 ) {
                if (evenEnd == null) {
                    evenHead = temp;
                    evenEnd = evenHead;
                } else {
                    evenEnd.next = temp;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddEnd == null) {
                    oddHead = temp;
                    oddEnd = oddHead;
                } else {
                    oddEnd.next = temp;
                    oddEnd = oddEnd.next;
                }
            }
            temp = temp.next;
         }
         if(oddHead == null || evenHead == null) {
             return;
         }
         evenEnd.next = oddHead;
         oddEnd.next = null;
         linkedList.setHead(evenHead);
     }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.append(17);
        llist.append(15);
        llist.append(8);
        llist.append(12);
        llist.append(10);
        llist.append(5);
        llist.append(4);
        llist.append(1);
        llist.append(7);
        llist.append(6);
        System.out.println("Original Linked List");
        llist.printList();

        segregateEvenOddNodes(llist);

        System.out.println("\nModified Linked List");
        llist.printList();

        segregateEvenOddBasedOnValue(llist);

        System.out.println("\nModified Linked List");
        llist.printList();
    }
}
