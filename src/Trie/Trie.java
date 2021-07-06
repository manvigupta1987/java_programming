// Applications where Trie data structure can be used:
    // 1. AutoComplete
    // 2. Spell Checker
    // 3. IP Routing
    // 4. T9 predictive text
    //

package Trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Trie {

    class TrieNode {
        String prefix;
        Map<Character,TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            prefix ="";
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    TrieNode root;
    public Trie () {
        root = new TrieNode();
    }

    // time complexity is O(ln) where l is the length of word and n is the number of words.
    public void insert(String word) {
        TrieNode current = root;
        if(current == null) {
            return;
        }
        for(int i=0; i< word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                TrieNode new_node = new TrieNode();
                new_node.prefix = word.substring(0, i+1);
                current.children.put(ch, new_node);
                current = new_node;
            } else {
                current = node;
            }
        }
        current.endOfWord = true;
    }

    // time complexity is O(l) where l is the length of the word.
    public boolean search(String word) {
        TrieNode current = root;
        for (int i =0; i< word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode node = current.children.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i< prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    /**
     * Delete node from Trie
     * @param word
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * returns true if parent should delete the mapping.
     * @param current
     * @param word
     * @param index
     * @return
     */
    // time complexity is O(ln) where l is the length of word and n is the number of words.
    public boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if(!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            // if current has no other nodes then return true.
            return (current.children.size() == 0);
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index+1);
        // if true returned then delete the mapping of the character and trienode from map;
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }

        return false;
    }


    public List<String> getWordsForPrefix(String prefix) {
        List<String> results = new LinkedList<>();

        TrieNode curr = root;
        for (char c: prefix.toCharArray()) {
            TrieNode node = curr.children.get(c);
            if (node == null) {
                return results;
            }
            curr = node;
        }
        findAllChildWords(curr, results);
        return results;
    }

    private void findAllChildWords(TrieNode curr, List<String> results) {
        if(curr.endOfWord) {
            results.add(curr.prefix);
        }
        for (Character c: curr.children.keySet()) {
            findAllChildWords(curr.children.get(c), results);
        }
    }
}

//public class Trie {

//    class TrieNode {
//        char data;
//        Map<Character,TrieNode> children;
//        boolean endOfWord;
//        public TrieNode() {
//            data ="";
//            children = new HashMap<>();
//            endOfWord = false;
//        }
//    }
//
//    TrieNode root;
//    public Trie () {
//        root = new TrieNode();
//    }
//
//    // time complexity is O(ln) where l is the length of word and n is the number of words.
//    public void insert(String word) {
//        TrieNode current = root;
//        if(current == null) {
//            return;
//        }
//        for(int i=0; i< word.length(); i++) {
//            char ch = word.charAt(i);
//            TrieNode node = current.children.get(ch);
//            if(node == null) {
//                TrieNode new_node = new TrieNode();
//                new_node.children.put(ch, null);
//                new_node.data = word.substring(0, i+1);
//                current.children.put(' ', new_node);
//                current = new_node;
//            } else {
//                current = node;
//            }
//        }
//        current.endOfWord = true;
//    }
//
//    // time complexity is O(l) where l is the length of the word.
//    public boolean search(String word) {
//        TrieNode current = root;
//        for (int i =0; i< word.length(); i++) {
//            char ch = word.charAt(i);
//
//            TrieNode node = current.children.get(ch);
//            if(node == null) {
//                return false;
//            }
//            current = node;
//        }
//        return current.endOfWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        TrieNode current = root;
//        for(int i=0; i< prefix.length(); i++) {
//            char ch = prefix.charAt(i);
//            TrieNode node = current.children.get(ch);
//            if(node == null) {
//                return false;
//            }
//            current = node;
//        }
//        return true;
//    }
//
//    /**
//     * Delete node from Trie
//     * @param word
//     */
//    public void delete(String word) {
//        delete(root, word, 0);
//    }
//
//    /**
//     * returns true if parent should delete the mapping.
//     * @param current
//     * @param word
//     * @param index
//     * @return
//     */
//    // time complexity is O(ln) where l is the length of word and n is the number of words.
//    public boolean delete(TrieNode current, String word, int index) {
//        if(index == word.length()) {
//            //when end of word is reached only delete if currrent.endOfWord is true.
//            if(!current.endOfWord) {
//                return false;
//            }
//            current.endOfWord = false;
//            // if current has no other nodes then return true.
//            return (current.children.size() == 0);
//        }
//        char ch = word.charAt(index);
//        TrieNode node = current.children.get(ch);
//        if(node == null) {
//            return false;
//        }
//        boolean shouldDeleteCurrentNode = delete(node, word, index+1);
//        // if true returned then delete the mapping of the character and trienode from map;
//        if (shouldDeleteCurrentNode) {
//            current.children.remove(ch);
//            return current.children.size() == 0;
//        }
//
//        return false;
//    }
//
//
//    public List<String> getWordsForPrefix(String prefix) {
//        List<String> results = new LinkedList<>();
//
//        TrieNode curr = root;
//        for (char c: prefix.toCharArray()) {
//            TrieNode node = curr.children.get(c);
//            if (node == null) {
//                return results;
//            }
//            curr = node;
//        }
//        findAllChildWords(curr, results);
//        return results;
//    }
//
//    private void findAllChildWords(TrieNode curr, List<String> results) {
//        if(curr.endOfWord) {
//            results.add(curr.prefix);
//        }
//        for (Character c: curr.children.keySet()) {
//            findAllChildWords(curr.children.get(c), results);
//        }
//    }
