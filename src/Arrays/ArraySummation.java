package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ArraySummation {

    public static boolean checkIfSumPresentInTestArr(int[] arr, int[] test) {
        if (test.length == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (set.contains(test[i] - arr[j])) {
                    return true;
                } else {
                    set.add(arr[j]);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr1 = {-1, 2, 3, -2,4, 5, 6};
        int [] test = {3, 7, 2};

        System.out.println(checkIfSumPresentInTestArr(arr1, test));
    }
}
