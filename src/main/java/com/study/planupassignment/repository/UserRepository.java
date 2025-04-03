package com.study.planupassignment.repository;

import com.study.planupassignment.dto.request.LoginRequestDto;
import com.study.planupassignment.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);
    Optional<User> findUserByEmail(String email);


    default User findByUserNameOrElseThrow(String userName) {
        return findUserByUserName(userName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    default User findUserByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    default User findUserByEmailOrElseThrow(LoginRequestDto dto) {
        return findUserByEmail(dto.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
