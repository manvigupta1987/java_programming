package DoublyLinkedList;

public class DoubleLinkedList {
    Node head = null;

    class Node {
        int data;
        Node nextPtr;
        Node prevPtr;
    }
    // Insert at the beginning
    void push(int num) {
        Node newNode = new Node();
        newNode.data = num;
        newNode.nextPtr = head;
        newNode.prevPtr = null;
        if (head != null) {
            head.prevPtr = newNode;
        }
        head = newNode;
    }

    void append(int num) {
        Node newNode = new Node();
        Node temp = head;
        newNode.data = num;
        if (head == null) {
            newNode.prevPtr = null;
            newNode.nextPtr = null;
            head = newNode;
        } else {
            while (temp.nextPtr != null) {
                temp = temp.nextPtr;
            }
            temp.nextPtr = newNode;
            newNode.prevPtr = temp;
            newNode.nextPtr = null;
        }
    }

    void printList() {
        Node temp = head;
        System.out.println("\n");
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.nextPtr;
        }
    }

    void insertAfter(int num, int numAfter) {
        Node newNode = new Node();
        newNode.data = num;
        Node temp = head;
        if (head == null) {
            return;
        }
        while (temp != null && temp.data != numAfter) {
            temp = temp.nextPtr;
        }
        if (temp == null ) {
            return;
        }
        // if the temp is pointing to last node.
        if (temp.nextPtr == null) {
            newNode.nextPtr = temp.nextPtr;
            newNode.prevPtr = temp;
            temp.nextPtr = newNode;
        } else {
            // if the node to be inserted in between of two nodes.
            newNode.nextPtr = temp.nextPtr;
            temp.nextPtr.prevPtr = newNode;
            temp.nextPtr = newNode;
            newNode.prevPtr = temp;
        }
    }

    void deleteNode(int data) {
        Node temp = head;
        if(head == null) {
            return;
        }

        while (temp.data != data && temp!= null) {
            temp = temp.nextPtr;
        }

        if (temp == null) {
            System.out.println("\nNode is not found" );
            return;
        }
        // if the first node is to be deleted.
        if (temp.prevPtr == null) {
            head = temp.nextPtr;
            temp.nextPtr.prevPtr = null;
        } else {
            //if its not a last node.
            if (temp.nextPtr != null) {
                temp.nextPtr.prevPtr = temp.prevPtr;
                temp.prevPtr.nextPtr = temp.nextPtr;
            } else {
                temp.prevPtr.nextPtr = temp.nextPtr;
            }
        }
    }

    // Time Complexity: O(n)
    void reverseNode() {
        Node temp = head;
        Node current = null;

        while (temp != null) {
           current = temp.prevPtr;
           temp.prevPtr = temp.nextPtr;
           temp.nextPtr = current;
           temp = temp.prevPtr;
        }

        if (current != null) {
            head = current.prevPtr;
        }
    }

    void swapKthNodeWithKthNodeFromEnd(int num) {
        int numOfNodes = countNodes();

        if (numOfNodes < num) {
            return;
        }
        // If x (num th node from start) and  y(num th node from end) are same
        if (2 * num - 1 == numOfNodes) {
            return;
        }

        //Find the kth node from beginning of linked list.
        Node x = head, x_prev = null;
        for (int i = 1; i < num; i++) {
            x_prev = x;
            x = x.nextPtr;
        }

        //Find the kth node from end of linked list.
        Node y = head, y_prev = null;
        for (int i = 1; i < (numOfNodes - num +1) ; i++) {
            y_prev = y;
            y = y.nextPtr;
        }

        if (x_prev != null) {
            x_prev.nextPtr = y;
        }

        // when x and y are not next to each other.
        if (x.nextPtr != y) {
            if (y_prev != null) {
                y_prev.nextPtr = x;
            }
            if (x.nextPtr != null) {
                x.nextPtr.prevPtr = y;
            }
            if (y.nextPtr != null) {
                y.nextPtr.prevPtr = x;
            }
            Node temp = x.nextPtr;
            x.nextPtr = y.nextPtr;
            y.nextPtr = temp;

            temp = x.prevPtr;
            x.prevPtr = y.prevPtr;
            y.prevPtr = temp;
        } else {
            y.prevPtr = x.prevPtr;
            x.prevPtr = y;
            x.nextPtr = y.nextPtr;
            if (y.nextPtr != null) {
                y.nextPtr.prevPtr = x;
                y.nextPtr = x;
            }
        }

        if (num == 1) {
            head = y;
        }

        if (num == numOfNodes) {
            head = x;
        }
    }

    void deleteGivenNode(Node toBeDeletedNode) {
        if (toBeDeletedNode == null ) {
            return;
        }
        if (toBeDeletedNode == head) {
            head = head.nextPtr;
            return;
        }
        /* Change next only if node to be deleted is NOT the last node */
        if (toBeDeletedNode.prevPtr != null) {
            toBeDeletedNode.prevPtr.nextPtr = toBeDeletedNode.nextPtr;
        }
        /* Change prev only if node to be deleted is NOT the first node */
        if (toBeDeletedNode.nextPtr != null) {
            toBeDeletedNode.nextPtr.prevPtr = toBeDeletedNode.prevPtr;
        }
    }
    void deleteAllOccurances(int num) {
        Node current = head, next = null;
        if (head == null) {
            return;
        }
        while (current != null) {
            if (current.data == num) {
                next = current.nextPtr;
                deleteGivenNode(current);
                current = next;
            } else {
                current = current.nextPtr;
            }
        }
    }

    int countNodes() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.nextPtr;
        }
        return count;
    }

    void rotateByNNodes(int num) {
        if (num == 0) {
            return;
        }
        int i = 1;
        Node current = head;
        while ( i < num && current != null) {
            current = current.nextPtr;
            i++;
        }
        // if current is null, num is greater than the number of nodes.
        if (current == null) {
            return;
        }
        Node NthNode = current;
        // Now current will point to last node.
        while (current.nextPtr != null) {
            current = current.nextPtr;
        }

        // connect the last node to the first node.
        current.nextPtr = head;
        // connect the prev of head to the last element.
        head.prevPtr = current;
        // changed the head to the N+1 node.
        head = NthNode.nextPtr;
        //change the prev ptr of head to null;
        head.prevPtr = null;
        // Change the nextPtr of NthNode to null;
        NthNode.nextPtr = null;
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.push(6);
        doubleLinkedList.append(12);
        doubleLinkedList.append(18);
        doubleLinkedList.append(12);
        doubleLinkedList.append(28);
        doubleLinkedList.insertAfter(24, 12);
        doubleLinkedList.insertAfter(10 ,18);
        doubleLinkedList.insertAfter(5 ,6);
        doubleLinkedList.printList();

        // Double link list rotation by N nodes.
        int numOfNodes = 2;
        System.out.println("\nAfter rotating the list by Nodes :" + numOfNodes);
        doubleLinkedList.rotateByNNodes(numOfNodes);
        doubleLinkedList.printList();

        // Swapping the Nth Node from beginning to Nth node from end.
        System.out.println("\nAfter swapping :");
        doubleLinkedList.swapKthNodeWithKthNodeFromEnd(4);
        doubleLinkedList.printList();

        // reversing the link list
        System.out.println("\nAfter reversal :");
        doubleLinkedList.reverseNode();
        doubleLinkedList.printList();

        // Deleting all occrences of a given node.
        int num = 12;
        System.out.println("\nDeleting all occurances of :" + num);
        doubleLinkedList.deleteAllOccurances(num);
        doubleLinkedList.printList();

        // Deleting a particular node
        System.out.println("\nAfter deletion \n");
        doubleLinkedList.deleteNode(6);
        doubleLinkedList.deleteNode(18);
        doubleLinkedList.deleteNode(10);
        doubleLinkedList.printList();
    }
}
