package practice.functional.problems;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CountDivisors {
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int r = s.nextInt();
        int k = s.nextInt();
        System.out.println(IntStream
                .rangeClosed(l,r)
                .filter(x -> x%k==0)
                .count());
    }

}
