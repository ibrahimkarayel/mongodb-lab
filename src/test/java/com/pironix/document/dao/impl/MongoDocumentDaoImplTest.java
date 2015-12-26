package com.pironix.document.dao.impl;

import com.mongodb.client.MongoDatabase;
import com.pironix.document.model.User;
import com.pironix.mongo.DbConnection;
import com.pironix.service.UserService;
import com.pironix.util.FileHelper;
import org.junit.Test;

/**
 * The MongoDocumentDaoImplTest class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * MongoDocumentDaoImplTest class test methods of remote mongodb lab
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class MongoDocumentDaoImplTest {

    private final String collection = "user";
    UserService userService = new UserService();
    private MongoDatabase mongoDatabase;

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("zirto");
        user.setFirstName("Zirto");
        user.setLastName("PIRTO");
        user.setEmail("zirto@gmail.com");
        userService.saveUser(user);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

        User user = new User();
        user.setUserId(1);
        user.setUserName("zirto");
        userService.deleteUser(user);
    }

    @Test
    public void testCreateDocument() throws Exception {
        mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
        System.out.println("Connect to database successfully");
        mongoDatabase.createCollection(collection);
        System.out.println("create collection successfully");

    }
}