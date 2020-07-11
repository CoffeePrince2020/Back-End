package com.coffeeprince;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeeprinceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeprinceApplication.class, args);
    }

}
