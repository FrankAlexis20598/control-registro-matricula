package com.devfrank.controlregistromatricula.exceptions.response;

import java.time.LocalDateTime;

public record CustomErrorResponse(LocalDateTime timestamp, String message, String uri) {
}
