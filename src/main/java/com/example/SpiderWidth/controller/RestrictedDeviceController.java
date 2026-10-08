package com.example.SpiderWidth.controller;

import com.example.SpiderWidth.service.RestrictedTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class RestrictedDeviceController {
    private final RestrictedTargetService targetService;

    @PutMapping("/setName")
    public ResponseEntity<String> updateUsername(@RequestParam String device_id,@RequestParam String username) {
        targetService.setTargetDeviceName(device_id,username);
        return new ResponseEntity<>(device_id+" Target Name Updated, New Name: "+username, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> eliminateDevice(@RequestHeader String id) {
        targetService.eliminateTargetDevice(id);
        return new ResponseEntity<>("Device Id "+id+" Has Eliminated",HttpStatus.OK);
    }

    @PutMapping("/time")
    public ResponseEntity<String> delayTimer(@RequestParam String device_id,@RequestHeader int delay) {
        targetService.targetDeviceDelay(device_id,delay);
        return new ResponseEntity<>(device_id+" Targets Time Updated to "+delay, HttpStatus.OK);
    }
}
