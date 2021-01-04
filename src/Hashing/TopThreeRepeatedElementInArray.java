package Hashing;


import java.util.HashMap;
import java.util.Map;

// Given an array of size N with repeated numbers, You Have to Find the top three repeated numbers.
//Note : If Number comes same number of times then our output is one who comes first in array
//Examples:
//
//Input : arr[] = {3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3}
//Output : Three largest elements are 3 16 15
//Explanation :Here, 3 comes 4 times, 16 comes 3 times, 15 comes 3 times.

// Time Complexity : O(n)
// Auxiliary Space : O(n)

public class TopThreeRepeatedElementInArray {
    static class Pair {
        int num;
        int freq;
    }
    static void top3Repeated(int[] arr, int len) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i< arr.length; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count +1);
        }

        Pair first = new Pair();
        Pair second = new Pair();
        Pair third = new Pair();

        for (Map.Entry curr : map.entrySet()) {
            int freq =  (int)curr.getValue();
            int number = (int)curr.getKey();
            if (freq > first.freq) {
                third.freq = second.freq;
                third.num = second.num;

                second.num = first.num;
                second.freq = first.freq;

                first.freq = freq;
                first.num = number;
            } else if (freq > second.freq) {
                third.freq = second.freq;
                third.num = second.num;

                second.num = number;
                second.freq = freq;
            } else if (freq > third.freq) {
                third.freq = freq;
                third.num = number;
            }
        }
        System.out.print("Three largest elements are " + first.num + " " + second.num + " " + third.num);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3 };
        int n = arr.length;
        top3Repeated(arr, n);
    }
}
