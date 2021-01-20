package LinkedList;

// https://www.youtube.com/watch?v=tK4eez3syAQ
// Given two numbers represented by two linked lists, write a function that returns
// the sum list. The sum list is linked list representation of the addition of two
// input numbers. It is not allowed to modify the lists. Also, not allowed to use
// explicit extra space (Hint: Use Recursion).


// In recursion, we are calling the addLinkedListsUtil again n again with node1 of linked list, size of list 1, head of list 2 and size of list2.

public class AddTwoLinkedList {

    static int addLinkedListsUtil(LinkedList.Node node1, int pv1, LinkedList.Node node2, int pv2, LinkedList res) {
        if (node1 == null && node2 == null) {
            return 0; // returning 0 carry
        }
        int data = 0;
        // if position of linked list 1 is greater than pv2, then move linked list1
        if (pv1 > pv2) {
            int oc = addLinkedListsUtil(node1.next, pv1 -1, node2, pv2, res);
            data = node1.data + oc;
        } else if (pv2 > pv1) { // if position of linked list 2 is greater than pv1, then move linked list2
            int oc = addLinkedListsUtil(node1, pv1, node2.next, pv2-1, res);
            data = node2.data + oc;
        } else { // if position of linked list 1 is same as linked list 2, then move both the linked lists.
            int oc = addLinkedListsUtil(node1.next, pv1-1, node2.next, pv2-1, res);
            data = node1.data + node2.data + oc;
        }

        int sum = data % 10;
        int carry = data/10;

        res.pushAtFront(sum);
        return carry;
    }

    static LinkedList addLinkedLists(LinkedList list1, LinkedList list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        LinkedList result = new LinkedList();
        int oc = addLinkedListsUtil(list1.head, list1.count(), list2.head, list2.count(), result );
        if (oc > 0) {
            result.pushAtFront(oc);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList llist1 = new LinkedList();
        llist1.append(9);
        llist1.append(9);
        llist1.append(9);
        System.out.println("First Linked List");
        llist1.printList();

        LinkedList llist2 = new LinkedList();
        llist2.append(1);
        llist2.append(8);
        System.out.println("Second Linked List");
        llist2.printList();

        LinkedList result;
        System.out.println("New Linked List afer addition");
        result = addLinkedLists(llist1, llist2);
        result.printList();
    }
}
