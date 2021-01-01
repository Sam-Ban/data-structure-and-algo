package practice.functional.lambda;

import java.util.function.Function;

public class MainComparator {
    public static void main(String... args) {

        Comparator<Person> cmp = (p1, p2) -> p1.getAge() - p2.getAge();

        Function<Person,Integer> f1 = p1->p1.getAge();

        Comparator<Person> cmpPerson = Comparator.comparing(f1);
    }
}