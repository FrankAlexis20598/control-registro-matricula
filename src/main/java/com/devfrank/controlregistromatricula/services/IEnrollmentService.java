package com.devfrank.controlregistromatricula.services;

import com.devfrank.controlregistromatricula.models.EnrollmentDTO;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends IBaseCrudService<EnrollmentDTO, Integer> {

    Map<String, List<String>> getCoursesWithStudents() throws Exception;
}
