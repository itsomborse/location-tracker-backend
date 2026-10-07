package com.example.SpiderWidth.globalexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ExceptionTaker {
    private String message;
    private String status;
    private int value;
    private LocalDateTime time;
}
