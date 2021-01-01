package practice.designpattern.structural.adapter;

public class AdapterDemo {
    public static void main(String... args){
        MaterialClient mc = new MaterialClient();
        mc.getMaterialList().forEach(x -> System.out.println(x.toString()));
    }
}
