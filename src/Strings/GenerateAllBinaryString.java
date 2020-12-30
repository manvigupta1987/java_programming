package Strings;

//  https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/

public class GenerateAllBinaryString {
    static void print(char[] str, int index) {
        if (index == str.length) {
            System.out.println(str);
            return;
        }

        if (str[index] == '?') {
            str[index] = '0';
            print(str, index+1);

            str[index] = '1';
            print(str, index+1);
            // NOTE: Need to backtrack as string is passed by reference to the function
            str[index] = '?';
        } else {
            print(str,index+1);
        }
    }
    public static void main(String[] args) {
        String input = "1??0?101";
        char[] str = input.toCharArray();
        print(str, 0);
    }
}
