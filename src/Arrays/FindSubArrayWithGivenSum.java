package Arrays;

//Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
//Examples :
//
//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//Ouptut: Sum found between indexes 2 and 4


import java.util.HashMap;

public class FindSubArrayWithGivenSum {
    static void subArraySumWithPositiveNumbers(int[] arr, int len, int sum) {
        int current_sum = 0;
        int start = 0;
        for (int i =0; i < len ; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            current_sum += arr[i];
            // If curr_sum becomes equal to sum, then return true
            if (current_sum == sum) {
                System.out.println("Sum found between indexes " + start + " and " + (i));
                break;
            }
            while (current_sum > sum && start < i) {
                current_sum = current_sum - arr[start];
                start++;
            }
        }
    }

    static void subArraySumWithNegativeAndPostiveNumbers(int[] arr, int len, int sum) {
        int current_sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i =0; i < len ; i++) {
            current_sum += arr[i];
            if(map.containsKey(current_sum - sum) ) {
                count += map.get(current_sum - sum);
            }
            map.put(current_sum, map.getOrDefault(current_sum, 0) + 1);
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;

        int arr1[] = {-1, -1, 1};
        int sum1 = 0;
        subArraySumWithPositiveNumbers(arr, n, sum);
        subArraySumWithNegativeAndPostiveNumbers(arr1, arr1.length , sum1);
    }
}
