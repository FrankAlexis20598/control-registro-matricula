package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.User;
import com.devfrank.controlregistromatricula.models.UserDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.UserRepository;
import com.devfrank.controlregistromatricula.services.IUserService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseCrudServiceImpl<User, UserDTO, Integer> implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    protected BaseCrudRepository<User, Integer> getRepository() {
        return userRepository;
    }

    @Override
    protected GenericMapper<User, UserDTO, Integer> getMapper() {
        return userMapper;
    }
}
