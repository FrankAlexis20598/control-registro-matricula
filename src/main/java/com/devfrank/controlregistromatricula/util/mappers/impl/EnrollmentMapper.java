package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.Enrollment;
import com.devfrank.controlregistromatricula.entities.Student;
import com.devfrank.controlregistromatricula.models.EnrollmentDTO;
import com.devfrank.controlregistromatricula.models.StudentDTO;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper implements GenericMapper<Enrollment, EnrollmentDTO> {

    private final EnrollmentDetailMapper enrollmentDetailMapper;

    @Override
    public Enrollment toEntity(EnrollmentDTO dto) {
        if (dto == null) {
            return null;
        }
        Enrollment enrollment = new Enrollment();
        Student student = new Student();
        student.setId(dto.getStudent().getId());

        enrollment.setId(dto.getId());
        enrollment.setEnrollmentDate(dto.getDate());
        enrollment.setStudent(student);
        enrollment.setEnrollmentDetails(enrollmentDetailMapper.toEntityList(dto.getEnrollmentDetails()));
        enrollment.setStatus(dto.getStatus());
        return enrollment;
    }

    @Override
    public EnrollmentDTO toDto(Enrollment entity) {
        if (entity == null) {
            return null;
        }
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(entity.getStudent().getId());

        enrollmentDTO.setId(entity.getId());
        enrollmentDTO.setDate(entity.getEnrollmentDate());
        enrollmentDTO.setStudent(studentDTO);
        enrollmentDTO.setEnrollmentDetails(enrollmentDetailMapper.toDtoList(entity.getEnrollmentDetails()));
        enrollmentDTO.setStatus(entity.getStatus());
        return enrollmentDTO;
    }
}
