package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.services.IBaseCrudService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;

import java.util.List;

public abstract class BaseCrudServiceImpl<E, D, ID> implements IBaseCrudService<D, ID> {

    protected abstract BaseCrudRepository<E, ID> getRepository();

    protected abstract GenericMapper<E, D, ID> getMapper();

    @Override
    public List<D> findAll() throws Exception {
        return getMapper().toDtoList(getRepository().findAll());
    }

    @Override
    public D create(D dto) throws Exception {
        E entity = getMapper().toEntity(dto);
        E savedEntity = getRepository().save(entity);
        return getMapper().toDto(savedEntity);
    }

    @Override
    public D findById(ID id) throws Exception {
        return getRepository().findById(id).map(getMapper()::toDto).orElse(null);
    }

    @Override
    public D update(ID id, D dto) throws Exception {
        getRepository().findById(id).orElseThrow(Exception::new);
        E entity = getMapper().toEntity(dto, id);
        E updatedEntity = getRepository().save(entity);
        return getMapper().toDto(updatedEntity);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
