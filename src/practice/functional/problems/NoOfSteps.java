package practice.functional.problems;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NoOfSteps {
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Integer> a = IntStream.range(0,n)
                .map(x->s.nextInt())
                .boxed()
                .collect(Collectors.toList());

        List<Integer> b = IntStream.range(0,n)
                .map(x -> s.nextInt())
                .boxed()
                .collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for(int i : a)
            min = Integer.min(i,min);
        int count = 0;

    }
}
