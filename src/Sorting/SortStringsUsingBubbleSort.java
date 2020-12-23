package Sorting;

public class SortStringsUsingBubbleSort {
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void sortStrings(String[] arr, int n) {
        for (int i =0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        String[] arr = { "GeeksforGeeks", "Quiz", "Practice", "Gblogs", "Coding" };
        int n = arr.length;
        sortStrings(arr, n);
        System.out.println("Strings in sorted order are : ");
        for (int i = 0; i < n; i++)
            System.out.println("String " + (i + 1) + " is " + arr[i]);
    }
}
