package Arrays;

import java.util.Arrays;

public class leftRotateArrayByK {
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
        int len = arr.length;
        k = k % len;
        reverse(arr, 0, len-1);
        reverse(arr, 0, len - 1 -k );
        reverse(arr, len-1 -(k-1), len-1);
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
