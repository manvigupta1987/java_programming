package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Problem : Given an array of words, print all anagrams together. For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.

//  create a Hash Table. Calculate the hash value of each word in such a way that all anagrams have the same hash value.
//  Populate the Hash Table with these hash values. Finally, print those words together with same hash values.

// ANother solution is :
// we first sort each word, use sorted word as key and then put original word in a map. The value of the map will be a list containing all the words which have same word after sorting.
//Lastly, we will print all values from the hashmap where size of values will be greater than 1.

public class PrintAllAnagramsTogether {
    static int findHashCode(String str) {
        int count = 0;
        for (int i = 0; i< str.length(); i++) {
            count += str.charAt(i);
        }
        return count;
    }
    static void printAnagramsTogether(String[] strings) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i =0; i< strings.length; i++) {
            int hashcode = findHashCode(strings[i]);
            if (map.containsKey(hashcode)) {
                map.get(hashcode).add(strings[i]);
            } else {
                List<String> words = new ArrayList<>();
                words.add(strings[i]);
                map.put(hashcode, words);
            }
        }

        for (Integer key : map.keySet()) {
            List<String> values = map.get(key);
            if (values.size() > 1) {
                System.out.print(values);
            }
        }
    }
    public static void main(String[] args) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act", "gdo"};
        printAnagramsTogether(wordArr);
    }
}
