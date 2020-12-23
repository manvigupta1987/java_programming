package Strings;

import java.util.HashSet;

// Problem: Given an array of lower case strings, the task is to find the number of strings that are distinct. Two strings are distinct if
// on applying the following operations on one string the second string cannot be formed.
//
//A character on odd index can be swapped with another character at odd index only.
//A character on even index can be swapped with another character on even index only.


// Solution: An efficient solution generate an encoded string for every input string. The encoded has counts of even and odd positioned characters
// separated by a separator. Two strings are considered distinct if their encoded strings are same else not. Once we have a way to encode string, the problem reduces to counting distinct encoded strings. This is a typical problem of hashing. We create hash set and one by one store encodings of strings. If an encoding already exists, we ignore string. Else we store encoding in hash and increment count of distinct strings.

public class DistinctStringOddEvenChangesAllowed {
    static int MAX_CHAR = 26;

    static String encodedString(char[] str) {
        String encodedString = "";
        // // hashEven stores the count of even indexed character
        //    // for each string hashOdd stores the count of odd
        //    // indexed characters for each string
        char[] hashOdd = new char[MAX_CHAR];
        char[] hashEven = new char[MAX_CHAR];

        //
        for (int i =0; i<str.length; i++) {
            char ch = str[i];
            if (i % 2 == 0) {
                hashEven[ch-'a']++;
            } else {
                hashOdd[ch-'a']++;
            }
        }

        //// For every character from 'a' to 'z', we store its
        //    // count at even position followed by a separator,
        //    // followed by count at odd position.
        for (int i =0; i < MAX_CHAR; i++) {
            encodedString += hashEven[i];
            encodedString += '-';
            encodedString += hashOdd[i];
            encodedString += '-';
        }

        return encodedString;
    }


    // This function basically uses a hashing based set to
// store strings which are distinct according to according
// to criteria given in question.
    static int countDistinct(String input[], int n) {
        int countDist = 0;
        HashSet<String> set = new HashSet<>();

        for (int i =0; i< n; i++) {
            String encodedString = encodedString(input[i].toCharArray());
            if (!set.contains(encodedString)) {
                set.add(encodedString);
                countDist++;
            }
        }
        return countDist;
    }

    public static void main(String[] args) {
        String input[] = {"abc", "cba"};
        int n = input.length;
        System.out.println(countDistinct(input, n));
    }
}
