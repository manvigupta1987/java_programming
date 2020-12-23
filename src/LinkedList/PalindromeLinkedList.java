package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    static void isPalindrome(LinkedList.Node head) {
        LinkedList.Node temp = head;
        if (head == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        Boolean isPalindrome = false;
        while (temp != null) {
            int data = stack.pop();
            if (temp.data == data) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
            temp = temp.next;
        }
        System.out.println("\n");
        if (isPalindrome) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.pushAtFront(1);
        llist.pushAtFront(2);
        llist.pushAtFront(3);
        llist.pushAtFront(4);
        llist.pushAtFront(3);
        llist.pushAtFront(2);
        llist.pushAtFront(1);

        llist.printList();


        isPalindrome(llist.getHead());
    }
}
