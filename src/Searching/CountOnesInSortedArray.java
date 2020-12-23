package Searching;

//Given a binary array sorted in non-increasing order, count the number of 1’s in it.

public class CountOnesInSortedArray {

    private static int countOnes(int[] arr, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) /2;
            if (arr[mid] == 1 && arr[mid +1] == 0) {
                return mid +1;
            }
            if (arr[mid] == 1) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 1, 0, 0, 0 };
        int n = arr.length;
        System.out.println("Count of 1's in given array is "
                + countOnes(arr, 0, n - 1));
    }
}
