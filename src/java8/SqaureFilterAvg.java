package java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class SqaureFilterAvg {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{100,24,13,44,114,200,40,112};
        OptionalDouble average = Arrays.stream(arr).mapToInt(n->n*n).filter(n-> n>10000).average();

        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        }

    }
}
