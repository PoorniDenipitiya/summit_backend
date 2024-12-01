package com.foodie.psb_user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected <T> ResponseEntity<ApiResponse<T>> createSuccessResponse(T data, String message) {
        return new ResponseEntity<>(new ApiResponse<>(true, message, data), HttpStatus.OK);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createCreatedResponse(T data, String message) {
        return new ResponseEntity<>(new ApiResponse<>(true, message, data), HttpStatus.CREATED);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createNotFoundResponse(String message) {
        return new ResponseEntity<>(new ApiResponse<>(false, message, null), HttpStatus.NOT_FOUND);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createErrorResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(new ApiResponse<>(false, message, null), status);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createBadRequestResponse(String message) {
        return new ResponseEntity<>(new ApiResponse<>(false, message, null), HttpStatus.BAD_REQUEST);
    }

    // Common response structure
    public static class ApiResponse<T> {
        private boolean success;
        private String message;
        private T data;

        public ApiResponse(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        // Getters and Setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}