package com.noodleesystem.users.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentApiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserApiModel user;

    public StudentApiModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserApiModel getUser() {
        return user;
    }

    public void setUser(UserApiModel user) {
        this.user = user;
    }
}
