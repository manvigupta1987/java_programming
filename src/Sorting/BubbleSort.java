package Sorting;

//Complexity is worst case O(n2), Best cae : O(n),
public class BubbleSort {
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
        boolean swap;
        for (int i =0; i< len-1; i++) {
            swap = false;
            for (int j =0; j< len-i-1; j++) {
                if (arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            // if none of the elements are swapped in the inner loop, then break.
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        sort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
