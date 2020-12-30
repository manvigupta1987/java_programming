package Strings;

// Given a string, the task is to find maximum consecutive repeating character in string.
//
//Note : We do not need to consider overall count, but the count of repeating that appear at one place.

public class MaximumConsecutiveRepeatingChar {
    static Character maxRepeating(String str ) {
        if (str.isEmpty()) {
            throw new RuntimeException();
        }
        if (str.length() == 1) {
            return str.charAt(0);
        }

        int start = 0, result = Integer.MIN_VALUE, count = 0;
        Character max_char = null;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == str.charAt(start)) {
                count++;
            } else {
                if ((count - start) > result) {
                    result = count - start;
                    max_char = str.charAt(start);
                }
                start = i;
                count = 0;
            }
        }
        return max_char;
    }
    public static void main(String[] args) {
        String str = "aaaabbaaccde";
        System.out.println(maxRepeating(str));
    }
}
