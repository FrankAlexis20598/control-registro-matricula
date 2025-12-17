package com.devfrank.controlregistromatricula.util;

public enum DocumentType {
    DNI("01", "DNI", 8),
    CARNET_EXT("04", "Carnet de Extranjería", 12);

    DocumentType(String code, String description, int length) {
    }
}
