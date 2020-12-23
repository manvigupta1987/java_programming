package Searching;

//An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot
// unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
public class SearchElementInSortedAndRotatedArray {
    private static int search(int arr[], int key, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) /2;
        if(key == arr[mid]) {
            return mid;
        }
        // first half is the sorted array
        if(arr[left] < arr[mid]) {
            if(key >= arr[left] && key <= arr[mid]) {
                return search(arr, key, left, mid -1);
            } else {
                return search(arr, key, mid+1, right);
            }
        }
        //If arr[l..mid] first subarray is not sorted, then arr[mid... h] must be sorted subarry*/
        if(key >= arr[mid] && key <= arr[right]) {
            return search(arr, key, mid+1, right);
        }
        return search(arr, key, mid+1, right);
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int n = arr.length;
        int key = 2;
        int result = search(arr,key, 0, n-1);
        if(result == -1) {
            System.out.println("Element is not present in the array");
        } else {
            System.out.println("Element is present in the array: " + result );
        }
    }
}
