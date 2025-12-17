package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.Enrollment;
import com.devfrank.controlregistromatricula.models.EnrollmentDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.EnrollmentRepository;
import com.devfrank.controlregistromatricula.services.IEnrollmentService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.EnrollmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends BaseCrudServiceImpl<Enrollment, EnrollmentDTO, Integer> implements IEnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    protected BaseCrudRepository<Enrollment, Integer> getRepository() {
        return enrollmentRepository;
    }

    @Override
    protected GenericMapper<Enrollment, EnrollmentDTO> getMapper() {
        return enrollmentMapper;
    }
}
