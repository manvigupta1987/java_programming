package Searching;

import java.util.HashMap;
import java.util.Map;

public class findMissingAndRepeatingElementInArray {
    private static void findMissingAndRepeatingUsingArray(int[] arr) {
        if(arr.length < 1) {
            throw new IllegalArgumentException();
        }
        int[] tempArr = new int[arr.length+1];
        for(int i = 0; i<arr.length; i++) {
            if(tempArr[arr[i]] == 0) {
                tempArr[arr[i]] = 1;
            } else {
                System.out.println("Repeating element is : " + arr[i]);
            }
        }
        for(int i = 1; i<tempArr.length; i++) {
            if (tempArr[i] == 0) {
                System.out.println("Missing element is : " + i);
            }
        }
    }

    private static void findMissingAndRepeatingUsingHashMap(int[] arr) {
        if(arr.length < 1) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for(Integer i: arr) {
            if(map.get(i) == null) {
                map.put(i, true);
            } else {
                System.out.println("Repeating element is : " + i);
            }
        }
        for(int i = 1; i<=arr.length; i++) {
            if (map.get(i) == null) {
                System.out.println("Missing element is : " + i);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = { 7, 3, 4, 5, 5, 6, 2 };
        findMissingAndRepeatingUsingArray(arr);
        findMissingAndRepeatingUsingHashMap(arr);
    }
}
