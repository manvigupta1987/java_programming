package Arrays;

import Utils.Utils;

import java.util.HashSet;

public class UnionAndIntersectionOfTwoSortedArrays {
    // Time Complexity : O(m+n)
    static void printUnion(int[] arr1, int[] arr2, int len1, int len2) {
        int temp[] = new int[len1 + len2];
        int i=0 , j =0, k = 0;
        while (i < len1 && j < len2) {
            if (k > 0 && arr1[i] == temp[k-1]) {
                i++;
                continue;
            } else if (k > 0 && arr2[j] == temp[k-1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                temp[k++] = arr1[i++];
            } else if (arr2[j] < arr1[i]) {
                temp[k++] = arr2[j++];
            } else if(arr2[j] == arr1[i]) {
                temp[k++] = arr1[i];
                i++;
                j++;
            }
        }

        while (i < len1) {
            temp[k++] = arr1[i++];
        }
        while (j < len2) {
            temp[k++] = arr2[j++];
        }

        Utils.printArray(temp, k);
    }

    // TimeComplexity is O(m) if m > n
    static void interSection(int[] arr1, int[] arr2, int len1, int len2) {
        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> intersect = new HashSet<>();
         for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
         }
        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                intersect.add(arr2[i]);
            }
        }

        int[] result = new int[intersect.size()];
        int i =0;
        for (Integer item : intersect) {
            result[i++] = item;
        }
        Utils.printArray(result, i);
    }
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 2, 3 };
        int arr2[] = { 2, 2, 3, 5, 7 };
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
        System.out.println("Intersection is :");
        interSection(arr1, arr2, m, n);
    }
}
