package Strings;

// You are given an array of characters which is basically a sentence. However there is no space between different words and the first letter of
// every word is in uppercase. You need to print this sentence after following amendments:

//(i) Put a single space between these words.
//(ii) Convert the uppercase letters to lowercase.
public class PutSpacesBetweenWords {
    static void amendSentence(String str) {
        for (int i =0; i< str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                System.out.print(" " + (char)(str.charAt(i) + 32));
            } else {
                System.out.print((str.charAt(i)));
            }
        }
    }
    public static void main(String[] args) {
        String str ="BruceWayneIsBatman";
        amendSentence(str);
    }
}
