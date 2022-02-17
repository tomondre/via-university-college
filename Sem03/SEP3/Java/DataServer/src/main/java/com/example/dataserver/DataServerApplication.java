package com.example.dataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DataServerApplication {
    public static void main(String[] args) {
      SpringApplication.run(DataServerApplication.class, args);
    }
}
