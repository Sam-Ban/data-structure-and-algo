package practice.designpattern.creational.factory;

import java.sql.ResultSet;

public class RedisConnection extends Connection {
    @Override
    public void createConnection(){
        RedisConnection redisConnection = new RedisConnection();
    }

}
