package com.entities;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;


@ApiModel(value = "ApiError")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError() {
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public ApiError(HttpStatus badRequest, String message) {
        this.status = badRequest;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
