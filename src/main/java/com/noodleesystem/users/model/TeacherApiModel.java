package com.noodleesystem.users.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user")
public class TeacherApiModel extends UserApiModel {
    public TeacherApiModel() {
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Teachers_courses",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    Set<CourseApiModel> courses = new HashSet<>();

    public Set<CourseApiModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseApiModel> courses) {
        this.courses = courses;
    }
}
