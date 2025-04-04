package com.study.planupassignment.service;

import com.study.planupassignment.dto.request.LoginRequestDto;
import com.study.planupassignment.dto.request.UserCreateRequestDto;
import com.study.planupassignment.dto.request.UserUpdateRequestDto;
import com.study.planupassignment.dto.response.UserResponseDto;
import com.study.planupassignment.entitiy.User;
import com.study.planupassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    // 유저 생성 로직
    @Override
    public UserResponseDto createUser(UserCreateRequestDto dto) {

        User createUser = new User(dto.getUserName(),dto.getPassword(), dto.getEmail());

        User saveUser = userRepository.save(createUser);

        return new UserResponseDto(saveUser);
    }

    // 전체 유저 조회 로직
    @Transactional(readOnly = true)
    @Override
    public List<UserResponseDto> findAllUser() {

        List<User> findAllUsers = userRepository.findAll();

        return findAllUsers.stream().map(UserResponseDto::toDto).toList();

    }

    // 특정 유저 조회 로직
    @Transactional(readOnly = true)
    @Override
    public UserResponseDto findUserById(Long id) {

        User findUserById = userRepository.findUserByIdOrElseThrow(id);

        return new UserResponseDto(findUserById);
    }

    // 유저 수정 로직
    @Transactional
    @Override
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto dto) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        findUser.updateUser(dto.getEmail());
        User saveUser = userRepository.save(findUser);

        return new UserResponseDto(saveUser);
    }

    // 유저 삭제 로직
    @Override
    public void deleteUser(Long id) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    // 로그인 로직
    @Override
    public void login(LoginRequestDto dto) {

        User findUser = userRepository.findUserByEmailOrElseThrow(dto);

        findUser.isPassword(dto.getPassword());

    }

}
