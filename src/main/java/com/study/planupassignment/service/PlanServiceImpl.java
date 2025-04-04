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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    // 일정 생성 로직
    @Override
    public PlanCreateRespondDto createPlan(PlanCreateRequestDto dto) {

        User findUser = userRepository.findByUserNameOrElseThrow(dto.getUserName());

        Plan plan = new Plan(dto.getTitle(), dto.getContents());
        plan.setUser(findUser);

        Plan savedPlan = planRepository.save(plan);

        return PlanCreateRespondDto.toDto(savedPlan);
    }

    // 전체 일정 조회 로직
    @Transactional(readOnly = true)
    @Override
    public List<PlanResponseDto> findAllPlans() {

        List<Plan> allPlans = planRepository.findAll();

        return allPlans.stream().map(PlanResponseDto::toDto).toList();
    }

    // 특정 일정 조회 로직
    @Transactional(readOnly = true)
    @Override
    public PlanResponseDto findPlanById(Long id) {

        Plan findPlan = planRepository.findPlanByIdOrElseThrow(id);

        return PlanResponseDto.toDto(findPlan);
    }

    // 일정 수정 로직
    @Transactional
    @Override
    public PlanResponseDto updatePlan(Long id, PlanRequestDto dto) {

        Plan findPlan = planRepository.findPlanByIdOrElseThrow(id);

        findPlan.updatePlan(dto.getTitle(), dto.getContents());

        Plan updatedPlan = planRepository.save(findPlan);

        return PlanResponseDto.toDto(updatedPlan);
    }

    // 일정 삭제
    public void deletePlan(Long id) {
        Plan findPlan = planRepository.findPlanByIdOrElseThrow(id);

        planRepository.delete(findPlan);
    }
}
