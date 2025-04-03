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

    public PlanResponseDto(Long id, String userName, String title, String contents, LocalDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.updatedAt = updatedAt;
    }

    public static PlanResponseDto toDto(Plan plan) {

        return  new PlanResponseDto(plan.getId(), plan.getUser().getUserName(), plan.getTitle(), plan.getContents(), plan.getUpdatedAt());
    }
}
