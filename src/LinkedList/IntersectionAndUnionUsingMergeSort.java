package LinkedList;

import sun.awt.image.ImageWatched;

public class IntersectionAndUnionUsingMergeSort {
    static LinkedList intersectionList = null;
    static LinkedList unionList = null;

    static LinkedList.Node merge(LinkedList.Node left, LinkedList.Node right) {
        LinkedList.Node resultList = null;
        LinkedList.Node LastAddedNode = null;
        LinkedList.Node temp = null;
        while (left != null && right!=null) {
            if (left.data <= right.data) {
                temp = left;
                left = left.next;
            } else {
                temp = right;
                right = right.next;
            }

            if (resultList == null) {
                resultList = temp;
            } else {
                LastAddedNode.next = temp;
            }
            LastAddedNode = temp;
        }
        if (left != null) {
            LastAddedNode.next = left;
        }
        if (right != null) {
            LastAddedNode.next = right;
        }

        return resultList;
    }
    static LinkedList.Node mergeSort(LinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList.Node temp = null; // temp should point to the end of the left list.
        LinkedList.Node slow = head, fast = head;  // Slow is the head of the right list and fast is the end of the right list.

        while (fast != null && fast.next!= null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        LinkedList.Node left_side = mergeSort(head);
        LinkedList.Node right_side = mergeSort(slow);

        return merge(left_side, right_side);
    }

    static void findIntersectionAndUnion(LinkedList.Node head1, LinkedList.Node head2) {
        LinkedList.Node temp1= head1, temp2 = head2;
        intersectionList = new LinkedList();
        unionList = new LinkedList();

        while (temp1 != null && temp2!=null) {
            if (temp1.data == temp2.data) {
                intersectionList.append(temp1.data);
                unionList.append(temp1.data);
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.data < temp2.data) {
                unionList.append(temp1.data);
                temp1 = temp1.next;
            } else {
                unionList.append(temp2.data);
                temp2 = temp2.next;
            }
        }

        while (temp1!= null) {
            unionList.append(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2!= null) {
            unionList.append(temp2.data);
            temp2 = temp2.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.pushAtFront(20);
        list1.pushAtFront(4);
        list1.pushAtFront(15);
        list1.pushAtFront(10);
        list1.pushAtFront(11);

        LinkedList list2 = new LinkedList();
        list2.pushAtFront(10);
        list2.pushAtFront(2);
        list2.pushAtFront(4);
        list2.pushAtFront(8);

        list1.setHead(mergeSort(list1.getHead()));
        list2.setHead(mergeSort(list2.getHead()));

        System.out.println("Lists after Sorting");
        list1.printList();
        list2.printList();

        findIntersectionAndUnion(list1.getHead(), list2.getHead());
        intersectionList.printList();
        unionList.printList();
    }
}
