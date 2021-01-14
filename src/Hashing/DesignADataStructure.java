package Hashing;

// Design a data structure that supports the following operations in Θ(1) time.
//
//insert(x): Inserts an item x to the data structure if not already present.
//
//remove(x): Removes an item x from the data structure if present.
//search(x): Searches an item x in the data structure.
//
//getRandom(): Returns a random element from current set of elements

import sun.security.krb5.internal.crypto.Des;

import java.util.*;

public class DesignADataStructure {
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> map;  // map will store the element and its frequency.

    public DesignADataStructure() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    void add(int item) {
        if (map.get(item) != null) {
            return;
        }

        int size = arr.size();
        arr.add(item);

        map.put(item, size);
    }

    void delete(int item) {
        Integer index = map.get(item);
        if (index == null) {
            return;
        }
        // Swap element with last element so that remove from arr[] can be done in O(1) time
        int size = arr.size() - 1;
        int last = arr.get(size);
        Collections.swap(arr, index, size);
        arr.remove(size);

        // Update hash table for new index of last element
        map.put(last, index);
    }

    int getRandom() {
        Random random = new Random();
        int index = random.nextInt(arr.size());

        return arr.get(index);
    }

    int search(int item) {
        return map.get(item);
    }

    public static void main(String[] args) {
        DesignADataStructure ds = new DesignADataStructure();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.delete(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}
