package com.devfrank.controlregistromatricula.models;

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
public class RoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 977868503335511352L;

    private Integer id;

    @NotBlank
    @Size(min = 3, max = 10)
    private String name;

    @NotNull
    private boolean active;
}
