package practice.designpattern.creational.factory;

public class ConnectionFactory {

    public static Connection getConnection(String connectionType){
        if(connectionType.equalsIgnoreCase("MongoDB"))
            return new MongoDBConnection();
        else if(connectionType.equalsIgnoreCase("Redis"))
            return new RedisConnection();
        else return null;
    }
}
