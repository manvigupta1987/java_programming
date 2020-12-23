package Strings;

public class CountCharsAtSamePosAsAlphabets {

    static int findChars(String str) {
        int count =0;
        for (int i=0; i< str.length(); i++) {
            if ((i== (str.charAt(i) - 'a')) || (i == str.charAt(i) - 'A'))  {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "AbgdeF";
        System.out.println("Number of chars with same position as alphabets are =" +
                findChars(str));
    }
}
