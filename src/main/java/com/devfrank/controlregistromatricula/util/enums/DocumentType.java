package com.devfrank.controlregistromatricula.util.enums;

import lombok.Getter;

@Getter
public enum DocumentType {
    DNI("01", "DNI", 8),
    CARNET_EXT("04", "CARNET_EXT", 12);

    private final String code;
    private final String name;
    private final int length;

    DocumentType(String code, String name, int length) {
        this.code = code;
        this.name = name;
        this.length = length;
    }

    public static DocumentType fromName(String name) {
        for (DocumentType type : DocumentType.values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }

    public static DocumentType fromCode(String code) {
        for (DocumentType type : DocumentType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }
}
