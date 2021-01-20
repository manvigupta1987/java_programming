package Arrays;

// Given a sorted array, the task is to remove the duplicate elements from the array.

// Time Complexity : O(n)
// Auxilary Space : O(1)

// https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    static int removeDuplicates(int[] arr, int len) {
        int j = 0;
        for (int i =0; i<len-1; i++) {
            if (arr[i] != arr[i+1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[len-1];
        return j;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,  2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;

        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
