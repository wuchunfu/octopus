package org.metahut.octopus.alerter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.metahut.octopus")
public class AlerterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlerterApplication.class);
    }
}
