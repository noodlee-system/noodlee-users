package com.noodleesystem.users.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class CourseApiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<TeacherApiModel> teachers = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    private Set<UsersGroupApiModel> groups = new HashSet<>();

    @ManyToMany(mappedBy = "otherCourses")
    private Set<StudentApiModel> otherStudents = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<ScoreApiModel> scores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TeacherApiModel> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherApiModel> teachers) {
        this.teachers = teachers;
    }

    public Set<UsersGroupApiModel> getGroups() {
        return groups;
    }

    public void setGroups(Set<UsersGroupApiModel> groups) {
        this.groups = groups;
    }

    public Set<StudentApiModel> getOtherStudents() {
        return otherStudents;
    }

    public void setOtherStudents(Set<StudentApiModel> otherStudents) {
        this.otherStudents = otherStudents;
    }

    public Set<ScoreApiModel> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreApiModel> scores) {
        this.scores = scores;
    }
}
