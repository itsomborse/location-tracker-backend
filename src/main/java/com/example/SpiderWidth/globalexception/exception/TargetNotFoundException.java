package com.example.SpiderWidth.globalexception.exception;

public class TargetNotFoundException extends RuntimeException {
    public TargetNotFoundException(String device_id) {
        super("Target With This "+device_id+" Device Id Not Found");
    }
}
