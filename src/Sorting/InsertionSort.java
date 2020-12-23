package Sorting;

//complexity : O(n*2)
public class InsertionSort {
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        if (len < 1) {
            throw new IllegalArgumentException();
        }
        for (int i=1; i<len-1; i++) {
            int key = arr[i];
            int j = i -1;
            for (; j>=0; j--) {
                if (arr[j] > key) {
                    arr[j+1] = arr[j];
                }
            }
            arr[j] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        sort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
