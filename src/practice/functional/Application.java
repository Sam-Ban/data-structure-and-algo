package practice.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application {
    public static void main(String[] args){
        FunctionalTest<Integer,Integer,Integer,Integer> ft = (a,b,c)->a*b*c;
        System.out.println(ft.apply(3,4,5));

        BiFunction<Integer,Integer,Double> ff = (a,b)->(double)((double)a/(double)b);
        System.out.println(ff.apply(12,5));

        SamikFunctionalInterface sfi = (str)-> str.toUpperCase();
        System.out.println(sfi.getName("samik"));

    }
}
