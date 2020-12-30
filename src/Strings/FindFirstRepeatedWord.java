package Strings;

import java.util.HashSet;

public class FindFirstRepeatedWord {
    static String findWord(String str) {
        if (str.isEmpty()) {
            throw new RuntimeException();
        }
        HashSet<String> set = new HashSet<>();
        String word = "";
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (set.contains(word)) {
                    return word;
                } else {
                    set.add(word);
                    word = "";
                }
            } else {
                word += str.charAt(i);
            }
        }
        if (i == str.length() && set.contains(word)) {
                return word;
        }
        return word;
    }
    public static void main(String[] args) {
        String str = "Ravi had been saying that he there had";
        String repeatedWord = findWord(str);
        if (repeatedWord.isEmpty()) {
            System.out.print("No repeated word is found");
        } else {
            System.out.print("First repeated word is :" + repeatedWord);
        }

    }
}
