package Strings;

// Given a range of numbers, print all palindromes in the given range. For example if the given range is {10, 115}, then output should be
// {11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111}

public class PrintPalidromesWithInRange {
    static boolean isPalidrome(int num) {
        int rev = 0;
        int temp = num;
        while (temp > 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp/10;
        }
        return (rev == num);
    }

    static void countPalidrome(int min, int max) {
        for(int i = min; i<= max; i++) {
            if (isPalidrome(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        countPalidrome(100, 1000);
    }
}
