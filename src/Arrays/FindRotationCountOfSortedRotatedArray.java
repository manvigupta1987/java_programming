package Arrays;

// Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
//Input : arr[] = {15, 18, 2, 3, 6, 12}
//Output: 2
//Explanation : Initial array must be {2, 3,
//6, 12, 15, 18}. We get the given array after
//rotating the initial array twice.

//Solution:
// 1. Linear Search (O(n))
// 2. Binary Search (O(log n))

//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

public class FindRotationCountOfSortedRotatedArray {
    static int countRotations(int[] arr, int low, int high) {
        if (low > high) {
            return 0;
        }

        if (low == high) {
            return low;
        }

        while (low < high) {
            int mid = low + (high - low ) /2;
            if (mid > low && arr[mid] < arr[mid-1]) {
                return mid;
            }
            if (mid > high && arr[mid] > arr[mid + 1]) {
                return (mid+1);
            }
            if (arr[high] > arr[mid]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};
        int n = arr.length;

        System.out.println(countRotations(arr, 0, n-1));
    }
}
