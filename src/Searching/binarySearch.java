package Searching;

//time complexity is O(Log(n)) (constant as the same procedure ocurrs again n again)

public class binarySearch {
    private static int search(int arr[], int x, int left, int right) {
        if(right >= left) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                return mid;
            }
            if (arr[mid] > x) {
                return search(arr, x, left, mid - 1);
            }
            return search(arr, x, mid + 1, right);
        }
        return -1;
    }
    private static int searchWithLessComparison(int arr[], int x, int left, int right) {
        while ( right- left > 1) {
            int mid = left + (right - left) / 2;
            if(x > arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(arr[left] == x ) {
            return left;
        } else if(arr[right] == x ) {
            return right;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int n = arr.length;
        // this method does logN + 1 comparision in worst case.
        int result = search(arr, x, 0, n-1);
        int result1 = searchWithLessComparison(arr, x, 0, n-1);
        if(result1 == -1) {
            System.out.println("Element is not present in the array");
        } else {
            System.out.println("Element is present in the array: " + result1 );
        }
    }
}
