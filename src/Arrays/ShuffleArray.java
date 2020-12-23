package Arrays;

import Utils.Utils;

import java.util.Random;

//write a program to generate a random permutation of array elements. This question is also asked
// as “shuffle a deck of cards” or “randomize a given array”. Here shuffle means that every
// permutation of array element should equally likely.

public class ShuffleArray {
    static void randomize(int[] arr, int n) {
        Random r = new Random();
        for (int i = n-1; i>0 ; i--) {
            int j = r.nextInt(i);
            Utils.swap(arr, i, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        randomize (arr, n);
        Utils.printArray(arr, n);
    }
}
