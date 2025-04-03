package com.study.planupassignment.controller;

import com.study.planupassignment.dto.request.PlanCreateRequestDto;
import com.study.planupassignment.dto.request.PlanRequestDto;
import com.study.planupassignment.dto.response.PlanCreateRespondDto;
import com.study.planupassignment.dto.response.PlanResponseDto;
import com.study.planupassignment.service.PlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public ResponseEntity<PlanCreateRespondDto> createPlan(@Valid @RequestBody PlanCreateRequestDto dto) {

        PlanCreateRespondDto createdPlan = planService.createPlan(dto);

        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDto>> findAllPlans() {
        List<PlanResponseDto> allPlans = planService.findAllPlans();

        return new ResponseEntity<>(allPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponseDto> findPlanById(@PathVariable Long id) {

        PlanResponseDto findPlanById = planService.findPlanById(id);

        return new ResponseEntity<>(findPlanById, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlanResponseDto> updatePlan(
            @PathVariable Long id,
            @Valid @RequestBody PlanRequestDto dto
            ) {

        PlanResponseDto updatedPlan = planService.updatePlan(id, dto);

        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {

        planService.deletePlan(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
