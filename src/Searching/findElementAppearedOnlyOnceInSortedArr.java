package Searching;

//All elements before the required have the first occurrence at even index (0, 2, ..) and next occurrence at odd index (1, 3, …).
// And all elements after the required elements have the first occurrence at odd index and next occurrence at even index.

public class findElementAppearedOnlyOnceInSortedArr {
    private static int findElement(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }
        while(low < high) {
            int mid = low + (high - low ) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return arr[mid];
            }

            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }
            } else  {
                if (arr[mid] == arr[mid-1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 4, 5, 5, 6, 6 };
        System.out.println("Element that appears only once in the array is: " + findElement(arr, 0, arr.length-1));
    }
}
