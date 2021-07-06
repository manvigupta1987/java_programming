package Arrays;

//Given an array of integers. All numbers occur twice except one number which
// occurs once. Find the number in O(n) time & constant extra space.

//The best solution is to use XOR. XOR of all array elements gives us the number with a single occurrence.
// The idea is based on the following two facts.
//a) XOR of a number with itself is 0.
//b) XOR of a number with 0 is number itself.
public class FindElementAppearOnlyOnce {
    static int findSingle(int[] arr, int len) {
        int result = arr[0];
        for (int i = 1; i< len; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        int n = ar.length;
        System.out.println("Element occurring once is " +
                findSingle(ar, n) + " ");
    }
}
