package org.example.configs;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

@Log4j2
public final class DatabaseConfig {
    private static final String FILE = "src/main/resources/database.properties";
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
            log.error("Failed to read properties file", e);
        }
    }

    public static String getUrl() {
        return properties.getProperty("bd.url");
    }

    public static String getUsername() {
        return properties.getProperty("bd.username");
    }

    public static String getPassword() {
        return properties.getProperty("bd.password");
    }
}

