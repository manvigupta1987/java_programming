package Sorting;

import java.util.Arrays;
import java.util.HashMap;

//1) Create a temp array and copy contents of given array to temp[]. This takes O(n) time.
//2) Sort temp[] in ascending order. This takes O(n Log n) time.
//3) Create an empty hash table. This takes O(1) time.
//4) Traverse temp[] form left to right and store mapping of numbers and their values (in converted array) in hash table. This takes O(n) time on average.
//5) Traverse given array and change elements to their positions using hash table. This takes O(n) time on average.
//
//Overall time complexity of this solution is O(n Log n).
public class ConvertArrToReducedForm {

    public static void convert(int arr[], int n) {
        int[] temp = arr.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for (int i =0; i< n; i++) {
            map.put(temp[i], val++);
        }

        for (int i=0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
    }

    public static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 12, 11, 50};
        int n = arr.length;

        System.out.println("Given Array is ");
        printArr(arr, n);

        convert(arr , n);

        System.out.println("\n\nConverted Array is ");
        printArr(arr, n);
    }
}
