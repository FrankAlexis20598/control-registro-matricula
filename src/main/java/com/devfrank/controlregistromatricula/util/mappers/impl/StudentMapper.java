package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.Student;
import com.devfrank.controlregistromatricula.models.StudentDTO;
import com.devfrank.controlregistromatricula.util.enums.DocumentType;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements GenericMapper<Student, StudentDTO, Integer> {

    @Override
    public Student toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }
        Student student = new Student();
        student.setId(dto.getId());
        student.setNames(dto.getNames());
        student.setSurnames(dto.getSurnames());
        student.setDocumentType(DocumentType.fromName(dto.getDocumentType()).getCode());
        student.setDocumentNumber(dto.getDocumentNumber());
        student.setAge(dto.getAge());
        return student;
    }

    @Override
    public Student toEntity(StudentDTO dto, Integer id) {
        Student student = toEntity(dto);
        student.setId(id);
        return student;
    }

    @Override
    public StudentDTO toDto(Student entity) {
        if (entity == null) {
            return null;
        }
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setNames(entity.getNames());
        dto.setSurnames(entity.getSurnames());
        dto.setDocumentType(DocumentType.fromCode(entity.getDocumentType()).getName());
        dto.setDocumentNumber(entity.getDocumentNumber());
        dto.setAge(entity.getAge());
        return dto;
    }
}
