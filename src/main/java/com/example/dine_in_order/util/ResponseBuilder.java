package com.example.dine_in_order.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {
    /**
     * Helps creating the success response with
     * data including the HttpStatus code,message
     * and  data itself
     * @param <T> The type of data being returned.
     * @param status The HTTP status of the response.
     * @param message A descriptive message regarding the response.
     * @param data The data to be included in the response.
     * @return ResponseEntity containing the structured response.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> sucess(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status)
                .body(structure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> ok(T data, String message) {
        return sucess(HttpStatus.OK, message, data);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> create(T data, String message) {
        return sucess(HttpStatus.CREATED, message, data);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> sucess(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status)
                .headers(headers)
                .body(structure);
    }
    /**
     * Creates an error response with the given HTTP status and message.
     *
     * @param status The HTTP status of the error response.
     * @param message A descriptive error message.
     * @return ResponseEntity containing the structured error response.
     */
    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status)
                .body(error);
    }

    public static ResponseEntity<SimpleErrorResponse> notFound(String message) {
        return error(HttpStatus.NOT_FOUND, message);
    }

    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.FieldError> errors) {
        FieldErrorResponse error = FieldErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .errors(errors)
                .build();

        return ResponseEntity.status(status)
                .body(error);
    }
}
