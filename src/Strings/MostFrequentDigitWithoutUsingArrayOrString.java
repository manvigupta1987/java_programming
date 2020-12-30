package Strings;

public class MostFrequentDigitWithoutUsingArrayOrString {
    static int findOccurance(int num, int digit) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == digit) {
                count++;
            }
            num = num /10;
        }
        return count;
    }
    static int maxOccurring(int num) {
        int max_occ = Integer.MIN_VALUE;
        int max_digit = -1;
        for (int digit = 0; digit <= 9; digit++) {
            int occurrence = findOccurance(num, digit);
            if (occurrence > max_occ) {
                max_occ = occurrence;
                max_digit = digit;
            }
        }
        return max_digit;
    }
    public static void main(String[] args) {
        int x = 12233555;
        System.out.println("Max occurring digit is " +
                maxOccurring(x));
    }
}
