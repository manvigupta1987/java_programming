package Sorting;

//Complexity is O(n2).
// Minimum element is always kept at the front of the array.
public class SelectionSort {
    private static void sort(int[] arr) {
        int len = arr.length;
        if( len < 1 ) {
            throw new IllegalArgumentException();
        }
        for (int i =0; i< len-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        sort(arr);
        System.out.println("Sorted array");
        printArray(arr);

    }
}
