package practice.functional.test;

import java.util.function.BinaryOperator;

public class Operations {
    private  final BinaryOperator<Integer> fun;

    public Operations(BinaryOperator<Integer> fun) {
        this.fun = fun;
    }

    public int getResult(int num1,int num2){
        return fun.apply(num1,num2);
    }
}
