package practice.functional;

public interface FunctionalTest<T1,T2,T3,R> {
    R apply(T1 arg1,T2 arg2,T3 arg3);
}
