package com.devfrank.controlregistromatricula.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDetailDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5531333393124026669L;

    private Integer id;

    @JsonBackReference
    private EnrollmentDTO enrollment;

    @NotNull
    @JsonIncludeProperties(value = {"id"})
    private CourseDTO course;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String classroom;
}
