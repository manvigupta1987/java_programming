package Arrays;

import java.util.Arrays;

// time complexity is O(n)
// https://www.geeksforgeeks.org/print-array-after-it-is-right-rotated-k-times/

public class rightRotateArrayByK {
    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k -1 );
        reverse(arr, k , arr.length-1);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        int k = 2;
        System.out.println("Given Array is");
        System.out.println(Arrays.toString(arr));

        rotate(arr, k);

        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(arr));
    }

}
