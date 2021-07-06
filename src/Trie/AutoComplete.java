package Trie;

import java.util.List;

public class AutoComplete {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("aplm");
        trie.insert("application");
        trie.delete("aplm");

        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("abb"));

        List<String> words = trie.getWordsForPrefix("ap");
        for (String word: words) {
            System.out.println(word + " ");
        }
    }
}
