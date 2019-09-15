package com.noodleesystem.users.controller;

import com.noodleesystem.users.model.CourseApiModel;
import com.noodleesystem.users.repository.StudentRepository;
import com.noodleesystem.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository students;



}
