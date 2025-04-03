package com.study.planupassignment.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    @NotNull
    @Size(min = 1, max = 30, message = "최소 1글자, 최대 30글자까지 가능합니다.")
    private final String email;

    public UserUpdateRequestDto(String email) {
        this.email = email;
    }


}
