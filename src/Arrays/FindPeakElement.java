package Arrays;

public class FindPeakElement {
    static int findPeakUsingBinarySearch(int[] arr, int start, int end) {
        while(start < end) {
            int mid = (start + end ) / 2;
            if(arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }
    static int findPeak(int[] arr, int len) {
        if (len == 1) {
            return arr[0];
        }
        // if first element is greater than second element
        if (arr[0] > arr[1]){
            return arr[0];
        }
        if (arr[len-1] > arr[len -2]) {
            return arr[len-1];
        }

        return findPeakUsingBinarySearch(arr, 0, len-1);
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0 };
        int n = arr.length;
        System.out.println(
                "Index of a peak point is " + findPeak(arr, n));
    }
}
