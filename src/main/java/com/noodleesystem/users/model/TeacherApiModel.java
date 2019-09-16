package com.noodleesystem.users.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class TeacherApiModel extends UserApiModel {
    public TeacherApiModel() {
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "teachers_courses",
            joinColumns = {@JoinColumn(name = "id_teacher")},
            inverseJoinColumns = {@JoinColumn(name = "id_course")}
    )
    Set<CourseApiModel> courses = new HashSet<>();

    public Set<CourseApiModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseApiModel> courses) {
        this.courses = courses;
    }
}
