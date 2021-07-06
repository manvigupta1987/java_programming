package Sorting;

public class CheckIfArraySortedOrNot {
    static boolean arraySortedOrNot(int[] arr, int n) {
        // Array has one or no element or the
        // rest are already checked and approved.
        if (n == 0 || n == 1) {
            return true;
        }
//        // Unsorted pair found (Equal values allowed)
//        if (arr[n-1] < arr[n-2]) {
//            return false;
//        }
//        // Last pair was sorted
//        // Keep on checking
//        return arraySortedOrNot(arr, n-1);

        int i = 0;
        while(i < n -1) {
            if(arr[i] > arr[i+1]) {
              return false;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = { 3, 4, 1, 5, 2 };
        int n = arr.length;
        if (arraySortedOrNot(arr, n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
