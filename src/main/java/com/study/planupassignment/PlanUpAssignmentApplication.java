package com.study.planupassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PlanUpAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanUpAssignmentApplication.class, args);
    }

}
