package LinkedList;

import Sorting.MergeSort;

public class MergeSortLinkedList {
    Node head;
    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            this.data = d;
            this.next= null;
        }
    }

    void addNode(int data)
    {
        if(head == null)
        {
            head = new Node(data);
            return;
        }

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data);
        curr.next = newNode;
    }

    void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data);
            System.out.print(" ");
            temp = temp.next;
        }
    }

    public Node merge(Node left, Node right) {
        Node resultList = null;
        Node temp = null;
        //To keep track of last element, so that we don't need to iterate for adding the element at last of
        //list when either LeftStart or rightStart is NULL.
        Node lastAddedNode = null;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp = left;
                left = left.next;
            } else {
                temp = right;
                right = right.next;
            }
            if (resultList == null) {
                resultList = temp;
            } else {
                lastAddedNode.next = temp;
            }
            lastAddedNode = temp;
        }

        if (left != null) {
            lastAddedNode.next = left;
        }
        if (right != null) {
            lastAddedNode.next = right;
        }
        return resultList;
    }


    public Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head,slow = head, fast = head;
        // temp is the end node of left list.
        // slow is the head of the right list
        // fast is the end of the right list.
        while (fast != null && fast.next!= null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        Node left_side = sort(head); // divide the left side list by passing the head of it.
        Node right_side = sort(slow); // divide the right side list by passing the head of it.

        return merge(left_side, right_side);
    }


    public static void main(String[] args) {
        MergeSortLinkedList list = new MergeSortLinkedList();
        list.addNode(30);
        list.addNode(3);
        list.addNode(4);
        list.addNode(20);
        list.addNode(5);

        System.out.println("Linked List before sorting");
        list.printList(list.head);

        Node sortedList = list.sort(list.head);

        System.out.println("\nLinked List after sorting");
        list.printList(sortedList);
    }
}
