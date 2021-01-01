package practice.designpattern.creational.factory;

public class MongoDBConnection extends Connection {

    @Override
    public void createConnection(){
        MongoDBConnection mongoDBConnection = new MongoDBConnection();
    }
}
