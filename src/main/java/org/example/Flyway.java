package org.example;

import lombok.extern.log4j.Log4j2;

@Log4j2
final class Flyway {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/SpaceTravel";
    private static final String BD_USERNAME = "root";
    private static final String BD_PASSWORD = "root";

    Flyway() {
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