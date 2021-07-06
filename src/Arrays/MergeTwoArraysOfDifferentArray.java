package Arrays;

import Utils.Utils;

import java.util.Arrays;

//There are two sorted arrays. First one is of size m+n containing only m elements.
// Another one is of size n and contains n elements. Merge these two arrays into the first
// array of size m+n such that the output is sorted.
//Input: array with m+n elements (mPlusN[]).

//Time Complexity: O(m+n)

public class MergeTwoArraysOfDifferentArray {
    static void mergeArrays(int[] arr1, int[] arr2, int len1, int len2) {
        if (len2 == 0) {
            return;
        }

        if (len1 == 0 && len2 != 0) {
            arr1 = arr2.clone();
            return;
        }

        int m = len1 - len2 -1;
        int k =0, j=0;
        while (k < len1) {
            // it takes the element from arr1 array when arr2 has already reached the end or element in arr1 is smaller than arr2.
            if ((m < len1 && arr1[m] < arr2[j]) || (j == len2)) {
                arr1[k] = arr1[m];
                k++;
                m++;
            } else {
                arr1[k] = arr2[j];
                j++;
                k++;
            }
        }
    }

    static void movePositiveElemToEnd(int[] mPlusN, int len) {
        int j =len -1;
        for (int i = len -1; i >=0 ; i--) {
            if (mPlusN[i] != -1) {
                Utils.swap(mPlusN, i, j);
                j--;
            }
        }
    }

    static void mergeArrays1(int[] arr1, int[] arr2, int len1, int len2) {
        int tail1 = len1-len2 -1;
        int tail2 = len2 -1;
        int finished = len1-1;
        while (tail1 >=0 && tail2 >=0) {
            arr1[finished--] = arr1[tail1] > arr2[tail2] ? arr1[tail1--] : arr2[tail2--];
        }

        while (tail2 >= 0) {
            arr1[finished--] = arr2[tail2--];
        }
    }

    static void movePositiveElemToBeginning(int[] mPlusN, int len) {
        int start = 0, i =0;
        while (i < len) {
            if (mPlusN[i] != -1) {
                Utils.swap(mPlusN, start, i);
                start++;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};

        int n = N.length;
        int m = mPlusN.length;

//        movePositiveElemToEnd(mPlusN, m);
        movePositiveElemToBeginning(mPlusN, m);
        Utils.printArray(mPlusN , m);
        mergeArrays1(mPlusN, N, m, n);
        Utils.printArray(mPlusN , m);

//        mergeArrays(mPlusN, N, m, n);
//
    }
}
