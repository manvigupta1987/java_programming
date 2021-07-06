package Arrays;

import Utils.Utils;

//Time Complexity : O(n2)
public class SegregateEvenAndOddNums {
    static void arrayEvenAndOddUsingInsertionSort(int[] arr, int n) {
        for (int i =1; i< n; i++) {
            int key = arr[i];
            if (key % 2 == 1) {
                continue;
            }

            int j = i-1;
            while (j >= 0 && arr[j] % 2 == 1) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    //Time Complexity --> O(n)
    //Auxiliary Space : O(1)
    static void arrayEvenAndOddWithO_N_Complexity(int[] arr, int len) {
        int i =0, j=0;
        while (i < len) {
            if (arr[i] % 2 == 0) {
                Utils.swap(arr, i, j);
                j++;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1,9, 5, 3, 2, 6, 7, 11 };
        int n = arr.length;
        arrayEvenAndOddUsingInsertionSort(arr, n);
        System.out.println("Array is");
        Utils.printArray(arr, n);

        int arr1[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
        int len = arr1.length;
        arrayEvenAndOddWithO_N_Complexity(arr1, len);
        Utils.printArray(arr1, len);

    }
}


//U,%Fzv9tci&zj)d