package com.university.studentapi.exception;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, String message, int statusCode) {
}
