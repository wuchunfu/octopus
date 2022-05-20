package org.metahut.octopus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.metahut.octopus")
public class ServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ServerApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
