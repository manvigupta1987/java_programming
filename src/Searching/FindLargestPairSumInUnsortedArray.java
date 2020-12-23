package Searching;

public class FindLargestPairSumInUnsortedArray {
    private static void findLargestSum(int[] arr, int length) {
        int first, second;
        if (length < 2 ){
            System.out.println("No Pair exists");
            return;
        }
        if (arr[0] > arr[1]) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[0];
        }
        for (int i = 2; i < arr.length ; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }
        System.out.println("Largest Sum is : "+ (first+second));
    }
    public static void main(String[] args) {
        int arr[] = {12, 34, 10, 6, 40};
        findLargestSum(arr, arr.length-1);
    }
}
