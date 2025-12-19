package com.devfrank.controlregistromatricula.controllers;

import com.devfrank.controlregistromatricula.models.EnrollmentDTO;
import com.devfrank.controlregistromatricula.services.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService enrollmentService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentController.class);

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() throws Exception {
        return ResponseEntity.ok(enrollmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(enrollmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@Valid @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        LOGGER.info("Creando el enrollment: {}", enrollmentDTO);
        return ResponseEntity.ok(enrollmentService.create(enrollmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Integer id, @Valid @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        return ResponseEntity.ok(enrollmentService.update(id, enrollmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/courses-with-students")
    public ResponseEntity<Map<String, List<String>>> getCoursesWithStudents() throws Exception {
        return ResponseEntity.ok(enrollmentService.getCoursesWithStudents());
    }
}
