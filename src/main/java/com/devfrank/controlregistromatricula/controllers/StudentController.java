package com.devfrank.controlregistromatricula.controllers;

import com.devfrank.controlregistromatricula.models.StudentDTO;
import com.devfrank.controlregistromatricula.services.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() throws Exception {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO studentDTO) throws Exception {
        return ResponseEntity.ok(studentService.create(studentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) throws Exception {
        return ResponseEntity.ok(studentService.update(id, studentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order-by-age")
    public ResponseEntity<List<StudentDTO>> findAllOrderByAgeDesc() throws Exception {
        return ResponseEntity.ok(studentService.findAllOrderByAgeDesc());
    }
}
