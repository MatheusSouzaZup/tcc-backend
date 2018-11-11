package com.TCC.TCC.BusinessExceptions;

import org.springframework.http.HttpStatus;

public class Exceptions {
    public static BRulesException NotFound(Object field) {
        String description = String.format("Record {%s}, not found", field.toString());
        return new BRulesException(description, HttpStatus.NOT_FOUND);
    }

    public static BRulesException SameValue(String field, String value) {
        String description = String.format("Record with field {%s} = {%s}, already exists", field, value);
        return new BRulesException(description, HttpStatus.PRECONDITION_FAILED);
    }
}
