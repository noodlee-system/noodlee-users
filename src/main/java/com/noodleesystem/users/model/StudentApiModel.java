package com.noodleesystem.users.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user")
public class StudentApiModel extends UserApiModel {
    @ManyToOne
    @JoinColumn(name="id_course", nullable=false)
    private CourseApiModel course;

    public StudentApiModel() {
    }

    public CourseApiModel getCourse() {
        return course;
    }

    public void setCourse(CourseApiModel course) {
        this.course = course;
    }
}
