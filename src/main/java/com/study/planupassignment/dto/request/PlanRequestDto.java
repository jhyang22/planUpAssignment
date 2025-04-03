package com.study.planupassignment.dto.request;

import lombok.Getter;

@Getter
public class PlanRequestDto {

    private final String userName;

    private final String title;

    private final String contents;

    public PlanRequestDto(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }
}
