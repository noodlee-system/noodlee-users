package com.noodleesystem.users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class StudentApiModel extends UserApiModel {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_group")
    private UsersGroupApiModel group;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "students_courses",
            joinColumns = {@JoinColumn(name = "id_student")},
            inverseJoinColumns = {@JoinColumn(name = "id_course")}
    )
    @JsonManagedReference
    Set<CourseApiModel> otherCourses = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private Set<ScoreApiModel> scores;

    public StudentApiModel() {
    }

    public UsersGroupApiModel getGroup() {
        return group;
    }

    public void setGroup(UsersGroupApiModel group) {
        this.group = group;
    }

    public Set<CourseApiModel> getOtherCourses() {
        return otherCourses;
    }

    public void setOtherCourses(Set<CourseApiModel> otherCourses) {
        this.otherCourses = otherCourses;
    }

    public Set<ScoreApiModel> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreApiModel> scores) {
        this.scores = scores;
    }
}
