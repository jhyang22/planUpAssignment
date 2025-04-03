package com.study.planupassignment.service;

import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;
import com.study.planupassignment.entitiy.User;
import com.study.planupassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserCreateRequestDto dto) {

        User createUser = new User(dto.getUserName(), dto.getEmail());

        User saveUser = userRepository.save(createUser);

        return new UserResponseDto(saveUser.getId(), saveUser.getUserName(), saveUser.getEmail());
    }

}
