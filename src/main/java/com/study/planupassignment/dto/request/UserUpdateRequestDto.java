package com.study.planupassignment.dto.request;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private final Long id;

    private final String email;

    public UserUpdateRequestDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }


}
