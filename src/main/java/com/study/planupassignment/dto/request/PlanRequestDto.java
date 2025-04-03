package com.study.planupassignment.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PlanRequestDto {

    @NotNull
    @Size(min = 1, max = 10, message = "최소 1글자, 최대 10글자까지 가능합니다.")
    private final String userName;

    @NotNull
    @Size(min = 1, max = 10, message = "최소 1글자, 최대 10글자까지 가능합니다.")
    private final String title;

    @NotNull
    @Size(min = 1, max = 50, message = "최소 1글자, 최대 50글자까지 가능합니다.")
    private final String contents;

    public PlanRequestDto(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }
}
