package com.noodleesystem.users.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class StudentApiModel extends UserApiModel {
    @ManyToOne
    @JoinColumn(name="id_group", nullable=false)
    private UsersGroupApiModel group;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "students_courses",
            joinColumns = {@JoinColumn(name = "id_student")},
            inverseJoinColumns = {@JoinColumn(name = "id_course")}
    )
    Set<CourseApiModel> otherCourses = new HashSet<>();

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
}
