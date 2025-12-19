package com.devfrank.controlregistromatricula.services.impl;

import com.devfrank.controlregistromatricula.entities.Course;
import com.devfrank.controlregistromatricula.entities.Enrollment;
import com.devfrank.controlregistromatricula.entities.EnrollmentDetail;
import com.devfrank.controlregistromatricula.models.EnrollmentDTO;
import com.devfrank.controlregistromatricula.models.EnrollmentDetailDTO;
import com.devfrank.controlregistromatricula.repositories.BaseCrudRepository;
import com.devfrank.controlregistromatricula.repositories.EnrollmentRepository;
import com.devfrank.controlregistromatricula.services.IEnrollmentService;
import com.devfrank.controlregistromatricula.util.mappers.GenericMapper;
import com.devfrank.controlregistromatricula.util.mappers.impl.EnrollmentMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    protected GenericMapper<Enrollment, EnrollmentDTO, Integer> getMapper() {
        return enrollmentMapper;
    }

    @Transactional
    @Override
    public EnrollmentDTO update(Integer id, EnrollmentDTO dto) throws Exception {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment not found"));

        enrollment.setStatus(dto.getStatus());

        Map<Integer, EnrollmentDetail> existing = enrollment.getEnrollmentDetails()
                .stream()
                .collect(Collectors.toMap(EnrollmentDetail::getId, e -> e));

        List<EnrollmentDetail> updateDetails = new ArrayList<>();

        for (EnrollmentDetailDTO d : dto.getEnrollmentDetails()) {
            if (d.getId() != null) {
                EnrollmentDetail detail = existing.get(d.getId());

                if (detail == null) {
                    throw new IllegalArgumentException("El detalle con id=" + d.getId() + " no forma parte de la matrícula");
                }

                Course course = new Course();
                course.setId(d.getCourse().getId());

                detail.setClassroom(d.getClassroom());
                detail.setCourse(course);

                updateDetails.add(detail);

            } else {
                EnrollmentDetail detail = new EnrollmentDetail();

                Course course = new Course();
                course.setId(d.getCourse().getId());

                detail.setClassroom(d.getClassroom());
                detail.setCourse(course);
                detail.setEnrollment(enrollment);

                updateDetails.add(detail);
            }
        }

        enrollment.getEnrollmentDetails().clear();
        enrollment.getEnrollmentDetails().addAll(updateDetails);

        enrollmentRepository.flush();

        return enrollmentMapper.toDto(enrollment);
    }

    @Override
    public Map<String, List<String>> getCoursesWithStudents() throws Exception {

        List<Enrollment> enrollment = enrollmentRepository.findAll();

        return enrollment.stream()
                .flatMap(e -> e.getEnrollmentDetails().stream()
                        .map(det -> Map.entry(
                                det.getCourse().getName(),
                                e.getStudent().getNames() + " " + e.getStudent().getSurnames())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
