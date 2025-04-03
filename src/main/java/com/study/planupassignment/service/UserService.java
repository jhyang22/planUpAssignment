package com.study.planupassignment.service;


import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;

public interface UserService {


    UserResponseDto createUser(UserCreateRequestDto dto);
}
