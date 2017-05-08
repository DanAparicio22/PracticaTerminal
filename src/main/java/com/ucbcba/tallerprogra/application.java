package com.ucbcba.tallerprogra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ucbcba.tallerprogra.Controllers", "com.ucbcba.tallerprogra.Services"})
@EntityScan("com.ucbcba.tallerprogra.Entities")
@EnableJpaRepositories(basePackages={"com.ucbcba.tallerprogra.Repositories"})
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
