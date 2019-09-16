package com.noodleesystem.users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class ScoreApiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_student")
    private StudentApiModel student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_course")
    @JsonManagedReference
    private CourseApiModel course;

    @Column(name = "score")
    private double score;

    public ScoreApiModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentApiModel getStudent() {
        return student;
    }

    public void setStudent(StudentApiModel student) {
        this.student = student;
    }

    public CourseApiModel getCourse() {
        return course;
    }

    public void setCourse(CourseApiModel course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
