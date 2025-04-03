package com.study.planupassignment.entitiy;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;


    public User() {

    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
