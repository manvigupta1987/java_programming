// LRU cache is used to store the most frequently used value at the front and
// least frequently used value at the end of the cache. Also, this cache is restricted to the
// capacity mentioned by the user. If more values need to be added in the cache, the Least
// frequently used values need to be removed.
// To achieve the fast lookups, we can use HashMap and for fast removals, we can use Doubly linked list.
// We can design the LRU using the Double linked list and Hashmap of node.
// HashMap is good as get and put method in hashMap can be done in constant time.
// When we access or add any node, its considered as the most frequently used node. Hence it
// has to be moved or add to the front of the cache. To acheive this functionality, we are using
// double linked list.
// DLL allows to add and remove the nodes in the constant time.

import java.util.HashMap;

public class LRUCache {
    Node head = new Node(); // head is just an dummy node and doesnt contain any value.
    Node tail = new Node(); // tail is just an dummy node and doesnt contain any value.

    HashMap<Integer, Node> hashMap;
    int cache_capacity;


    public LRUCache(int capacity) {
        hashMap = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result  = -1;
        Node node = hashMap.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.val;
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if(node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (hashMap.size() == this.cache_capacity) {
                hashMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            add(new_node);
            hashMap.put(key, new_node);
        }
    }

    /**
     * This method adds the node to the front of the linked list as it is considered as most
     * frequently used node.
     * @param node : to add the node in the linked list
     */
    private void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        head_next.prev = node;
        node.next = head_next;
    }

    private void remove(Node node) {
        Node prev_node = node.prev;
        Node next_node = node.next;
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    class Node {
        int val;
        int key;
        Node prev;
        Node next;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
