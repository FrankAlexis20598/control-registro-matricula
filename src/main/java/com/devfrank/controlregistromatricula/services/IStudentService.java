package com.devfrank.controlregistromatricula.services;

import com.devfrank.controlregistromatricula.models.StudentDTO;

import java.util.List;

public interface IStudentService extends IBaseCrudService<StudentDTO, Integer> {

    List<StudentDTO> findAllOrderByAgeDesc() throws Exception;
}
