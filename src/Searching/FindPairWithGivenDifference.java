package Searching;

//Use HashMap to find the pair of given difference

import java.util.HashMap;

public class FindPairWithGivenDifference {
    public static void findPair(int[] arr, int diff) {
        HashMap <Integer, Integer> map = new HashMap();
        for (int i =0; i < arr.length; i++) {
            map.put(arr[i], 0);
        }

        for (Integer key : map.keySet()) {
            int remainDiff = Math.abs(diff - key);
            if (map.containsKey(remainDiff)) {
                System.out.println("Pair Found: "+ key + "," + remainDiff);
                return;
            }
        }
        System.out.println("No Such Pair Found: ");
    }

    public static void main(String[] args) {
        int arr[] = {5, 20, 3, 2, 50, 80};
        int n = 78;
        findPair(arr,n);
    }
}
