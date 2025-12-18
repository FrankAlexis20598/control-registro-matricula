package com.devfrank.controlregistromatricula.util.mappers.impl;

import com.devfrank.controlregistromatricula.entities.Course;
import com.devfrank.controlregistromatricula.entities.Enrollment;
import com.devfrank.controlregistromatricula.entities.EnrollmentDetail;
import com.devfrank.controlregistromatricula.models.CourseDTO;
import com.devfrank.controlregistromatricula.models.EnrollmentDetailDTO;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentDetailMapper implements GenericMapper<EnrollmentDetail, EnrollmentDetailDTO, Integer> {

    @Override
    public EnrollmentDetail toEntity(EnrollmentDetailDTO dto) {
        if (dto == null) {
            return null;
        }
        EnrollmentDetail enrollmentDetail = new EnrollmentDetail();
        Enrollment enrollment = new Enrollment();
        Course course = new Course();

        enrollment.setId(dto.getEnrollment().getId());
        course.setId(dto.getCourse().getId());

        enrollmentDetail.setId(dto.getId());
        enrollmentDetail.setEnrollment(enrollment);
        enrollmentDetail.setCourse(course);
        enrollmentDetail.setClassroom(dto.getClassroom());
        return enrollmentDetail;
    }

    @Override
    public EnrollmentDetail toEntity(EnrollmentDetailDTO dto, Integer id) {
        EnrollmentDetail enrollmentDetail = toEntity(dto);
        enrollmentDetail.setId(id);
        return enrollmentDetail;
    }

    @Override
    public EnrollmentDetailDTO toDto(EnrollmentDetail entity) {
        if (entity == null) {
            return null;
        }
        EnrollmentDetailDTO enrollmentDetailDTO = new EnrollmentDetailDTO();
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(entity.getCourse().getId());

        enrollmentDetailDTO.setId(entity.getId());
        enrollmentDetailDTO.setCourse(courseDTO);
        enrollmentDetailDTO.setClassroom(entity.getClassroom());
        return enrollmentDetailDTO;
    }
}
