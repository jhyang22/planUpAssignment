package com.study.planupassignment.dto.response;

import com.study.planupassignment.entitiy.Plan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlanCreateRespondDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final LocalDateTime createdAt;

    public PlanCreateRespondDto(Plan plan) {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.contents = plan.getContents();
        this.createdAt = plan.getCreatedAt();
    }

    public static PlanCreateRespondDto toDto(Plan plan) {
        return new PlanCreateRespondDto(plan);
    }
}
