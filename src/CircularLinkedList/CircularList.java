package CircularLinkedList;

public class CircularList {
    Node head = null;
    Node head1 = null;
    Node head2 = null;
    static class Node
    {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    };

    public void push(int data) {
        Node ptr = new Node(data);
        ptr.next = head;
        Node temp = head;
        if (head != null) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = ptr;
        } else {
            ptr.next = ptr;
        }
        head = ptr;
    }

    public void printList(Node head) {
        Node temp = head;
        if (head == null) {
            return;
        }
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }
    public  void splitTheList() {
        if (head == null ){
            return;
        }
        Node slow_ptr = head, fast_ptr = head;
        while (fast_ptr.next != head && fast_ptr.next.next != head) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        // if there are even number of nodes, move the fast_ptr to the end of the list.
        if (fast_ptr.next.next == head) {
            fast_ptr = fast_ptr.next;
        }

        head1 = head;
        head2 = slow_ptr.next;

        fast_ptr.next = slow_ptr.next;
        slow_ptr.next = head;
    }

    void deleteNode(int data) {
        if (head == null) {
            return;
        }
        Node current = head, prev = null;
        while (current.data != data) {
            if (current.next == head) {
                System.out.println("Given node is not found");
                return;
            }
            prev = current;
            current = current.next;

        }
        // if there is only one node.
        if (current == head && current.next == head) {
            head = null;
            return;
        }

        // If more than one node, check if it is first node
        if (current == head) {
            prev = head;
            while (prev.next!= head) {
                prev = prev.next;
            }
            head = current.next;
            prev.next = head;
        } else if (current.next == head){
            prev.next = head;
        } else {
            prev.next = current.next;
        }
    }

    void count() {
        Node temp = head;
        int count = 1;
        while (temp.next != head) {
            count++;
            temp = temp.next;
        }
        System.out.println("\nNumber of nodes are " + count );
    }

    void exchangeFirstAndLastNode() {
        Node temp = head;
        Node prev_ptr = null;
        Node lastNode = head;

        // if there are two nodes
        if (head.next.next == head) {
            head = head.next;
        }

        while (lastNode.next != head) {
            prev_ptr = lastNode;
            lastNode = lastNode.next;
        }
        prev_ptr.next = head;
        lastNode.next = head.next;
        head.next = lastNode;
        head = lastNode;
    }



    public static void main(String[] args) {
        CircularList circularList = new CircularList();
        circularList.push(12);
        circularList.push(56);
        circularList.push(2);
        circularList.push(11);
        circularList.push(10);
        circularList.push(8);

        System.out.println("Contents of Circular " + "Linked List:");
        circularList.printList(circularList.head);

        circularList.count();

        System.out.println("Exchange Contents of Circular " + "Linked List: =========");
        circularList.exchangeFirstAndLastNode();
        circularList.printList(circularList.head);

        //Delete the item from list
        circularList.deleteNode(2);
        circularList.deleteNode(8);
        circularList.deleteNode(12);



        System.out.println("\nContents of Circular " + "Linked List:");
        circularList.printList(circularList.head);

        // Split the list
        circularList.splitTheList();
        System.out.println("List after spliting");
        circularList.printList(circularList.head1);
        System.out.println("\n");
        circularList.printList(circularList.head2);
    }
}
