package practice.designpattern.creational.prototype;

public class PrototypeDemo {

    public static void main(String... args) {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("movie");
        movie.setTitle("50 shades of Grey");

        System.out.println(movie.getRuntime());
        System.out.println(movie.getPrice());
        System.out.println(movie.getRuntime());

        Movie anotherMovie = (Movie) registry.createItem("movie");
        anotherMovie.setTitle("Dallus Buyers Club");

        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getPrice());
        System.out.println(anotherMovie.getRuntime());

    }
}