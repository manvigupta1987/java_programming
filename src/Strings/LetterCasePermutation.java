package Strings;

//Print all permutations of a string keeping the sequence but changing cases.
//Input : ab
//Output : AB Ab ab aB


// T(n) = O(2n), n = length of the input string, we generate 2n combinations in the worst case when all the string characters are alphabets.
public class LetterCasePermutation {
    static void printPermutation(char[] str, int pos) {
        if (pos == str.length) {
            for (int i =0; i< pos; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }

        if (str[pos] >= '0' && str[pos] <= '9') {
            printPermutation(str, pos+1);
            return;
        }
        /* if string character is alphabet
        1. add the character in lowercase form
        2. add the character in uppercase form
        proceed to next character */

        str[pos] = Character.toLowerCase(str[pos]);
        printPermutation(str, pos+1);

        str[pos] = Character.toUpperCase(str[pos]);
        printPermutation(str, pos+1);

    }
    public static void main(String[] args) {
        String input = "ABC";
        /* convert input string to vector of characters for processing */
        char [] str = input.toCharArray();
        printPermutation(str,0);
    }
}
