package com.example.SpiderWidth.controller;

import com.example.SpiderWidth.module.TargetPlayer;
import com.example.SpiderWidth.service.TargetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/target")
public class TargetDeviceController {
    private final TargetService service;

    @PostMapping("/post")
    public ResponseEntity<String> TargetUserAdd(@RequestBody @Valid TargetPlayer targetPlayer) {
        service.targetAddService(targetPlayer);
        return new ResponseEntity<>("Target Added", HttpStatus.CREATED);
    }
}
