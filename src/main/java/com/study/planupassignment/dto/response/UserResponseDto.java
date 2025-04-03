package com.study.planupassignment.dto.response;

import com.study.planupassignment.entitiy.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String userName;

    private final String email;

    public UserResponseDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getUserName(), user.getEmail());
    }
}
