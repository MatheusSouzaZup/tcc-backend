package com.TCC.TCC.BusinessExceptions;

import org.springframework.http.HttpStatus;

public class BRulesException extends RuntimeException {
    private String description;
    private HttpStatus statusCode;

    public BRulesException(String description, HttpStatus statusCode) {
        this.description = description;
        this.statusCode = statusCode;
    }

    public BRulesException(String message, String description, HttpStatus statusCode) {
        super(message);
        this.description = description;
        this.statusCode = statusCode;
    }

    public BRulesException(String message, Throwable cause, String description, HttpStatus statusCode) {
        super(message, cause);
        this.description = description;
        this.statusCode = statusCode;
    }

    public BRulesException(Throwable cause, String description, HttpStatus statusCode) {
        super(cause);
        this.description = description;
        this.statusCode = statusCode;
    }

    public BRulesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String description, HttpStatus statusCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
