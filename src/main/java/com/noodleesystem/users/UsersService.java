package com.noodleesystem.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import serilogj.Log;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.noodleesystem.users.model"})
public class UsersService {
    public static void main(String[] args) {
		SpringApplication.run(UsersService.class, args);

        Log.information("{serviceName} is running...", "Users Service");
	}
}
