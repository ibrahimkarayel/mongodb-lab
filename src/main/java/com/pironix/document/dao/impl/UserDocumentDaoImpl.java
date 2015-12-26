package com.pironix.document.dao.impl;

import com.pironix.document.model.User;
import org.bson.Document;

/**
 * The UserDocumentDaoImpl class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * UserDocumentDaoImpl class user Dao Class
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class UserDocumentDaoImpl extends MongoDocumentDaoImpl<User> {

    private Document document;

    /**
     * Create new collection named user
     *
     * @param user
     */
    public void createUserCollection(User user) {
        this.createCollection(user.toString());
    }

    /**
     * Save Given  user document
     *
     * @param user
     */
    public void saveUser(User user) {
        document = userDocumentData(user);
        saveOne(user, document);

    }

    /**
     * Update user Collection satisfy key values
     *
     * @param user
     * @param searchKey
     */
    public void updateUser(User user, String[] searchKey, String[] newKey) {
        document = userDocumentData(user);
        update(user, document, searchKey, newKey);
    }

    /**
     * Delete user Collection satisfy key values
     *
     * @param user
     * @param key
     */
    public void deleteUser(User user, String[] key) {
        document = userDocumentData(user);
        deleteOne(user, document, key);
    }

    /**
     * Formats the user details for MongoDBLab Posting
     *
     * @param user: Details of the user
     * @return
     */
    public Document userDocumentData(User user) {
        Document document = new Document();
        document.append("userId", user.getUserId())
                .append("userName", user.getUserName())
                .append("firstName", user.getUserName())
                .append("lastName", user.getLastName())
                .append("phone", user.getPhone())
                .append("email", user.getEmail())
                .append("password", user.getPassword())
                .append("registrationDate", user.getRegistrationDate())
                .append("lastLoginDate", user.getLastLoginDate())
                .append("enable", user.isEnable());
        return document;
    }


}
