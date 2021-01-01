package practice.functional.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

public class MapFilterReduceReImplementation {

    private static int reduce(List<Integer> ar1,int sum,BinaryOperator<Integer> op) {
        int result = sum;
        for (int x : ar1) {
            result = op.apply(result, x);
        }
        return result;
    }

    public static void main(String... args) {

        Person p1 = new Person(25, "samik");
        Person p2 = new Person(30, "som");
        Person p3 = new Person(40, "santosh");
        Person p4 = new Person(42, "rajesh");

        List<Person> ap = new ArrayList<>();
        ap.addAll(Arrays.asList(p1, p2, p3, p4));

        ap.forEach(person -> System.out.println(person.getName() + " : " + person.getAge()));
        ap.stream().map(person -> person.getAge()).filter(x -> x >= 30).reduce((x1, x2) -> x1 + x2);

        List<Integer> ar1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> ar2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;
        System.out.println(MapFilterReduceReImplementation.reduce(ar1, 0, op));
    }
}
