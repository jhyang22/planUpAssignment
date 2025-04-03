package com.study.planupassignment.controller;


import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;
import com.study.planupassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateRequestDto dto) {

        UserResponseDto saveUser = userService.createUser(dto);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

}
