package Arrays;

//Given an array, find the largest element in it.
//Input : arr[] = {10, 20, 4}
//Output : 20

public class FindLargestAndSmallestElementInArray {
    static void largestAndSmallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i =0; i< arr.length ;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Largest and Smallest in given array is " + max + " " + min);
    }

    public static void main(String[] args) {
        int arr[] = {10, 324, 45, 90, 9808};
        largestAndSmallest(arr);
    }
}
