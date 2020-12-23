package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayBasedOnStringLength {
    static void printArraystring(String str[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(str[i]+" ");
    }

    static void SortArrayJava1_7(String[] arr, int len) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
    }

    static void SortArrayJava1_8(String[] arr, int len) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
    }
    public static void main(String[] args) {
        String []arr = {"GeeksforGeeks", "I", "from", "am"};
        int n = arr.length;

//        SortArrayJava1_7(arr, n);
        printArraystring(arr, n);

        System.out.println("");

        SortArrayJava1_8(arr, n);
        printArraystring(arr,n);

    }
}
