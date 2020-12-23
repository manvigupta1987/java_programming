package Sorting;

// 1) Find the candidate unsorted subarray
//a) Scan from left to right and find the first element which is greater than the next element. Let s be the index of such an element. In the above example 1, s is 3 (index of 30).
//b) Scan from right to left and find the first element (first in right to left order) which is smaller than the next element (next in right to left order). Let e be the index of such an element. In the above example 1, e is 7 (index of 31).
//
//2) Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not, then include more elements in the subarray.
//a) Find the minimum and maximum values in arr[s..e]. Let minimum and maximum values be min and max. min and max for [30, 25, 40, 32, 31] are 25 and 40 respectively.
//b) Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of this element. There is no such element in above example 1.
//c) Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of this element. In the above example 1, e is changed to 8 (index of 35)
//
//3) Print s and e.
public class FindMinimumlengthUnsortedSubarray {

    static void printUnsorted(int arr[], int n){
        int leftIndex = 0 , rightIndex = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // find first element which is greater than the next element.
        for (int i =0; i < n-1 ; i++) {
            if (arr[i] > arr[i+1] ) {
                leftIndex = i;
                break;
            }
        }
        //find first element which is smaller than the next element.
        for (int i = n-1; i > 0 ; i--) {
            if (arr[i] < arr[i-1] ) {
                rightIndex = i;
                break;
            }
        }
        //Find the minimum and maximum values in arr[s..e]
        for (int i = leftIndex+1; i <= rightIndex; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        // find the element greater than min from 0 to s-1
        for (int i =0; i < leftIndex; i++) {
            if (arr[i] > min) {
                leftIndex = i;
                break;
            }
        }
        // find the element less than max from s+1 to n
        for (int i =rightIndex+1; i < n-1; i++) {
            if (arr[i] < max) {
                rightIndex = i;
                break;
            }
        }

        System.out.println(" The unsorted subarray which"+
                " makes the given array sorted lies"+
                "  between the indices "+leftIndex+" and "+rightIndex);
    }

    public static void main(String[] args) {
        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int arr_size = arr.length;
        printUnsorted(arr, arr_size);
    }
}
