package com.noodleesystem.users.model;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user")
public class TeacherApiModel extends UserApiModel {
    public TeacherApiModel() {
    }
}
