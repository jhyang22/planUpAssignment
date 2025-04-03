package com.study.planupassignment.dto.request;

import lombok.Getter;

@Getter
public class UserCreateRequestDto {

    private final String userName;

    private final String password;

    private final String email;

    public UserCreateRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
