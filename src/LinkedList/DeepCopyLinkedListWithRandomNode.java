package LinkedList;

import java.util.HashMap;

// https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

public class DeepCopyLinkedListWithRandomNode {

    static class Node {
        int data;
        Node next;
        Node random;

        Node(int num) {
            this.data = num;
            this.next = null;
            this.random = null;
        }
    }

    static class LinkedList {
        public Node head;

        //Inserts the node at the end of the linked list.
        //Time complexity of append is O(n) where n is the number of nodes in linked list.
        public void append(Node new_node) {
            if (head == null) {
                head = new_node;
                return;
            }
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new_node;
        }

        public void display(Node head){
            Node current = head;
            while(current != null){
                System.out.print("["+current.data+"]-->[Random-"+current.random.data+",Next-->");
                current = current.next;
            }
            System.out.print("null");
        }
    }

    // Time Complexity is O(n) space : O(n)
    static Node deepCopyUsingHashMap(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        // create a list of node corresponding to the original list in hashmap.
        while (temp != null) {
            map.put(temp, new Node(temp.data));
            temp = temp.next;
        }

        // assign next and random pointers.
        Node current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    // Time Complexity is O(n) space : O(1)
    static Node deepCopyInPlace(Node root) {
        if(root == null) {
            return null;
        }

        Node temp = root;
        // Created copy of original nodes in the list
        while(temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        Node current = root;
        // copy the random pointers now
        while (current != null) {
            if (current.next != null) {
                current.next.random = current.random != null ? current.random.next : null;
            }
            current = current.next != null ? current.next.next : null;
        }

        // separate the original and cloned list
        Node original = root, copyHead = root.next, clonedHead = copyHead ;
        while (original != null && copyHead != null) {
            original.next = original.next != null ? original.next.next : null;
            copyHead.next = copyHead.next != null ? copyHead.next.next : null;

            original = original.next;
            copyHead = copyHead.next;
        }

        return clonedHead;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        list.append(n1);
        list.append(n2);
        list.append(n3);
        list.append(n4);
        list.append(n5);
        list.append(n6);
        list.append(n7);

        n1.random = n3;
        n2.random = n4;
        n3.random = n5;
        n4.random = n6;
        n5.random = n7;
        n6.random = n3;
        n7.random = n2;

        list.display(list.head);
        System.out.println("\n After Cloning");

        Node clonedNode = deepCopyUsingHashMap(list.head);
        list.display(clonedNode);

        System.out.println("\n In Place Cloning");
        Node clonedNodeInPlace = deepCopyInPlace(list.head);
        list.display(clonedNodeInPlace);


    }

}
