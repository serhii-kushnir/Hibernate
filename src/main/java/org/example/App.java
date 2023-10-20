package org.example;

import lombok.extern.log4j.Log4j2;

@Log4j2
final class App {

    private App(){
    }

    public static void main(String[] args) {
        log.info("Started program");

        new Flyway();

        log.info("The program is completed");
    }
}

