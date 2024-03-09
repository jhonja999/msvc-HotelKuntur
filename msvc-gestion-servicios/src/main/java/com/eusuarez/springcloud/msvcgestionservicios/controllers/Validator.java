package com.eusuarez.springcloud.msvcgestionservicios.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    public static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach( err -> {
            errores.put(err.getField(), err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

    public static ResponseEntity<String> badRequest(BindingResult result, String str) {
        return ResponseEntity.badRequest().body(str);
    }
}
