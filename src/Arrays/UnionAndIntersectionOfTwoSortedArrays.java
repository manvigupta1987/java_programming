package Arrays;

public class UnionAndIntersectionOfTwoSortedArrays {
    // Time Complexity : O(m+n)
    static void printUnion(int[] arr1, int[] arr2, int len1, int len2) {
        int i =0, j =0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i] + " ");
                i++;
            } else if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i] + " ");
                i++;
                j++;
            } else {
                System.out.println(arr2[j] + " ");
                j++;
            }
        }
        while (i < len1) {
            System.out.println(arr1[i] + " ");
            i++;
        }
        while (j < len2) {
            System.out.println(arr2[j] + " ");
            j++;
        }
    }

    // TimeComplexity is O(m) if m > n
    static void interSection(int[] arr1, int[] arr2, int len1, int len2) {
        int i = 0, j=0;
        while (i< len1 && j < len2) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i] + " ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
        System.out.println("Intersection is :");
        interSection(arr1, arr2, m, n);
    }
}
