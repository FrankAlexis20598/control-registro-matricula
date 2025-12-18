package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.Course;
import com.devfrank.controlregistromatricula.models.CourseDTO;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements GenericMapper<Course, CourseDTO, Integer> {

    @Override
    public Course toEntity(CourseDTO dto) {
        if (dto == null) {
            return null;
        }
        Course course = new Course();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setAcronym(dto.getAcronym());
        course.setStatus(dto.isStatus());
        return course;
    }

    @Override
    public Course toEntity(CourseDTO dto, Integer id) {
        Course course = toEntity(dto);
        course.setId(id);
        return course;
    }

    @Override
    public CourseDTO toDto(Course entity) {
        if (entity == null) {
            return null;
        }
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAcronym(entity.getAcronym());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
