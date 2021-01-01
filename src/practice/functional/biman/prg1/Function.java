package practice.functional.biman.prg1;

@FunctionalInterface
public interface Function<T,R> {

    public R apply(T x);
}
