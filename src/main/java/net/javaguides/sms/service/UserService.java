package net.javaguides.sms.service;

import net.javaguides.sms.Dto.UserDto;
import net.javaguides.sms.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
    }

