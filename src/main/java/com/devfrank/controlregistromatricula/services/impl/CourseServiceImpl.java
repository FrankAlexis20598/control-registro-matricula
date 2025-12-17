package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.Course;
import com.devfrank.controlregistromatricula.models.CourseDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.CourseRepository;
import com.devfrank.controlregistromatricula.services.ICourseService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends BaseCrudServiceImpl<Course, CourseDTO, Integer> implements ICourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    protected BaseCrudRepository<Course, Integer> getRepository() {
        return courseRepository;
    }

    @Override
    protected GenericMapper<Course, CourseDTO> getMapper() {
        return courseMapper;
    }
}
