package org.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAsync
public class Main {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        Map<String, Object> props = new HashMap<>();
        props.put("spring.config.location", "D:\\JetBrains\\Projects\\BankApplication\\BankCreditService\\src\\main\\resources\\application.yaml");
        app.setDefaultProperties(props);
        app.run(args);
    }
}