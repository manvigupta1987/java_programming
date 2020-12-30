package Strings;


// Solution: Just measure the number of 1’s present in the bit representation of both the numbers, if number of 1’s present in their bit
// representation are same then they are anagrams in their bit representation else they are not.
public class CheckIfBinaryStringsAreAnagram {

    static boolean bit_anagram_check(long a, long b) {
        return Long.bitCount(a) == Long.bitCount(b);
    }
    public static void main(String[] args) {
        long a = 8, b = 4;
        System.out.println(bit_anagram_check(a, b));
    }
}
