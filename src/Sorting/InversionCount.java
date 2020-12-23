package Sorting;

public class InversionCount {
    private static int getInvCountByBruteForce(int[] arr, int length) {
        int inversionCount = 0;
        for (int i =0; i<length-1; i++) {
            for (int j = i+1 ; j< length; j++) {
                if (arr[i] >= arr[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

    private static int mergeAndCount(int[] arr, int low, int mid, int high) {
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
        int swaps = 0;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                swaps += (mid+1) - (low + i);
            }
        }
        return swaps;
    }

    private static int mergeSortandCount(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            // left subarray count
            count += mergeSortandCount(arr, low, mid);

            //right subarray count
            count += mergeSortandCount(arr, mid+1 , high);

            //Merge count
            count += mergeAndCount(arr, low, mid , high);

        }
        return count;
    }

    private static int getInvCountByMergeSort(int[] arr, int length) {
        return mergeSortandCount(arr, 0, length-1);
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 20, 6, 4, 5 };
        //Time Complexity is O(n2)
        System.out.println("Number of inversions are "
                + getInvCountByBruteForce(arr, arr.length));

        // Time Complexity is O(nlogn)
        System.out.println("Number of inversions are "
                + getInvCountByMergeSort(arr, arr.length));
    }
}
