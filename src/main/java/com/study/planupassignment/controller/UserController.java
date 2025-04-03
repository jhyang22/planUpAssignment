package com.study.planupassignment.controller;


import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.request.UserUpdateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;
import com.study.planupassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser() {

        List<UserResponseDto> allUser = userService.findAllUser();

        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id) {

        UserResponseDto findUserById = userService.findUserById(id);

        return new ResponseEntity<>(findUserById, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserUpdateRequestDto dto
            ) {

        UserResponseDto updateUser = userService.updateUser(id, dto);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
