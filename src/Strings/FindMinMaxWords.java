package Strings;

public class FindMinMaxWords {
    static String  minWord = "", maxWord ="";

    static void minMaxLengthWords(String str) {
        int start = 0, end = 0;
        int min_len =str.length(), min_start_index = 0;
        int max_len = 0, max_start_index = 0;
        int i = 0;
        for ( ; i< str.length(); i++) {
            if (str.charAt(i) == ' ') {
                int word_len = i-start;
                if (word_len > max_len) {
                    max_len = word_len;
                    max_start_index = start;
                }
                if (word_len < min_len) {
                    min_len = word_len;
                    min_start_index = start;
                }
                start = i+1;
            }
        }
        if(i == str.length() && start < i) {
            int word_len = i -start;
            if (word_len > max_len) {
                max_len = word_len;
                max_start_index = start;
            }
            if (word_len < min_len) {
                min_len = word_len;
                min_start_index = start;
            }
        }

        minWord = str.substring(min_start_index, min_start_index+min_len);
        maxWord = str.substring(max_start_index, max_start_index+max_len);

    }
    public static void main(String[] args) {
        String a = "Geeks A Computer Science portal for GeeksforGeeks";

        minMaxLengthWords(a);

        // to take input in string use getline(cin, a);
        System.out.print("Minimum length word: "
                + minWord
                + "\nMaximum length word: "
                + maxWord);
    }
}
