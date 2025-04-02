package com.study.planupassignment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlanCreateRespondDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final LocalDateTime createdAt;

    public PlanCreateRespondDto(Long id, String title, String contents, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
    }
}
