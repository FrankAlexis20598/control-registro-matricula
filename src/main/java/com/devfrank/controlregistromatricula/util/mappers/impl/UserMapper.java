package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.Role;
import com.devfrank.controlregistromatricula.entities.User;
import com.devfrank.controlregistromatricula.models.RoleDTO;
import com.devfrank.controlregistromatricula.models.UserDTO;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper implements GenericMapper<User, UserDTO, Integer> {

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        Role role = new Role();
        role.setId(dto.getRole().getId());

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(role);
        user.setActive(dto.isActive());
        return user;
    }

    @Override
    public User toEntity(UserDTO dto, Integer id) {
        User user = toEntity(dto);
        user.setId(id);
        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        if (entity == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(entity.getRole().getId());

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRole(roleDTO);
        dto.setActive(entity.getActive());
        return dto;
    }
}
