package com.study.planupassignment.service;


import com.study.planupassignment.dto.request.LoginRequestDto;
import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.request.UserUpdateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {


    UserResponseDto createUser(UserCreateRequestDto dto);


    List<UserResponseDto> findAllUser();

    UserResponseDto findUserById(Long id);

    UserResponseDto updateUser(Long id, UserUpdateRequestDto dto);

    void deleteUser(Long id);

    boolean login(LoginRequestDto dto);
}
