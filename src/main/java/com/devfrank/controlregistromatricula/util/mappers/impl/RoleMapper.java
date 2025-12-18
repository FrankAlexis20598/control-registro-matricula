package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.Role;
import com.devfrank.controlregistromatricula.models.RoleDTO;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements GenericMapper<Role, RoleDTO, Integer> {

    @Override
    public Role toEntity(RoleDTO dto) {
        if (dto == null) {
            return null;
        }
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setActive(dto.isActive());
        return entity;
    }

    @Override
    public Role toEntity(RoleDTO dto, Integer id) {
        Role role = toEntity(dto);
        role.setId(id);
        return role;
    }

    @Override
    public RoleDTO toDto(Role entity) {
        if (entity == null) {
            return null;
        }
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setActive(entity.getActive());
        return dto;
    }
}
