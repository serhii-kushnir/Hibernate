package org.example.utils;

import lombok.extern.log4j.Log4j2;
import org.flywaydb.core.api.FlywayException;

import static org.example.config.DatabaseConfig.getPassword;
import static org.example.config.DatabaseConfig.getUsername;
import static org.example.config.DatabaseConfig.getUrl;

@Log4j2
public final class Flyway {
    private static final String JDBC_URL = getUrl();
    private static final String DB_USERNAME = getUsername();
    private static final String DB_PASSWORD = getPassword();
    private static final String MESSAGE_EXCEPTION = "Failed to initialize Flyway";

    public Flyway() {
        if (JDBC_URL == null || DB_USERNAME == null || DB_PASSWORD == null) {
            throw new MyOwnRuntimeException("Database configuration is incomplete");
        }

        this.init();
    }

    private void init() {
        try {
            log.info("Started Flyway");

            org.flywaydb.core.Flyway.configure()
                    .dataSource(JDBC_URL, DB_USERNAME, DB_PASSWORD)
                    .locations("classpath:flyway")
                    .baselineOnMigrate(true)
                    .load()
                    .migrate();

            log.info("Flyway installed: Ok");
        } catch (FlywayException e) {
            log.error(MESSAGE_EXCEPTION, e);
            throw new MyOwnRuntimeException(MESSAGE_EXCEPTION, e);
        }
    }
}
