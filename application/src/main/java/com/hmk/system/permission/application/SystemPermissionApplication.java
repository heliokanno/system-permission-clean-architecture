package com.hmk.system.permission.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hmk.system.permission")
@SpringBootApplication
public class SystemPermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemPermissionApplication.class, args);
    }

}
