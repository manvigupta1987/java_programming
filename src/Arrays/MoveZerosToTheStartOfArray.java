package Arrays;

import Utils.Utils;

// Move all the zeros to the start of the array.

public class MoveZerosToTheStartOfArray {
    public static void moveZerosToTheStart(int[] arr) {
        int current = arr.length - 1;
        int end = arr.length - 1;
        while (current >=0) {
            if (arr[current] != 0) {
                Utils.swap(arr, current, end);
                end--;
            }
            current--;
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 0, 4, 6, 0, 9, 0, 4, 0, 3, 0, 9, 0, 1, 0, 3, 0};
        moveZerosToTheStart(array);
        Utils.printArray(array, array.length);

    }
}
