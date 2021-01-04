package Hashing;

import java.util.Arrays;
import java.util.HashMap;
// Given an array with n distinct elements, convert the given array to a form where all elements are in range from 0 to n-1. The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second smallest element, … n-1 is placed for largest element.
//
//Input:  arr[] = {10, 40, 20}
//Output: arr[] = {0, 2, 1}

// Solution:
//1) Create a temp array and copy contents of given array to temp[]. This takes O(n) time.
//2) Sort temp[] in ascending order. This takes O(n Log n) time.
//3) Create an empty hash table. This takes O(1) time.
//4) Traverse temp[] form left to right and store mapping of numbers and their values (in converted array) in hash table. This takes O(n) time on average.
//5) Traverse given array and change elements to their positions using hash table. This takes O(n) time on average.
//
//Overall time complexity of this solution is O(n Log n).

public class ConvertArrayToReducedForm {
    static void reducedForm(int[] arr) {
        int[] temp = arr.clone();

        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<arr.length; i++) {
            map.put(temp[i], i);
        }

        for (int i =0; i<arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[] = {5, 10, 40, 30, 20};
        reducedForm(arr);

        for (int i = 0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
