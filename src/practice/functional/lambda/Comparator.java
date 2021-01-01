package practice.functional.lambda;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    public int compare(T t1, T t2);

    public static Comparator<Person> comparing(Function<Person,Integer> f1){
      return  (p1,p2) -> f1.apply(p1) - f1.apply(p2);
    }

}
