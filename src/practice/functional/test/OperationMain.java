package practice.functional.test;

public class OperationMain {
    public static void main(String[] args) {
        Operations sumOperations = new Operations((a1,a2) -> a1 + a2);

        System.out.println(sumOperations.getResult(4,5));
    }
}