package Searching;

//Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.
// Complexity of this is O(Log(n))

public class findMaximumElementWhichFirstIncreasingAndThenDecreasing {
    public static int findMaximum(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }
        /* If there are two elements and  first is greater then the first element is maximum */
        if (high == (low + 1 ) && arr[low] >= arr[high]) {
            return arr[low];
        }

        /* If there are two elements and  first is smaller then the second element is maximum */
        if (high == (low + 1 ) && arr[low] < arr[high]) {
            return arr[high];
        }

        while (low < high) {
            int mid = (low + high) /2;

            //when middle element is the max element.
            if (arr[mid] > arr[mid -1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            //when mid-1 element is the maximum element.
            if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid +1]) {
                return arr[mid-1];
            }
            if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid +1 ]) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 3, 4, 50, 51, 10, 9};
        int n = arr.length;
        System.out.println("The maximum element is "+
                findMaximum(arr, 0, n-1));
    }
}
