package com.study.planupassignment.service;

import com.study.planupassignment.dto.request.PlanCreateRequestDto;
import com.study.planupassignment.dto.request.PlanRequestDto;
import com.study.planupassignment.dto.response.PlanCreateRespondDto;
import com.study.planupassignment.dto.response.PlanResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlanService {
    PlanCreateRespondDto createPlan(PlanCreateRequestDto dto);

    @Transactional(readOnly = true)
    List<PlanResponseDto> findAllPlans();

    @Transactional(readOnly = true)
    PlanResponseDto findPlanById(Long id);

    @Transactional
    PlanResponseDto updatePlan(Long id, PlanRequestDto dto);

    void deletePlan(Long id);
}
