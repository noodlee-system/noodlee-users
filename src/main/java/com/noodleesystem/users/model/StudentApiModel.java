package com.noodleesystem.users.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentApiModel extends UserApiModel {
    @ManyToOne
    @JoinColumn(name="id_group", nullable=false)
    private UsersGroupApiModel group;

    public StudentApiModel() {
    }

    public UsersGroupApiModel getGroup() {
        return group;
    }

    public void setGroup(UsersGroupApiModel group) {
        this.group = group;
    }
}
