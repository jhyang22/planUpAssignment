package com.study.planupassignment.service;

import com.study.planupassignment.dto.request.PlanCreateRequestDto;
import com.study.planupassignment.dto.request.PlanRequestDto;
import com.study.planupassignment.dto.response.PlanCreateRespondDto;
import com.study.planupassignment.dto.response.PlanResponseDto;
import com.study.planupassignment.entitiy.Plan;
import com.study.planupassignment.entitiy.User;
import com.study.planupassignment.repository.PlanRepository;
import com.study.planupassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public PlanCreateRespondDto createPlan(PlanCreateRequestDto dto) {

        User findByUserNameOrElseThrow = userRepository.findByUserNameOrElseThrow(dto.getUserName());

        Plan plan = new Plan(dto.getTitle(), dto.getContents());
        plan.setUser(findByUserNameOrElseThrow);

        Plan savedPlan = planRepository.save(plan);

        return new PlanCreateRespondDto(savedPlan.getId(), savedPlan.getTitle(), savedPlan.getContents(), savedPlan.getCreatedAt());
    }


    public List<PlanResponseDto> findAllPlans() {

        List<Plan> allPlans = planRepository.findAll();

        return allPlans.stream().map(PlanResponseDto::toDto).toList();
    }

    public PlanResponseDto findPlanById(Long id) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        Plan planByIdOrElseThrow = planRepository.findPlanByIdOrElseThrow(id);

        return new PlanResponseDto(planByIdOrElseThrow.getId(), findUser.getUserName(), planByIdOrElseThrow.getTitle(), planByIdOrElseThrow.getContents(), planByIdOrElseThrow.getUpdatedAt());
    }

    public PlanResponseDto updatePlan(Long id, PlanRequestDto dto) {

        Plan planByIdOrElseThrow = planRepository.findPlanByIdOrElseThrow(id);

        planByIdOrElseThrow.updatePlan(dto.getTitle(), dto.getContents());

        Plan updatedPlan = planRepository.save(planByIdOrElseThrow);

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        return new PlanResponseDto(updatedPlan.getId(), findUser.getUserName(), updatedPlan.getTitle(), updatedPlan.getContents(), updatedPlan.getUpdatedAt());
    }

    public void deletePlan(Long id) {
        Plan planByIdOrElseThrow = planRepository.findPlanByIdOrElseThrow(id);

        planRepository.delete(planByIdOrElseThrow);
    }
}
