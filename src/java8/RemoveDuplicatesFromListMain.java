package java8;

import java.util.Arrays;

public class RemoveDuplicatesFromListMain {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{1,2,3,4,3,2,4,2};
        Arrays.stream(arr).distinct().forEach(System.out::println);
    }
}
