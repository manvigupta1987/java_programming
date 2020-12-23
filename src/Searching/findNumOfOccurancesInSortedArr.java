package Searching;

import java.util.HashMap;
import java.util.Map;

// Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)

//Approaches:
// 1. Linear search -> O(n)
// 2. Using BinarySearch -> O(Logn)
    // 1. First find the first occurance of key. let the index be i.
    // 2. find the last occurance of the key. let it be j.
    // count of occurances = j - i + 1;

public class findNumOfOccurancesInSortedArr {
    private static int binarySearch(int[] arr, int key, boolean searchFirst) {
        int left = 0;
        int right = arr.length - 1;
        int result = 0;
        while (left <= right) {
            int mid = (left+ right)/2;
            if(key == arr[mid]) {
                result = mid;
                if( searchFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else if(key < arr[mid]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
       int arr[] = {1, 1, 2, 2, 2, 2, 3,};
       int x = 2;
       int first = binarySearch(arr, x, true);
       int last = binarySearch(arr, x, false);

       System.out.println("first : " + first + "Last : " + last);
       int count = last - first + 1;
       System.out.println("Number of Occurences : " + count );
    }
}
