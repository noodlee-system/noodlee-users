package com.noodleesystem.users.model;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user")
public class TeacherApiModel extends UserApiModel {
    public TeacherApiModel() {
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "courses",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    Set<CourseApiModel> courses = new HashSet<CourseApiModel>();

    public Set<CourseApiModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseApiModel> courses) {
        this.courses = courses;
    }
}
