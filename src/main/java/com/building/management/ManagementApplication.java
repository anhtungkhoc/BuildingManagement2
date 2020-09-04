package com.building.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.building.management.service.impl"})
//@EntityScan("com.building.management.entity")
//@EnableJpaRepositories("com.building.management.repository")
public class ManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }

}
