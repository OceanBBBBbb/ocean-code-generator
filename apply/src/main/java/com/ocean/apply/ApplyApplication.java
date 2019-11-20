package com.ocean.apply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@ComponentScan({"com.ocean.generator","com.ocean.apply"})
@EnableJpaRepositories(basePackages = { "com.ocean.generator.repository"})
@EntityScan(basePackages = { "com.ocean.generator.domain" })
public class ApplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplyApplication.class, args);
    }

}
