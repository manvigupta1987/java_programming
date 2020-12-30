package Strings;

// An anagram of a string is another string that contains the same characters, only the order of characters can be different.
// For example, “abcd” and “dabc” are an anagram of each other.

//The problem can be Done in Linear time and constant space.
//
//We initialize a variable say count to 0.
//Then we take the sum of all the characters of the first String and then decreasing the value of all the characters from the second String.
//If the Count value finally is 0, i.e. before performing any operation then its an anagram, else it is not.

public class CheckIfTwoStringsAreAnagram {
    static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        for (int i =0; i< str1.length(); i++) {
            count += str1.charAt(i);
        }
        for (int i =0; i<str2.length(); i++) {
            count -= str2.charAt(i);
        }
        return (count == 0);
    }

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";

        if (isAnagram(str1, str2))
            System.out.print("The two strings are " +
                    "anagram of each other");
        else
            System.out.print("The two strings are not " +
                    "anagram of each other");
    }
}
