package com.pironix.mongo;

import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.pironix.util.FileHelper;
import org.bson.Document;
import org.junit.Test;

/**
 * The DbConnectionTest class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * DbConnectionTest class test connection remote mongodb lab
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class DbConnectionTest {


    /**
     * connect method print all document in shareroute collection
     */
    @Test
    public void connect() {
        MongoDatabase db;
        db = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
        ListCollectionsIterable<Document> documentList = db.listCollections();
        for (Document d : documentList)
            System.out.println(d);
    }

}