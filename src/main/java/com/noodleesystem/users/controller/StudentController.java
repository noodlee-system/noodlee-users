package com.noodleesystem.users.controller;

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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAllCourses/{id}")
    List<CourseApiModel> getAllCourses(@PathVariable int id){
        List<CourseApiModel> courses = new ArrayList<>();
        StudentApiModel student = studentRepository.getOne((long) id);

        courses.addAll(student.getGroup().getCourses());
        courses.addAll(student.getOtherCourses());

        return courses;
    }

    @GetMapping("/generateTestData")
    void generate()
    {
        CourseApiModel course = new CourseApiModel();
        course.setName("testCourse");

        CourseApiModel otherCourse = new CourseApiModel();
        course.setName("otherTestCourse");

        ScoreApiModel score = new ScoreApiModel();
        score.setScore(5.0);

        StudentApiModel student = new StudentApiModel();
        student.setUsername("student");
        student.setFirstname("student");
        student.setLastname("student");
        student.setCountry("student");
        student.setEmail("student@student.student");
        student.setCity("student");

        StudentApiModel otherStudent = new StudentApiModel();
        student.setUsername("otherStudent");
        student.setFirstname("otherStudent");
        student.setLastname("otherStudent");
        student.setCountry("otherStudent");
        student.setEmail("otherStudent@otherStudent.otherStudent");
        student.setCity("otherStudent");

        TeacherApiModel teacher = new TeacherApiModel();
        teacher.setUsername("teacher");
        teacher.setFirstname("teacher");
        teacher.setLastname("teacher");
        teacher.setCountry("teacher");
        teacher.setEmail("teacher@teacher.teacher");
        teacher.setCity("teacher");

        UsersGroupApiModel group = new UsersGroupApiModel();
        group.setName("testGroup");
        group.setStartDate(Date.valueOf(LocalDate.now()));
        group.setEndDate(Date.valueOf(LocalDate.now().plusYears(3)));

        course.setOtherStudents(new HashSet<>(Arrays.asList(otherStudent)));
        course.setGroups(new HashSet<>(Arrays.asList(group)));
        course.setScores(new HashSet<>(Arrays.asList(score)));
        course.setTeachers(new HashSet<>(Arrays.asList(teacher)));

        score.setCourse(course);
        score.setStudent(student);

        student.setGroup(group);
        student.setScores(new HashSet<>(Arrays.asList(score)));
        student.setOtherCourses(new HashSet<>(Arrays.asList(otherCourse)));

        teacher.setCourses(new HashSet<>(Arrays.asList(course)));

        group.setStudents(new HashSet<>(Arrays.asList(student)));
        group.setCourses(new HashSet<>(Arrays.asList(course)));

        studentRepository.save(student);
        studentRepository.save(otherStudent);
    }
}
