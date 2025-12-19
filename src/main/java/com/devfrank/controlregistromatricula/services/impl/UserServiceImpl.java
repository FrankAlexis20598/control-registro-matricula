package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.AppUser;
import com.devfrank.controlregistromatricula.models.UserDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.UserRepository;
import com.devfrank.controlregistromatricula.services.IUserService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseCrudServiceImpl<AppUser, UserDTO, Integer> implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected BaseCrudRepository<AppUser, Integer> getRepository() {
        return userRepository;
    }

    @Override
    protected GenericMapper<AppUser, UserDTO, Integer> getMapper() {
        return userMapper;
    }

    @Override
    public UserDTO create(UserDTO dto) throws Exception {
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encryptedPassword);
        return super.create(dto);
    }
}
