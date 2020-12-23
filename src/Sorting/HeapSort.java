package Sorting;

public class HeapSort {

    private int leftChild(int pos) {
        return ((2 * pos) + 1);
    }
    private int rightChild(int pos) {
        return ((2 * pos) + 2);
    }

    private void maxHeapify(int[]arr, int pos, int length) {
        if (pos >= (length/2) && pos <= length) {
            return;
        }
        while (arr[pos] < arr[leftChild(pos)] ||
                arr[pos] < arr[rightChild(pos)]) {
            if(arr[leftChild(pos)] > arr[rightChild(pos)]) {
                swap(arr, pos, leftChild(pos));
                maxHeapify(arr, leftChild(pos), length);
            } else {
                swap(arr, pos, rightChild(pos));
                maxHeapify(arr, rightChild(pos),length);
            }
        }
    }

    private void swap(int[] arr, int parentPos, int pos) {
            int temp = arr[pos];
            arr[pos] = arr[parentPos];
            arr[parentPos] = temp;
    }
    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public void sort(int[] arr) {
        // Create Heap by rearraging the elements in array.
        int length = arr.length;
        //Start the heapify operation from the leaf node.
        for (int i = (length-1)/2 ; i >=0 ; i--) {
            maxHeapify(arr, i, length-1);
        }
        for (int i = length - 1; i >0; i-- ) {
            if (arr[0] > arr[i]) {
                swap(arr, 0, i);
            }
            maxHeapify(arr, 0, i - 1);

        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 4, 13, 5, 6, 7, 1, 2};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println("Sorted array is ");
        heapSort.printArray(arr);
    }
}