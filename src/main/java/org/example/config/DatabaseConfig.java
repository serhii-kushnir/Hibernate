package org.example.config;

import lombok.extern.log4j.Log4j2;
import org.example.utils.MyOwnRuntimeException;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

@Log4j2
public final class DatabaseConfig {
    private static final String FILE = "src/main/resources/database.properties";
    private static final String MESSAGE_EXCEPTION = "Failed to read properties file";
    private static Properties properties;

    static {
        readFileProperties();
    }

    private DatabaseConfig() {
    }

    private static void readFileProperties() {
        properties = new Properties();

        try (FileInputStream input = new FileInputStream(FILE)) {
            properties.load(input);
        } catch (IOException e) {
            log.error(MESSAGE_EXCEPTION, e);
            throw new MyOwnRuntimeException(MESSAGE_EXCEPTION, e);
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}

