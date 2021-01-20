package Arrays;

//Given an array, cyclically rotate the array clockwise by one.
//
//Examples:
//
//Input:  arr[] = {1, 2, 3, 4, 5}
//Output: arr[] = {5, 1, 2, 3, 4}

import java.util.Arrays;


//Time Complexity: O(n)
// Space : O(1)
public class CyclicallyRotateArrayByOne {
    static void rotate(int[] arr) {
        if (arr.length < 1 ) {
            throw new IllegalArgumentException();
        }

        int temp = arr[arr.length -1];
        for (int i = arr.length -1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 9, 8};
        System.out.println("Given Array is");
        System.out.println(Arrays.toString(arr));

        rotate(arr);

        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(arr));
    }
}
