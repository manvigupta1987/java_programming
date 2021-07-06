package Arrays;

import java.util.HashSet;

public class UnionIntersectionOfTwoUnsortedArrays {
    static void printUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int item: arr1) {
            set.add(item);
        }
        for (int item: arr2) {
            set.add(item);
        }
        System.out.println(set);
    }

    static void interSection(int[] arr1, int[] arr2, int len1, int len2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectSet = new HashSet<>();

        for (int item: arr1) {
            set.add(item);
        }
        for (int item: arr2) {
            if (set.contains(item)) {
                intersectSet.add(item);
            }
        }
        if (intersectSet.size() == 0) {
            System.out.println("No intersection elements are found");
        } else {
            System.out.println(intersectSet);
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 3, 2, 3, 4, 5, 5, 6 };
        int arr2[] = { 3, 3, 5 };

        int m = arr1.length;
        int n = arr2.length;

        printUnion(arr1, arr2);
        System.out.println("Intersection is :");
        interSection(arr1, arr2, m, n);
    }
}
