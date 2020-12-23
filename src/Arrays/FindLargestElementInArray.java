package Arrays;

//Given an array, find the largest element in it.
//Input : arr[] = {10, 20, 4}
//Output : 20

public class FindLargestElementInArray {
    static int largest(int[] arr) {
        int max = arr[0];
        for (int i =1; i< arr.length ;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {10, 324, 45, 90, 9808};
        System.out.println("Largest in given array is " + largest(arr));
    }
}
