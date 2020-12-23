package Arrays;

// Mean of an array = (sum of all elements) / (number of elements)
// Median of a sorted array of size n is defined as the middle element when n is odd and average of middle two elements when n is even.

//https://www.techiedelight.com/quickselect-algorithm/
// https://www.geeksforgeeks.org/median-of-an-unsorted-array-in-liner-time-on/

import Utils.Utils;

public class MeanAndMedianOfUnsortedArray {

    static int num1,num2;

    static double findMean(int[] arr, int len) {
        int sum = 0;
        for (int item: arr) {
            sum += item;
        }
        return ((double) sum/ (double) len);
    }

    // Partition using Lomuto partition scheme
    static int partition(int a[], int left, int right, int pivotIndex)
    {
        // Pick pivotIndex as pivot from the array
        Utils.swap(a, left+pivotIndex, right);
        int pivot = a[right];

        // elements less than pivot will be pushed to the left of pIndex
        // elements more than pivot will be pushed to the right of pIndex
        // equal elements can go either way
        int pIndex = left;

        // each time we finds an element less than or equal to pivot, pIndex
        // is incremented and that element would be placed before the pivot.
        for (int i = left; i < right; i++)
        {
            if (a[i] < pivot)
            {
                Utils.swap(a, i, pIndex);
                pIndex++;
            }
        }

        // return pIndex (index of pivot element)
        return pIndex;
    }

    static int quickselect(int arr[], int left, int right, int k)
    {
        // If the array contains only one element, return that element
        if (left <= right)
        {
            // Find the partition index
            int n = right - left + 1;
            int partitionIndex = (int) (Math.random() % n);

            partitionIndex = partition(arr, left, right, partitionIndex);

            // If partion index = k, then we found the median of odd number element in arr[]
            if (partitionIndex == k)
            {
                num2 = arr[partitionIndex];
                if (num1 != -1)
                    return Integer.MIN_VALUE;
            }

            // If index = k - 1, then we get a & b as middle element of arr[]
            else if (partitionIndex == k - 1)
            {
                num1 = arr[partitionIndex];
                if (num2 != -1)
                    return Integer.MIN_VALUE;
            }

            // If partitionIndex >= k then find the index in first half of the arr[]
            if (partitionIndex >= k)
                return quickselect(arr, left, partitionIndex - 1, k);
            else
                // If partitionIndex <= k then find the index in second half of the arr[]
                return quickselect(arr, partitionIndex + 1, right, k);
        }

        return Integer.MIN_VALUE;
    }

    static double findMedian(int[] arr, int len) {
        num1 = -1;
        num2 = -1;
        quickselect(arr, 0, len-1, len/2);
        return len % 2 == 1 ? num1 : (num1 + num2) / 2;
    }

    public static void main(String[] args) {
        int a[] = { 12 , 3, 5, 7, 4, 19, 26, 13};
        int n = a.length;

        // Function call
        System.out.println("Mean = " + findMean(a, n));
        System.out.println("Median = " + findMedian(a, n));
    }
}
