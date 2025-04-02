package com.study.planupassignment.service;

import com.study.planupassignment.dto.PlanCreateRequestDto;
import com.study.planupassignment.dto.PlanCreateRespondDto;
import com.study.planupassignment.dto.PlanResponseDto;
import com.study.planupassignment.entitiy.Plan;
import com.study.planupassignment.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public PlanCreateRespondDto createPlan(PlanCreateRequestDto dto) {

        Plan plan = new Plan(dto.getUserName(), dto.getTitle(), dto.getContents());

        Plan savedPlan = planRepository.save(plan);

        return new PlanCreateRespondDto(savedPlan.getId(), savedPlan.getTitle(), savedPlan.getContents(), savedPlan.getCreatedAt());
    }

    @Transactional(readOnly = true)
    public List<PlanResponseDto> findAllPlans() {

        List<Plan> allPlans = planRepository.findAll();

        return allPlans.stream().map(PlanResponseDto::toDto).toList();
    }
}
