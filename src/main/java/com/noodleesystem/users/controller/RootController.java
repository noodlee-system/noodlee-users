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
        //courseRepository.save(course);

        CourseApiModel otherCourse = new CourseApiModel();
        otherCourse.setName("otherTestCourse");
        //courseRepository.save(otherCourse);

        ScoreApiModel score = new ScoreApiModel();
        score.setScore(5.0);
        //scoreRepository.save(score);

        StudentApiModel student = new StudentApiModel();
        student.setUsername("student");
        student.setFirstname("student");
        student.setLastname("student");
        student.setCountry("student");
        student.setEmail("student@student.student");
        student.setCity("student");
        //studentRepository.save(student);

        StudentApiModel otherStudent = new StudentApiModel();
        otherStudent.setUsername("otherStudent");
        otherStudent.setFirstname("otherStudent");
        otherStudent.setLastname("otherStudent");
        otherStudent.setCountry("otherStudent");
        otherStudent.setEmail("otherStudent@otherStudent.otherStudent");
        otherStudent.setCity("otherStudent");
        //studentRepository.save(otherStudent);

        TeacherApiModel teacher = new TeacherApiModel();
        teacher.setUsername("teacher");
        teacher.setFirstname("teacher");
        teacher.setLastname("teacher");
        teacher.setCountry("teacher");
        teacher.setEmail("teacher@teacher.teacher");
        teacher.setCity("teacher");
        //teacherRepository.save(teacher);

        UsersGroupApiModel group = new UsersGroupApiModel();
        group.setName("testGroup");
        group.setStartDate(Date.valueOf(LocalDate.now()));
        group.setEndDate(Date.valueOf(LocalDate.now().plusYears(3)));
        //usersGroupRepository.save(group);

        course.setOtherStudents(new HashSet<>(Arrays.asList(otherStudent)));
        course.setGroups(new HashSet<>(Arrays.asList(group)));
        course.setScores(new HashSet<>(Arrays.asList(score)));
        course.setTeachers(new HashSet<>(Arrays.asList(teacher)));
        //courseRepository.save(course);

        score.setCourse(course);
        score.setStudent(student);
        //scoreRepository.save(score);

        student.setGroup(group);
        student.setScores(new HashSet<>(Arrays.asList(score)));
        student.setOtherCourses(new HashSet<>(Arrays.asList(otherCourse)));
        //studentRepository.save(student);
        //studentRepository.save(otherStudent);

        teacher.setCourses(new HashSet<>(Arrays.asList(course)));
        //teacherRepository.save(teacher);

        group.setStudents(new HashSet<>(Arrays.asList(student)));
        group.setCourses(new HashSet<>(Arrays.asList(course)));
        //usersGroupRepository.save(group);

        courseRepository.save(course);
        courseRepository.save(otherCourse);
        scoreRepository.save(score);
        usersGroupRepository.save(group);
        studentRepository.save(student);
        studentRepository.save(otherStudent);
        teacherRepository.save(teacher);

    }

}
