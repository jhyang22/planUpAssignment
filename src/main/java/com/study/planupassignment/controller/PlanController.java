package com.study.planupassignment.controller;

import com.study.planupassignment.dto.PlanCreateRequestDto;
import com.study.planupassignment.dto.PlanCreateRespondDto;
import com.study.planupassignment.dto.PlanResponseDto;
import com.study.planupassignment.service.PlanService;
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
    public ResponseEntity<PlanCreateRespondDto> createPlan(@RequestBody PlanCreateRequestDto dto) {

        PlanCreateRespondDto createdPlan = planService.createPlan(dto);

        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDto>> findAllPlans() {
        List<PlanResponseDto> allPlans = planService.findAllPlans();

        return new ResponseEntity<>(allPlans, HttpStatus.OK);
    }
}
