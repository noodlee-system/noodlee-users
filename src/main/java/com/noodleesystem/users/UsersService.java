package com.noodleesystem.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import serilogj.Log;

@SpringBootApplication
public class UsersService {
    public static void main(String[] args) {
		SpringApplication.run(UsersService.class, args);

        Log.information("{serviceName} is running...", "Users Service");
	}
}
