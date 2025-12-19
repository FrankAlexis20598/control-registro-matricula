package com.devfrank.controlregistromatricula.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 365499272271705693L;

    private Integer id;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @NotNull
    @JsonIncludeProperties(value = {"id"})
    private StudentDTO student;

    @NotNull
    @JsonIncludeProperties(value = {"id"})
    private UserDTO user;

    @NotNull
    @NotEmpty
    @JsonManagedReference
    private List<EnrollmentDetailDTO> enrollmentDetails;

    @NotNull
    private Boolean status;
}
