package com.study.planupassignment.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    // 유저 수정을 위한 기능
    public void updateUser(String email) {
        this.email = email;
    }

    // 비밀번호 검증 기능
    public void isPassword(String password) {
        if(!this.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다.");
        }
    }
}
