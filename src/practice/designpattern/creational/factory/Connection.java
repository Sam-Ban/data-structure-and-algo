package practice.designpattern.creational.factory;

public abstract class Connection {



    public Connection(){
        this.createConnection();
    }


    // All concrete classes need to @Override this method in order to create a connection
    public abstract void createConnection();
}
