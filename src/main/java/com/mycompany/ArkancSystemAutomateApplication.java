package com.mycompany;

import com.mycompany.user.UserRepository;
import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class ArkancSystemAutomateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArkancSystemAutomateApplication.class, args);
    }

}
