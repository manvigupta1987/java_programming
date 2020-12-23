package Searching;

import java.util.HashSet;

//We have an array of integers and we have to find two such elements in the array such that
// sum of these two elements is equal to the sum of rest of elements in array.

public class FindTwoElementWhoseSumEqualToRemainingElem {
    private static boolean checkPair(int[] arr, int len) {
        int sum =0;
        HashSet set = new HashSet();
        for (int i =0; i< len; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum /2;

        for (int i =0; i< len; i++) {
            int diff = sum - arr[i];
            if (set.contains(diff)) {
                System.out.println("Pair is: " + arr[i] + " " + diff);
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {2, 11, 5, 1, 4, 7};
//        int arr[] = {2, 4, 2, 1, 11, 15};
        int n = arr.length;
        if (checkPair(arr, n) == false)
        {
            System.out.printf("No pair found");
        }
    }
}
