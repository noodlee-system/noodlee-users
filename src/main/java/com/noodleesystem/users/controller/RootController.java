package com.noodleesystem.users.controller;

import com.noodleesystem.users.model.*;
import com.noodleesystem.users.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@RestController
public class RootController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UsersGroupRepository usersGroupRepository;

    @GetMapping("/generateTestData")
    void generate()
    {
        CourseApiModel course = new CourseApiModel();
        course.setName("testCourse");

        CourseApiModel otherCourse = new CourseApiModel();
        otherCourse.setName("otherTestCourse");

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
        otherStudent.setUsername("otherStudent");
        otherStudent.setFirstname("otherStudent");
        otherStudent.setLastname("otherStudent");
        otherStudent.setCountry("otherStudent");
        otherStudent.setEmail("otherStudent@otherStudent.otherStudent");
        otherStudent.setCity("otherStudent");

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

        otherCourse.setOtherStudents(new HashSet<>(Arrays.asList(otherStudent)));
        otherCourse.setTeachers(new HashSet<>(Arrays.asList(teacher)));
        otherCourse.setGroups(new HashSet<>(Arrays.asList(group)));

        score.setCourse(course);
        score.setStudent(student);

        student.setGroup(group);
        student.setScores(new HashSet<>(Arrays.asList(score)));

        otherStudent.setOtherCourses(new HashSet<>(Arrays.asList(course)));

        teacher.setCourses(new HashSet<>(Arrays.asList(course, otherCourse)));

        group.setStudents(new HashSet<>(Arrays.asList(student)));
        group.setCourses(new HashSet<>(Arrays.asList(course, otherCourse)));

        courseRepository.save(course);
        courseRepository.save(otherCourse);
        scoreRepository.save(score);
        studentRepository.save(student);
        studentRepository.save(otherStudent);
        teacherRepository.save(teacher);
        usersGroupRepository.save(group);
    }

}
