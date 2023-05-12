package com.example.Dosify.service.impl;

import com.example.Dosify.dto.RequestDTO.UserRequestDto;
import com.example.Dosify.dto.ResponseDTO.UserResponseDto;
import com.example.Dosify.model.User;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        // convert request dto - entity
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setAge(userRequestDto.getAge());
        user.setEmailId(userRequestDto.getEmailId());
        user.setGender(userRequestDto.getGender());
        user.setMobNo(userRequestDto.getMobNo());

        // save the object in db
        User savedUser = userRepository.save(user);

        //entity -> response dto
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(savedUser.getName());
        userResponseDto.setMessage("Congrats! You have registered on Dosify");
        return userResponseDto;

    }
}
