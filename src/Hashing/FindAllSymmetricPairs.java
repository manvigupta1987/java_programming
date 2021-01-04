package Hashing;

import java.util.HashMap;

// Two pairs (a, b) and (c, d) are said to be symmetric if c is equal to b and a is equal to d. For example, (10, 20) and (20, 10) are symmetric. Given an array of pairs find all symmetric pairs in it.
//It may be assumed that the first elements of all pairs are distinct.
//
//Example:
//
//Input: arr[] = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}}
//Output: Following pairs have symmetric pairs
//        (30, 40)
//        (5, 10)

public class FindAllSymmetricPairs {
    static void findSymPairs(int[][] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];
            if (map.containsKey(second)) {
                int value = map.get(second);
                if (value == first) {
                    System.out.println("(" + second + ", " + first + ")");
                }
            } else {
                map.put(first, second);
            }
        }
    }
    public static void main(String[] args) {
        int arr[][] = new int[5][2];
        arr[0][0] = 11; arr[0][1] = 20;
        arr[1][0] = 30; arr[1][1] = 40;
        arr[2][0] = 5;  arr[2][1] = 10;
        arr[3][0] = 40;  arr[3][1] = 30;
        arr[4][0] = 10;  arr[4][1] = 5;
        findSymPairs(arr);

    }
}
