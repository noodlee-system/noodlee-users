package com.noodleesystem.users.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.noodleesystem.users.exception.UserNotFoundException;
import com.noodleesystem.users.model.CourseApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.noodleesystem.users.model.UserApiModel;
import com.noodleesystem.users.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserRepository usersRepository;

    @GetMapping("/getAll")
    List<UserApiModel> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    UserApiModel getUser(@PathVariable int id) {
        UserApiModel user = usersRepository.getUserById(id);

        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    UserApiModel updateUser(@PathVariable("id") int id, @RequestBody UserApiModel userToUpdate) {
        UserApiModel user = usersRepository.getUserById(id);
        user.setUsername(userToUpdate.getUsername());
        user.setFirstname(userToUpdate.getFirstname());
        user.setLastname(userToUpdate.getLastname());
        user.setCity(userToUpdate.getCity());
        user.setCountry(userToUpdate.getCountry());
        user.setEmail(userToUpdate.getEmail());
        usersRepository.save(user);
        return user;
    }
}