package LinkedList;

public class LinkedList {

    public Node head;

    class Node {
        int data;
        Node next;

        Node(int num) {
            this.data = num;
            this.next = null;
        }
    }
    // Inserts the node at the front of linked list.
    //Time complexity of push() is O(1) as it does constant amount of work.
    public void pushAtFront(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    //Inserts the node at the end of the linked list.
    //Time complexity of append is O(n) where n is the number of nodes in linked list.
    public void append(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            new_node.next = null;
            head = new_node;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new_node;
        new_node.next = null;
    }

    public void printList() {
        Node tnode = head;
        System.out.print("\n");
        while (tnode != null) {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //Time complexity of insertAfter() is O(n) as it does constant amount of work.
    public void insertAfter(int num, int data) {
        Node new_node = new Node(data);
        if (head == null) {
            new_node.next = null;
            head = new_node;
        }
        Node node = head;
        Node prev_Node = null;
        while (node.data != num) {
            node = node.next;
        }
        prev_Node = node.next;
        node.next = new_node;
        new_node.next = prev_Node;
    }

    public void delete_node(int num) {
        Node temp = head, prev = null;
        if (temp == null) {
            return;
        }
        // if the deleted node is the head itself.
        if (temp.data == num) {
            head = temp.next;
            return;
        }

        while (temp.data != num) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
    }

    public void delete_with_position(int pos) {
        Node temp = head, prev = null;
        if (temp == null) {
            return;
        }
        if (pos == 0) {
            head = temp.next;
            return;
        }
        int i = 0;
        // find previous node of to be deleted node.
        while (i < pos-1 && temp != null) {
            temp = temp.next;
            i++;
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    public int count() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node getHead() {
        return head;
    }

    public void reverseLinkedList() {
        Node prev = null, current  = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void reverseLastNNodes(int n) {
        Node slow_ptr = head, fast_ptr = head;
        for (int i =0; i < n; i++) {
            fast_ptr = fast_ptr.next;
        }
        while (fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }

        Node currentNode = slow_ptr.next, prevNode = null, nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        slow_ptr.next = prevNode;
     }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.pushAtFront(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.pushAtFront(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(7, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        System.out.println("\n Number of nodes = " + llist.count());

        if (llist.search(8)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println("\n Linked list after deletion is: ");
        llist.delete_node(7);
        llist.printList();

        System.out.println("\n Linked list after deletion with position is: ");
        llist.delete_with_position(1);
        llist.printList();

        llist.append(14);
        llist.append(24);
        llist.append(10);
        llist.append(20);
        llist.printList();

        System.out.println("\n Linked list after reversal");
        llist.reverseLinkedList();
        llist.printList();
        System.out.println("\n");
        NthNodeFromEndOfLinkedList.printNthFromLast(2, llist.getHead());

        MiddleOfLinkedList.middleLinkedList(llist.getHead());

        llist.printList();

        System.out.println("\n reverse the last N nodes of linked list\n ");
        llist.reverseLastNNodes(4);
        llist.printList();
    }
}