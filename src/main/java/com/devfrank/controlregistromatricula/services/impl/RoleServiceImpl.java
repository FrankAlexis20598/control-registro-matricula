package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.Role;
import com.devfrank.controlregistromatricula.models.RoleDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.RoleRepository;
import com.devfrank.controlregistromatricula.services.IRoleService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseCrudServiceImpl<Role, RoleDTO, Integer> implements IRoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    protected BaseCrudRepository<Role, Integer> getRepository() {
        return roleRepository;
    }

    @Override
    protected GenericMapper<Role, RoleDTO, Integer> getMapper() {
        return roleMapper;
    }
}
