package Arrays;

// Problem: There is a given an array and split it from a specified position, and move the first part of array add to the end.
// Input : arr[] = {12, 10, 5, 6, 52, 36}, k = 2
//Output : arr[] = {5, 6, 52, 36, 12, 10}
//Explanation : Split from index 2 and first
//part {12, 10} add to the end .

// Time Complexity : O(n)
// Auxiliary Space : O(d)

public class SplitArrayAndAddFirstPartToEnd {
    static void splitArr(int[] arr, int len, int position) {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        if (len == 1) {
            return;
        }

        int[] temp = new int[position];
        for (int i =0 ; i < position; i++) {
            temp[i] = arr[i];
        }

        for (int i = 0; i < len-position; i++) {
            arr[i] = arr[i + position];
        }
        int j=0;
        for (int i=len-position; i< len; i++) {
            arr[i] = temp[j++];
        }
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
