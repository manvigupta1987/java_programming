package Searching;

//Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x.
// Complexity -> O(Log(n))

public class FindFloorInSortedArray {
    private static int floorSearch(int[] arr, int low, int high, int key) {
        if (low == high && arr[low] <= key) {
            return arr[low];
        }
        // If last element is smaller than x
        if (key >= arr[high]) {
            return  arr[high];
        }
        while (low < high ) {
            System.out.println("low : " + low + " high :" + high);
            int mid = (low + (high - low)/2);

            if (arr[mid] <= key && arr[mid + 1] > key) {
                return arr[mid];
            }

            if (mid > 0 && arr[mid -1] < key && arr[mid] > key  ) {
                return arr[mid -1];
            }
            if (arr[mid] > key) {
                high =mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int n = arr.length;
        int x = 5;
        int index = floorSearch(arr, 0, n-1, x);
        if (index == -1) {
            System.out.println("floor doesn't exist, " + index);
        } else {
            System.out.println("floor is, " + index);
        }
    }
}
