package com.pironix.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.pironix.util.FileHelper;

/**
 * The DbConnection class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * Singleton db Connection class
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class DbConnection {

    private static DbConnection dbConnection;
    private MongoClient mongoClient;

    /**
     * @return singleton DbConnection instance
     */
    public static DbConnection getInstance() {
        if (dbConnection != null)
            return dbConnection;
        return new DbConnection();

    }
    /**
     * getDbConnection  return singleton DbConnection instance
     *
     * @return
     */
    public static DbConnection getDbConnection() {
        return dbConnection;
    }

    /**
     * @return mongoClient object
     */
    public MongoClient getMongoClient() {
        if (mongoClient != null)
            return mongoClient;
        return new MongoClient(new MongoClientURI(FileHelper.url));
    }
}
