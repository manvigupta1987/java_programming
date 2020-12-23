package Sorting;

import java.util.*;

//Time Complexity : O(n Log n)
public class SortElementsByFrequency {
    public static void main(String[] args) {
        int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> listArr = new ArrayList<>();

        for (int item: array) {
            int count = map.getOrDefault(item, 0);
            map.put(item, count+1);
            listArr.add(item);
        }

        SortComparator comp = new SortComparator(map);
        Collections.sort(listArr, comp);

        // Final Output
        for (Integer i : listArr) {
            System.out.print(i + " ");
        }
    }
}

class SortComparator implements Comparator<Integer> {
    private Map<Integer, Integer> freqMap;
    SortComparator(Map<Integer, Integer> map) {
        this.freqMap = map;
    }
    @Override
    public int compare(Integer o1, Integer o2) {

        int freqCompare = freqMap.get(o2).compareTo(freqMap.get(o1));
        int valueCompare = o1.compareTo(o2);

        if (freqCompare == 0) {
            return valueCompare;
        } else {
            return freqCompare;
        }
    }
}