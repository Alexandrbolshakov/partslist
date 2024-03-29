package com.example.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toMap;

public class ControllerUtil {

    public static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError,?,Map<String,String>> collector = toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }
}
