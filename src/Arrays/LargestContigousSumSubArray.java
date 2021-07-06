package Arrays;

// Write an efficient program to find the sum of contiguous subarray within a one-dimensional
// array of numbers which has the largest sum.

//Algorithm :

//Initialize:
//    max_so_far = 0
//    max_ending_here = 0
//
//Loop for each element of the array
//  (a) max_ending_here = max_ending_here + a[i]
//  (b) if(max_so_far < max_ending_here)
//            max_so_far = max_ending_here
//  (c) if(max_ending_here < 0)
//            max_ending_here = 0
//return max_so_far


public class LargestContigousSumSubArray {
    static void maxSubArraySum(int[] arr, int len) {
        int max = 0;
        int current_sum = 0;
        int start = -1, end = -1, s =0;

        for (int i =0; i< len; i++) {
            current_sum += arr[i];
            if (max < current_sum) {
                max = current_sum;
                end = i;
                start = s;
            }
            if (current_sum < 0) {
                current_sum = 0;
                s = i+1;
            }
        }
        System.out.println("Max Sum = " + max + " start =" + start + " end =" + end);
    }
    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        maxSubArraySum(a, n);
    }
}
