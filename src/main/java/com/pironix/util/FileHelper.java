package com.pironix.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The FileHelper class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * FileHelper load db url and db name from config file
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class FileHelper {
    final static Logger logger = Logger.getLogger(FileHelper.class);
    public static String db;
    public static String url;

    static {
        Properties prop = new Properties();
        try {
            InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);
            url = prop.getProperty("mongodb.lab.remote.url");
            db = prop.getProperty("db");

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
