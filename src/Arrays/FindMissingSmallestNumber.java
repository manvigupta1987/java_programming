package Arrays;

//Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n.
// Find the smallest number that is missing from the array.
//Examples
//
//Input: {0, 1, 2, 6, 9}, n = 5, m = 10
//Output: 3

// Method 1: Linear Search --> O(n)
// Method 2: Binary Search -> O(log n)
public class FindMissingSmallestNumber {
    static int findFirstMissingUsingLinearSearch(int[] arr, int start, int end) {
        if (start != arr[start]) {
            return start;
        }

        for (int i =0; i< end; i++) {
            if (arr[i+1] - arr[i] != 1) {
                return (arr[i] +1);
            }
        }
        return (end+1);
     }

     static int findFirstMissingUsingBinarySearch(int[] arr, int start, int end) {
        if (start > end) {
            return end+1;
        }
        if (start != arr[start]) {
            return start;
        }

        int mid = (start + end) /2;

        // this means that all the left side elements are present and at correct position
         if (arr[mid] == mid) {
             return findFirstMissingUsingBinarySearch(arr, mid+1, end);
         } else {
             return findFirstMissingUsingBinarySearch(arr, start, mid);
         }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 6, 9};
        int n = arr.length;
        System.out.println("First Missing element is : " +
                findFirstMissingUsingLinearSearch(arr, 0, n - 1));

        System.out.println("First Missing element is : " +
                findFirstMissingUsingBinarySearch(arr, 0, n - 1));
    }
}
