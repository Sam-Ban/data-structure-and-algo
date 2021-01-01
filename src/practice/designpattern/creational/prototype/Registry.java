package practice.designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String,Item> items = new HashMap<>();

    public Registry(){
        loadItems();
    }

    public Item createItem(String type){
        Item item = null;
        try{
            item = (Item)(items.get(type)).clone();
        }catch(CloneNotSupportedException ce){
            ce.printStackTrace();
        }
        return item;
    }

    private void loadItems(){
        Movie movie = new Movie();
        movie.setTitle("Basic Instinct");
        movie.setPrice(100.98);
        movie.setRuntime("2 hours");
        items.put("movie",movie);

        Book book = new Book();
        book.setTitle("Gitanjali");
        book.setNoOfPages(200);
        book.setPrice(900);
        items.put("Book",book);
    }
}
