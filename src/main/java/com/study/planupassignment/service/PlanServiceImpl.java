package com.study.planupassignment.service;

import com.study.planupassignment.dto.request.PlanCreateRequestDto;
import com.study.planupassignment.dto.request.PlanRequestDto;
import com.study.planupassignment.dto.response.PlanCreateRespondDto;
import com.study.planupassignment.dto.response.PlanResponseDto;
import com.study.planupassignment.entitiy.Plan;
import com.study.planupassignment.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

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

    public PlanResponseDto findPlanById(Long id) {

        Plan planByIdOrElseThrow = planRepository.findPlanByIdOrElseThrow(id);

        return new PlanResponseDto(planByIdOrElseThrow.getId(), planByIdOrElseThrow.getUserName(), planByIdOrElseThrow.getTitle(), planByIdOrElseThrow.getContents(), planByIdOrElseThrow.getUpdatedAt());
    }

    @Transactional
    public PlanResponseDto updatePlan(Long id, PlanRequestDto dto) {

        Plan planByIdOrElseThrow = planRepository.findPlanByIdOrElseThrow(id);

        planByIdOrElseThrow.updatePlan(dto.getUserName(), dto.getTitle(), dto.getContents());

        Plan updatedPlan = planRepository.save(planByIdOrElseThrow);

        return new PlanResponseDto(updatedPlan.getId(), updatedPlan.getUserName(), updatedPlan.getTitle(), updatedPlan.getContents(), updatedPlan.getUpdatedAt());
    }

    public void deletePlan(Long id) {
        Plan planByIdOrElseThrow = planRepository.findPlanByIdOrElseThrow(id);

        planRepository.delete(planByIdOrElseThrow);
    }
}
