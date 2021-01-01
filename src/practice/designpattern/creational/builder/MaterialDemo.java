package practice.designpattern.creational.builder;

public class MaterialDemo {
    public static void main(String... args){
        Material material = new Material.MaterialBuilder("928999-1","ZHLB")
                                        .department("MOLDING")
                                        .productOwingBU("AUTG")
                                        .build();

        System.out.println(material.toString());
    }
}