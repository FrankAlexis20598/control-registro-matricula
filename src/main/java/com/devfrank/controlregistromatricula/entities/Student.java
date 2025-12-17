package com.devfrank.controlregistromatricula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 150, nullable = false)
    private String names;

    @Column(length = 150, nullable = false)
    private String surnames;

    @Column(length = 2, nullable = false)
    private String documentType;

    @Column(length = 12, nullable = false, unique = true)
    private String documentNumber;

    @Column(nullable = false)
    private Integer age;

}
