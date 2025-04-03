package com.study.planupassignment.dto.request;

import lombok.Getter;

@Getter
public class UserCreateRequestDto {

    private final String userName;

    private final String email;

    public UserCreateRequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
