package com.study.planupassignment.controller;


import com.study.planupassignment.dto.request.LoginRequestDto;
import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.request.UserUpdateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;
import com.study.planupassignment.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequestDto dto,
            HttpServletRequest request
    ) {
        userService.login(dto);

        HttpSession session = request.getSession();
        session.setAttribute("secretKey", dto.getEmail());

        return new ResponseEntity<>("로그인에 성공하였습니다", HttpStatus.OK);
    }

    // 유저 생성
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserCreateRequestDto dto) {

        UserResponseDto saveUser = userService.createUser(dto);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    // 전체 유저 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser() {

        List<UserResponseDto> allUser = userService.findAllUser();

        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    // 특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id) {

        UserResponseDto findUserById = userService.findUserById(id);

        return new ResponseEntity<>(findUserById, HttpStatus.OK);
    }

    // 유저 수정
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequestDto dto
    ) {

        UserResponseDto updateUser = userService.updateUser(id, dto);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
