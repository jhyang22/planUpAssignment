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

    @Column(nullable = false, length = 10)
    private String userName;

    @Column(nullable = false, unique = true, length = 10)
    private String password;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    
    public User() {

    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public void updateUser(String email) {
        this.email = email;
    }
}
