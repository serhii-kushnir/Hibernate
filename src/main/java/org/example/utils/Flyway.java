package org.example.utils;

import lombok.extern.log4j.Log4j2;

import static org.example.configs.DatabaseConfig.getPassword;
import static org.example.configs.DatabaseConfig.getUsername;
import static org.example.configs.DatabaseConfig.getUrl;

@Log4j2
public final class Flyway {
    private static final String JDBC_URL = getUrl();
    private static final String BD_USERNAME = getUsername();
    private static final String BD_PASSWORD = getPassword();

    public Flyway() {
        this.init();
    }

    private void init() {
        log.info("Started Flyway");

        org.flywaydb.core.Flyway.configure()
                .dataSource(JDBC_URL, BD_USERNAME, BD_PASSWORD)
                .locations("classpath:flyway")
                .baselineOnMigrate(true)
                .load()
                .migrate();

        log.info("Flyway installed: Ok");
    }
}
