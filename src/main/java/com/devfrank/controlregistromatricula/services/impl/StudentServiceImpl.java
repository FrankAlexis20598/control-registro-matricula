package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.Student;
import com.devfrank.controlregistromatricula.models.StudentDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.StudentRepository;
import com.devfrank.controlregistromatricula.services.IStudentService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends BaseCrudServiceImpl<Student, StudentDTO, Integer> implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    protected BaseCrudRepository<Student, Integer> getRepository() {
        return studentRepository;
    }

    @Override
    protected GenericMapper<Student, StudentDTO> getMapper() {
        return studentMapper;
    }
}
