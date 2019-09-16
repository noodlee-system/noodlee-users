package com.noodleesystem.users.controller;

import com.noodleesystem.users.exception.UserNotFoundException;
import com.noodleesystem.users.model.*;
import com.noodleesystem.users.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAllCourses/{id}")
    List<CourseApiModel> getAllCourses(@PathVariable int id) {
        StudentApiModel student = studentRepository.getStudentById(id);

        if (student == null)
            throw new UserNotFoundException(id);

        List<CourseApiModel> courses = new ArrayList<>();
        if (student.getGroup() != null)
            courses.addAll(student.getGroup().getCourses());

        courses.addAll(student.getOtherCourses());

        return courses;
    }
}
