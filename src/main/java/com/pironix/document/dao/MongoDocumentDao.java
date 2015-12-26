package com.pironix.document.dao;

import org.bson.Document;

import java.util.List;

/**
 * The MongoDocumentDao interface
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * MongoDocumentDao<T>
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public interface MongoDocumentDao<T> {

    void saveOne(T t, Document document);

    void saveMany(T t, List<Document> documentList);

    void update(T t, Document document, String[] searchKey, String[] newFields);

    void deleteOne(T t, Document document, String[] searchKey);

    void deleteMany(T t, List<Document> documentList);

    void createCollection(String collection);
}
