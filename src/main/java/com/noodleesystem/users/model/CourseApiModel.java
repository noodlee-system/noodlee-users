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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "courses_groups",
            joinColumns = {@JoinColumn(name = "id_course")},
            inverseJoinColumns = {@JoinColumn(name = "id_group")}
    )
    Set<UsersGroupApiModel> groups = new HashSet<>();

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
}
