package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.AppUser;
import com.devfrank.controlregistromatricula.entities.Role;
import com.devfrank.controlregistromatricula.models.RoleDTO;
import com.devfrank.controlregistromatricula.models.UserDTO;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements GenericMapper<AppUser, UserDTO, Integer> {

    @Override
    public AppUser toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        AppUser user = new AppUser();
        Role role = new Role();
        role.setId(dto.getRole().getId());

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(role);
        user.setActive(dto.isActive());
        return user;
    }

    @Override
    public AppUser toEntity(UserDTO dto, Integer id) {
        AppUser user = toEntity(dto);
        user.setId(id);
        return user;
    }

    @Override
    public UserDTO toDto(AppUser entity) {
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
