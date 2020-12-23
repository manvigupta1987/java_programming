package LinkedList;

// Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers
// to head. First, move the reference pointer to n nodes from head. Now move both pointers one by one until
// the reference pointer reaches the end. Now the main pointer will point to nth node from the end. Return
// the main pointer.

public class NthNodeFromEndOfLinkedList {
    public static void printNthFromLast(int n, LinkedList.Node head) {
        if (head == null) {
            return;
        }
        LinkedList.Node mainNode = head;
        LinkedList.Node refNode = head;

        int count =0;
        while (count < n) {
            if (refNode == null)
            {
                System.out.println(n  + " is greater than the no " + " of nodes in the list");
                return;
            }
            refNode = refNode.next;
            count++;
        }
        if (refNode == null) {
            System.out.println("Node no. " + n +  " from last is " + head.data);
        } else {
            while (refNode.next != null) {
                refNode = refNode.next;
                mainNode = mainNode.next;
            }
            System.out.println("Node no. " + n +  " from last is " + mainNode.data);
        }



    }

}
