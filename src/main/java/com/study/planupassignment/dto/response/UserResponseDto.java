package com.study.planupassignment.dto.response;

import com.study.planupassignment.entitiy.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String userName;

    private final String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user);
    }
}
