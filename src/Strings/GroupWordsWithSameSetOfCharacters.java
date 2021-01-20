package Strings;
import java.util.*;

//Given a list of words with lower cases. Implement a function to find all Words that have the same unique character set .

//The idea is to use hashing. We generate a key for all words. The key contains all unique character (Size of key is at most 26 for
// lower case alphabets). We store indexes of words as values for a key. Once we have filled all keys and values in hash table, we can
// print the result by traversing the table.

public class GroupWordsWithSameSetOfCharacters {
    static String EncodeString(String str) {
        char[] freqChar = new char[26];
        for (int i =0; i< str.length(); i++) {
            freqChar[str.charAt(i)-'a']++;
        }
        return new String(freqChar);
    }
    static void findWords(String[] str) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String key = EncodeString(str[i]);

            ArrayList<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(str[i]);
                map.put(key, list);
            } else {
                list.add(str[i]);
            }
        }

        for (Map.Entry<String, ArrayList<String>> it : map.entrySet()) {
            ArrayList<String> words = it.getValue();
            for (String word : words) {
                System.out.print(word + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] words = { "may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat",
                "flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle"};

        findWords(words);
    }
}
