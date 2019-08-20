package com.noodleesystem.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.noodleesystem.users.model.UserApiModel;
import com.noodleesystem.users.repository.UserRepository;

@RestController
public class UsersControler {
    @Autowired
	private UserRepository usersRepository;

    @GetMapping("/")
    List<UserApiModel> getAllUsers() {
        return usersRepository.findAll();
	}
}
