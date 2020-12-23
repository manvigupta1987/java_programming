package Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given a list of words with lower cases. Implement a function to find all Words that have the same unique character set .

//The idea is to use hashing. We generate a key for all words. The key contains all unique character (Size of key is at most 26 for
// lower case alphabets). We store indexes of words as values for a key. Once we have filled all keys and values in hash table, we can
// print the result by traversing the table.

public class GroupWordsWithSameSetOfCharacters {
    static int EncodeString(String str) {
        int resKey = 0;
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        for (int i =0; i< str.length(); i++) {
            if (!visited[str.charAt(i) -'a']) {
                resKey += str.charAt(i) - 'a';
                visited[str.charAt(i)-'a'] = true;
            }
        }
        return resKey;
    }
    static void findWords(String[] str) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i=0; i < str.length; i++) {
            int key = EncodeString(str[i]);

            ArrayList<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(str[i]);
                map.put(key, list);
            } else {
                list.add(str[i]);
            }
        }

        for (Map.Entry<Integer, ArrayList<String>> it : map.entrySet()) {
            ArrayList<String> words = it.getValue();
            for (String word: words) {
                System.out.print( word + ", ");
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
