package com.study.planupassignment.dto.response;

import com.study.planupassignment.entitiy.Plan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlanResponseDto {

    private final Long id;

    private final String userName;

    private final String title;

    private final String contents;

    private final LocalDateTime updatedAt;

    public PlanResponseDto(Plan plan) {
        this.id = plan.getId();
        this.userName = plan.getUser().getUserName();
        this.title = plan.getTitle();
        this.contents = plan.getContents();
        this.updatedAt = plan.getUpdatedAt();
    }

    public static PlanResponseDto toDto(Plan plan) {
        return  new PlanResponseDto(plan);
    }
}
