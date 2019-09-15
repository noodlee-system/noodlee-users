package com.noodleesystem.users.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user")
public class StudentApiModel extends UserApiModel {
    public StudentApiModel() {
    }
}
