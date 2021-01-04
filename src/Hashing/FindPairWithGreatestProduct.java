package Hashing;

import java.util.Arrays;
import java.util.HashMap;

// Problem: Given an array of n elements, the task is to find the greatest number such that it is product of two elements of given array.
// If no such element exists, print -1. Elements are within the range of 1 to 10^5.

//Create an empty hash table and store all array elements in it.
//Sort the array in ascending order.
//Pick elements one by one from end of the array.
//And check if there exists a pair whose product is equal to that number. In this efficiency can be achieved. The idea is to reach till sqrt of that number.
// If we don’t get the pair till sqrt that means no such pair exists. We use hash table to make sure that we can find other element of pair in O(1) time.
//Repeat steps 2 to 3 until we get the element or whole array gets traversed.

public class FindPairWithGreatestProduct {
    static int findGreatest(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i =0; i< len; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count+1);
        }
        Arrays.sort(arr);
        for (int i = len-1; i > 1; i--) {
            for (int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % arr[j] == 0) {
                    int result = arr[i] / arr[j];
                    // if result is present in the array and its not equal to the arr[j]
                    if (arr[j] != result && map.containsKey(result)) {
                        return arr[i];
                    } else if (arr[j] == result && (map.containsKey(result) && map.get(result) > 1)) { // to handle the case like  2 and 4
                        return arr[i];
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {17, 2, 1, 15, 30};
        System.out.println(findGreatest(arr));

        int arr1[] = {10, 2, 4, 30, 35};
        System.out.println(findGreatest(arr1));

        int[] arr2 = {10, 2, 2, 4, 30, 35};
        System.out.println(findGreatest(arr2));
    }
}
