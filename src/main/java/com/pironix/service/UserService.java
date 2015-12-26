package com.pironix.service;

import com.pironix.document.dao.impl.UserDocumentDaoImpl;
import com.pironix.document.model.User;

import java.io.Serializable;

/**
 * The UserService class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * UserService access UserDocumentDaoImpl
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */

public class UserService implements Serializable {

    UserDocumentDaoImpl userDocumentDaoImpl;
    /**
     * key of search query for user document
     */
    private String key[] = {"userId", "userName"};

    /**
     * User service constructor initialize new object userDocumentDao
     */
    public UserService() {
        userDocumentDaoImpl = new UserDocumentDaoImpl();
    }

    /**
     * @see com.pironix.document.dao.impl.UserDocumentDaoImpl
     */
    public void createUserCollection() {

        userDocumentDaoImpl.createUserCollection(new User());
    }

    /**
     * @param user
     * @see com.pironix.document.dao.impl.UserDocumentDaoImpl
     */
    public void saveUser(User user) {
        userDocumentDaoImpl.saveUser(user);

    }

    /**
     * @param user
     * @see com.pironix.document.dao.impl.UserDocumentDaoImpl
     */
    public void updateUser(User user, String[] newKey) {
        userDocumentDaoImpl.updateUser(user, key, newKey);
    }

    /**
     * @param user
     * @see com.pironix.document.dao.impl.UserDocumentDaoImpl
     */
    public void deleteUser(User user) {
        userDocumentDaoImpl.deleteUser(user, key);
    }

}
