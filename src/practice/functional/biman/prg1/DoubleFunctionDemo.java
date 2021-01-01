package practice.functional.biman.prg1;

/* class DoubleFunction implements Function {
    public Integer apply(Integer x){
        return x*2;
    }
} */
public class DoubleFunctionDemo{
     public static void main(String... args){
      //   DoubleFunction df = new DoubleFunction();
 //       System.out.println(df.apply(5));

        //Anonymous class way
 /*       Function tripleFunction = new Function() {
            @Override
            public Integer apply(Integer x) {
                return x*2;
            }
        };
         System.out.println(tripleFunction.apply(10)); */
        //Lambda function
         Function<Integer,Integer> squareFunction = (x) -> x*x;
         System.out.println(squareFunction.apply(8));

         Function<String,String> uppercaseFunction = (str) -> str.toUpperCase();
         System.out.println(uppercaseFunction.apply("samik"));

         Function<String,Integer> lengthSender = (str) -> str.length();
         System.out.println(lengthSender.apply("samik"));

         Function<Integer,Function<Integer,Integer>> sumFunction = new Function<Integer, Function<Integer, Integer>>() {
             @Override
             public Function<Integer, Integer> apply(Integer x) {
                 return new Function<Integer, Integer>() {
                     @Override
                     public Integer apply(Integer y) {
                         return x+y;
                     }
                 };
             };
         };

         System.out.println(sumFunction.apply(10).apply(20));


         Function<Integer,Function<Integer,Integer>> lambdaSum = (x)->(y)->x/y;
         System.out.println(lambdaSum.apply(20).apply(10));


     }
}
