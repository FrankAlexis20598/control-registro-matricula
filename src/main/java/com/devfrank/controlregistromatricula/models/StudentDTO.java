package com.devfrank.controlregistromatricula.models;

import com.devfrank.controlregistromatricula.util.enums.DocumentType;
import com.devfrank.controlregistromatricula.util.validators.ValueOfEnum;
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
public class StudentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3929879747259544683L;

    private Integer id;

    @NotBlank
    @Size(min = 3, max = 150)
    private String names;

    @NotBlank
    @Size(min = 3, max = 150)
    private String surnames;

    @NotBlank
    @ValueOfEnum(enumClass = DocumentType.class)
    private String documentType;

    @NotBlank
    @Size(min = 8, max = 12)
    private String documentNumber;

    @NotNull
    private Integer age;
}
