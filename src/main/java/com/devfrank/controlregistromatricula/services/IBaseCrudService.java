package com.devfrank.controlregistromatricula.services;

import java.util.List;

public interface IBaseCrudService<D, ID> {

    List<D> findAll() throws Exception;

    D create(D dto) throws Exception;

    D findById(ID id) throws Exception;

    D update(ID id, D dto) throws Exception;

    void delete(ID id) throws Exception;
}
