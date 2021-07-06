package Arrays;

// Problem: There is a given an array and split it from a specified position,
// and move the first part of array add to the end.

// Input : arr[] = {12, 10, 5, 6, 52, 36}, k = 2
//Output : arr[] = {5, 6, 52, 36, 12, 10}
//Explanation : Split from index 2 and first part {12, 10} add to the end .

// Time Complexity : O(n)
// Auxiliary Space : O(d)

public class SplitArrayAndAddFirstPartToEnd {

    static void rotate(int[] arr, int start, int end) {
        int i = start;
        while( i < end) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            end--;
            i++;
        }
    }
    static void splitArr(int[] arr, int len, int position) {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        if (len == 1) {
            return;
        }

        rotate(arr, 0, len-1);
        rotate(arr, 0, len-position-1);
        rotate(arr, len-position, len-1);
    }
    public static void main(String[] args) {
        int arr[] = { 12, 10, 5, 6, 52, 36 };
        int n = arr.length;
        int position = 2;

        splitArr(arr, 6, position);

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

    }
}
