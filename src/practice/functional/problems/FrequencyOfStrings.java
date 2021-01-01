package practice.functional.problems;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyOfStrings {
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        IntStream.range(0,n)
                .mapToObj(x -> s.next())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((x,y) -> System.out.println(x+" : "+y));
    }
}