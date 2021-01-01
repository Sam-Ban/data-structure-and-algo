package practice.functional.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

public class ImplFunctionalInterfaces {

    public static void main(String... args) {
        ArrayList<Person> arp = new ArrayList<>();
        Person p1 = new Person(25, "samik");
        Person p2 = new Person(30, "som");
        Person p3 = new Person(40, "santosh");
        Person p4 = new Person(42, "rajesh");

        arp.addAll(Arrays.asList(p1, p2, p3, p4));
        arp.add(supplierPerson.get());

        System.out.println(predicatePerson3.test(p3));


        conp.accept(arp);

        System.out.println(fp.apply(arp));

        consumerPersonSortByName.accept(arp);

    }
        //Consumer implementation
        static Consumer<ArrayList<Person>> conp = (arr) -> {
            arr.stream()
                    .map(x -> x.getAge() * 2)
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);
        };


    //Function implementation
    static Function<ArrayList<Person>, Integer> fp = (arr) -> {
        return arr.stream()
                .map(x -> x.getAge() * 2)
                .reduce((x1,x2) -> x1+x2)
                .orElse(0);
    };

    //Consumer and Comparator together
    static Consumer<ArrayList<Person>> consumerPersonSortByName = arr -> arr
            .stream()
            .sorted(Comparator.comparing(Person::getName))
            .forEach(System.out::println);

    //Supplier implementation
    static Supplier<Person> supplierPerson = () -> new Person(80,"Hirak");

    //Predicate implementation
    static Predicate<Person> predicatePerson1 = person -> person.getAge() > 20;
    static Predicate<Person> predicatePerson2 =  person -> person.getAge() < 70;
    static Predicate<Person> predicatePerson3 = predicatePerson1.and(predicatePerson2);

    //Collectors example :


}
