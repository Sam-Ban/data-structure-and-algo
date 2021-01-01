package practice.designpattern.creational.factory;

public class FactoryDemo {
    public static void main(String... args){
        Connection con = ConnectionFactory.getConnection("MongoDB");
    }
}
