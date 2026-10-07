package com.example.SpiderWidth.globalexception.exception;

import com.example.SpiderWidth.globalexception.dto.ExceptionTaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class globalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> globalExceptionHandler(MethodArgumentNotValidException error) {
        HashMap<String,String> hashMap = new HashMap<>();
        error.getBindingResult().getAllErrors().forEach(e -> {
            String message = e.getDefaultMessage();
            String field_name = ((FieldError )e).getField();
            hashMap.put(field_name,message);
                }
                );
        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TargetNotFoundException.class)
    public ResponseEntity<ExceptionTaker> exceptionTakerResponseEntity(TargetNotFoundException error) {
        ExceptionTaker exceptionTaker = new ExceptionTaker(
                error.getLocalizedMessage(),
                HttpStatus.NOT_FOUND.toString(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionTaker,HttpStatus.NOT_FOUND);
    }


}
