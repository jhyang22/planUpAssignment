package com.study.planupassignment.service;

import com.study.planupassignment.dto.request.PlanCreateRequestDto;
import com.study.planupassignment.dto.request.PlanRequestDto;
import com.study.planupassignment.dto.response.PlanCreateRespondDto;
import com.study.planupassignment.dto.response.PlanResponseDto;

import java.util.List;

public interface PlanService {
    PlanCreateRespondDto createPlan(PlanCreateRequestDto dto);

    List<PlanResponseDto> findAllPlans();

    PlanResponseDto findPlanById(Long id);

    PlanResponseDto updatePlan(Long id, PlanRequestDto dto);

    void deletePlan(Long id);
}
