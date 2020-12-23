package Arrays;

//Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
//Examples :
//
//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//Ouptut: Sum found between indexes 2 and 4


public class FindSubArrayWithGivenSum {
    static void subArraySum(int[] arr, int len, int sum) {
        int current_sum = arr[0];
        int start = 0;
        for (int i =1; i <= len ; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (current_sum > sum && start < i-1) {
                current_sum = current_sum - arr[start];
                start++;
            }
            // If curr_sum becomes equal to sum, then return true
            if (current_sum == sum) {
                System.out.println("Sum found between indexes " + start + " and " + (i -1));
                break;
            }
            // Add this element to curr_sum
            if (i < len) {
                current_sum += arr[i];
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;
        subArraySum(arr, n, sum);
    }
}
