package com.pironix.document.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pironix.document.dao.MongoDocumentDao;
import com.pironix.mongo.DbConnection;
import com.pironix.util.FileHelper;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.List;

/**
 * The MongoDocumentDaoImpl class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * MongoDocumentDaoImpl class generic Dao Class
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class MongoDocumentDaoImpl<T> implements MongoDocumentDao<T> {

    final static Logger logger = Logger.getLogger(MongoDocumentDaoImpl.class);
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;
    private BasicDBObject searchQuery;
    private BasicDBObject updateObjectQuery;

    /**
     * Save Generic Document
     *
     * @param t
     * @param document
     */
    public void saveOne(T t, Document document) {
        try {
            mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
            mongoCollection = mongoDatabase.getCollection(t.toString());
            mongoCollection.insertOne(document);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * Save Many Generic Document
     *
     * @param t
     * @param documentList
     */
    public void saveMany(T t, List<Document> documentList) {
        try {
            mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
            mongoCollection = mongoDatabase.getCollection(t.toString());
            mongoCollection.insertMany(documentList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * Update generic Document by given key criteria
     *
     * @param t
     * @param document
     * @param searchKey
     */
    public void update(T t, Document document, String[] searchKey, String[] newFields) {

        try {
            mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
            mongoCollection = mongoDatabase.getCollection(t.toString());
            searchQuery = new BasicDBObject();
            for (int i = 0; i < searchKey.length; i++) {
                searchQuery.put(searchKey[i], document.get(searchKey[i]));
            }
            updateObjectQuery = new BasicDBObject();
            for (int i = 0; i < newFields.length; i++) {
                updateObjectQuery.append(newFields[i], document.get(newFields[i]));
            }
            mongoDatabase.getCollection(t.toString()).updateOne(searchQuery,
                    new Document("$set", updateObjectQuery));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * Delete generic Document by given key criteria
     *
     * @param t
     * @param document
     * @param searchKey
     */
    public void deleteOne(T t, Document document, String[] searchKey) {

        try {
            mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
            mongoCollection = mongoDatabase.getCollection(t.toString());
            searchQuery = new BasicDBObject();

            for (int i = 0; i < searchKey.length; i++) {
                searchQuery.put(searchKey[i], document.get(searchKey[i]));
            }
            mongoCollection.deleteOne(searchQuery);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * Delete Many generic Document
     *
     * @param t
     * @param documentList
     */
    public void deleteMany(T t, List<Document> documentList) {
        try {
            mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
            mongoCollection = mongoDatabase.getCollection(t.toString());

            for (int i = 0; i < documentList.size(); i++) {
                mongoCollection.deleteOne(documentList.get(i));

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Create new collection given name
     *
     * @param collection
     */
    public void createCollection(String collection) {
        try {
            mongoDatabase = DbConnection.getInstance().getMongoClient().getDatabase(FileHelper.db);
            logger.info("Connect to database successfully");
            mongoDatabase.createCollection(collection);
            logger.info("create collection successfully");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
