package com.noodleesystem.users.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class UsersGroupApiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @OneToMany(mappedBy = "group")
    private Set<StudentApiModel> students;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "groups_courses",
            joinColumns = {@JoinColumn(name = "id_group")},
            inverseJoinColumns = {@JoinColumn(name = "id_course")}
    )
    Set<CourseApiModel> courses = new HashSet<>();

    public UsersGroupApiModel() {
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<StudentApiModel> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentApiModel> students) {
        this.students = students;
    }

    public Set<CourseApiModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseApiModel> courses) {
        this.courses = courses;
    }
}
