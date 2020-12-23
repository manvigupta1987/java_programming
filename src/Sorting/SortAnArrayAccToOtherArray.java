package Sorting;

import java.util.*;
// problem: Sort an array according to the order defined by another array

//Solution:
//Loop through A1[], store the count of every number in a HashMap (key: number, value: count of number)
//Loop through A2[], check if it is present in HashMap, if so, put in output array that many times and remove the number from HashMap.
//Sort the rest of the numbers present in HashMap and put in the output array.

public class SortAnArrayAccToOtherArray {
    static void sortAccording(int[] arr1, int[] arr2, int m, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item: arr1) {
            int count = map.getOrDefault(item, 0);
            map.put(item, count+1);
        }
        int index = 0;
        for (int item: arr2) {
            if (map.containsKey(item)) {
                int count = map.get(item);
                while (count >0) {
                    arr1[index++] = item;
                    count--;
                }
                map.remove(item);
            }
        }
        List<Integer> sortedKeys=new ArrayList(map.keySet());
        Collections.sort(sortedKeys);

        for (int item : sortedKeys) {
            arr1[index++] = item;
        }
    }

    // Utility function to print an array
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
        int A2[] = { 2, 1, 8, 3 };
        int m = A1.length;
        int n = A2.length;
        System.out.println("Sorted array is ");
        sortAccording(A1, A2, m, n);
        printArray(A1, m);
    }

}
