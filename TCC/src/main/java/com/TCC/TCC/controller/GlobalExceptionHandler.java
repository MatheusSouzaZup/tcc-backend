package com.TCC.TCC.controller;

import com.TCC.TCC.BusinessExceptions.BRulesException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    class ExceptionOutput {
        String Description;

        public ExceptionOutput(String description) {
            Description = description;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
    }

    @ExceptionHandler(BRulesException.class)
    public ResponseEntity<Object> handleException(HttpServletRequest request, BRulesException exception) {

        ExceptionOutput result = new ExceptionOutput(exception.getDescription());
        return new ResponseEntity<>(result, new HttpHeaders(),exception.getStatusCode());

    }

}
