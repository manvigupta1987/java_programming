package Sorting;

// Complexity is θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves
// and takes linear time to merge two halves.

public class MergeSort {
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // find length of the sub-arrays
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // copy the content of arr from low to high in the temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i =0; i < n1; i++) {
            L[i] = arr[low+i];
        }
        for (int j =0; j < n2; j++) {
            R[j] = arr[mid+1+j];
        }

        int i =0, j =0;
        int k = low;
        //Merge the arrays
        while (i< n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy the remaining elements of the subarrays.
        while (i<n1) {
            arr[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = arr[j];
            k++;
            j++;
        }
    }

    private static void sort(int[] arr, int low, int high) {
        int len = arr.length;
        if (len < 1) {
            throw new IllegalArgumentException();
        }

        if (high > low) {
            int mid = (low + high) /2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);

            //Merge the two sorted arrays
            merge(arr, low, mid, high);
        }

    }

    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array After Merge Sort");
        printArray(arr);
    }
}
