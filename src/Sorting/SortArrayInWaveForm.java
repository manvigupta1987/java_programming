package Sorting;

//Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is sorted in wave form
// if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= ….

//TimeComplexity is O(n)
//  Traverse all even positioned elements of input array, and do following.
//….a) If current element is smaller than previous odd element, swap previous and current.
//….b) If current element is smaller than next odd element, swap next and current.
public class SortArrayInWaveForm {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void sortInWave(int[] arr, int n) {
        for (int i =0; i< n; i = i+2) {
            if (i> 0 && arr[i] < arr[i-1]) {
                swap(arr, i, i-1);
            }
            if (i<n-1 && arr[i] < arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
    }

    public static void main(String args[])
    {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        sortInWave(arr, n);
        for (int i : arr)
            System.out.print(i+" ");
    }
}
