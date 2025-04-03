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

    @Override
    public UserResponseDto createUser(UserCreateRequestDto dto) {

        User createUser = new User(dto.getUserName(),dto.getPassword(), dto.getEmail());

        User saveUser = userRepository.save(createUser);

        return new UserResponseDto(saveUser);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserResponseDto> findAllUser() {

        List<User> findAllUsers = userRepository.findAll();

        return findAllUsers.stream().map(UserResponseDto::toDto).toList();

    }

    @Transactional(readOnly = true)
    @Override
    public UserResponseDto findUserById(Long id) {

        User findUserById = userRepository.findUserByIdOrElseThrow(id);

        return new UserResponseDto(findUserById);
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto dto) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        findUser.updateUser(dto.getEmail());
        User saveUser = userRepository.save(findUser);

        return new UserResponseDto(saveUser);
    }

    @Override
    public void deleteUser(Long id) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    @Override
    public boolean login(LoginRequestDto dto) {

        User findUser = userRepository.findUserByEmailOrElseThrow(dto);

        if(findUser.getPassword().equals(dto.getPassword())) {
            return true;
        }
        return false;
    }


}
